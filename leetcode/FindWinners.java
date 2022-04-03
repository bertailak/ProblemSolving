package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

public class FindWinners {

    // https://leetcode.com/problems/find-players-with-zero-or-one-losses/

    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());

        PriorityQueue<Integer> pqWinners = new PriorityQueue<>();
        PriorityQueue<Integer> pqSecondWinners = new PriorityQueue<>();

        HashMap<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < matches.length; i++) {
            int[] winnerValue = map.getOrDefault(matches[i][0], new int[] { 0, 0 });
            int[] loserValue = map.getOrDefault(matches[i][1], new int[] { 0, 0 });

            winnerValue[0]++;
            loserValue[1]++;

            map.put(matches[i][0], winnerValue);
            map.put(matches[i][1], loserValue);
        }

        for (int key : map.keySet()) {
            int[] v = map.get(key);
            if (v[1] == 0)
                pqWinners.add(key);
            if (v[1] == 1)
                pqSecondWinners.add(key);
        }

        while (!pqWinners.isEmpty()) {
            result.get(0).add(pqWinners.poll());
        }

        while (!pqSecondWinners.isEmpty()) {
            result.get(1).add(pqSecondWinners.poll());
        }

        return result;
    }

    @Test
    public void test1() {
        int[][] matches = new int[][] { { 1, 3 }, { 2, 3 }, { 3, 6 }, { 5, 6 }, { 5, 7 }, { 4, 5 }, { 4, 8 }, { 4, 9 },
                { 10, 4 }, { 10, 9 } };
        List<List<Integer>> expected = List.of(List.of(1, 2, 10), List.of(4, 5, 7, 8));
        List<List<Integer>> actual = findWinners(matches);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[][] matches = new int[][] { { 2, 3 }, { 1, 3 }, { 5, 4 }, { 6, 4 } };
        List<List<Integer>> expected = List.of(List.of(1, 2, 5, 6), List.of());
        List<List<Integer>> actual = findWinners(matches);
        assertEquals(expected, actual);
    }
}
