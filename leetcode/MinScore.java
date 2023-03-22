package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

public class MinScore {

    // https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/

    public int minScore(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            graph.get(road[0] - 1).add(new int[] { road[1] - 1, road[2] });
            graph.get(road[1] - 1).add(new int[] { road[0] - 1, road[2] });
        }

        int min = graph.get(0).get(0)[1];

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while (!q.isEmpty()) {
            int top = q.poll();
            if (visited[top])
                continue;

            visited[top] = true;

            for (int[] l : graph.get(top)) {
                q.add(l[0]);
                min = Math.min(min, l[1]);
            }

        }

        return min;
    }

    @Test
    public void test1() {
        assertEquals(5, minScore(4, new int[][] {
                { 1, 2, 9 },
                { 2, 3, 6 },
                { 2, 4, 5 },
                { 1, 4, 7 } }));
    }
}
