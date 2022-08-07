package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

public class ReachableNodes {

    // https://leetcode.com/problems/reachable-nodes-with-restrictions/

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[n];
        for (Integer integer : restricted) {
            visited[integer] = true;
        }

        for (int i = 0; i < edges.length; i++) {
            if (visited[edges[i][0]] || visited[edges[i][1]]) {
                continue;
            }
            if (!map.containsKey(edges[i][0])) {
                map.put(edges[i][0], new ArrayList<>());
            }
            map.get(edges[i][0]).add(edges[i][1]);
            if (!map.containsKey(edges[i][1])) {
                map.put(edges[i][1], new ArrayList<>());
            }
            map.get(edges[i][1]).add(edges[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        ;
        int maxCount = 0;

        while (!q.isEmpty()) {
            int top = q.poll();
            maxCount++;
            List<Integer> connections = map.getOrDefault(top, new ArrayList<>());
            for (int conn : connections) {
                if (!visited[conn]) {
                    q.add(conn);
                    visited[conn] = true;
                }
            }
        }

        return maxCount;
    }

    @Test
    public void test1() {
        int n = 7;
        int[][] edges = new int[][] { { 0, 1 }, { 1, 2 }, { 3, 1 }, { 4, 0 }, { 0, 5 }, { 5, 6 } };
        int[] restricted = new int[] { 4, 5 };
        int expected = 4;
        int actual = reachableNodes(n, edges, restricted);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int n = 7;
        int[][] edges = new int[][] { { 0, 1 }, { 0, 2 }, { 0, 5 }, { 0, 4 }, { 3, 2 }, { 6, 5 } };
        int[] restricted = new int[] { 4, 2, 1 };
        int expected = 3;
        int actual = reachableNodes(n, edges, restricted);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int n = 10;
        int[][] edges = new int[][] { { 4, 1 }, { 1, 3 }, { 1, 5 }, { 0, 5 }, { 3, 6 }, { 8, 4 }, { 5, 7 }, { 6, 9 },
                { 3, 2 } };
        int[] restricted = new int[] { 2, 7 };
        int expected = 8;
        int actual = reachableNodes(n, edges, restricted);
        assertEquals(expected, actual);
    }
}
