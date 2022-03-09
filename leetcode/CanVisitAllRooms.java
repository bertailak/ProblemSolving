package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

public class CanVisitAllRooms {

    // https://leetcode.com/problems/keys-and-rooms/

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        Queue<Integer> q = new LinkedList<>();
        for (Integer room : rooms.get(0)) {
            q.add(room);
        }
        visited[0] = true;

        while (!q.isEmpty()) {

            Integer current = q.poll();
            visited[current] = true;

            for (Integer room : rooms.get(current)) {
                if (!visited[room]) {
                    q.add(room);
                }
            }

        }

        for (boolean b : visited) {
            if (!b)
                return false;
        }

        return true;
    }

    @Test
    public void test1() {
        List<List<Integer>> rooms = List.of(
                List.of(1),
                List.of(2),
                List.of(3),
                List.of());
        boolean expected = true;
        boolean actual = canVisitAllRooms(rooms);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        List<List<Integer>> rooms = List.of(
                List.of(1, 3),
                List.of(3, 0, 1),
                List.of(2),
                List.of(0));
        boolean expected = false;
        boolean actual = canVisitAllRooms(rooms);
        assertEquals(expected, actual);
    }

}
