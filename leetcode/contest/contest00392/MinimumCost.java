package leetcode.contest.contest00392;

import static org.junit.Assert.assertArrayEquals;

import java.util.HashMap;
import java.util.Stack;

import org.junit.Test;

public class MinimumCost {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] result = new int[query.length];

        int[][] graph = new int[n][n];

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                graph[i][j] = -1;
            }
        }

        for (int i = 0; i < edges.length; i++) {
            if (graph[edges[i][0]][edges[i][1]] == 0) {
                graph[edges[i][0]][edges[i][1]] = edges[i][2];
            } else {
                graph[edges[i][0]][edges[i][1]] = ((graph[edges[i][0]][edges[i][1]]) & edges[i][2]);
            }
            if (graph[edges[i][1]][edges[i][0]] == 0) {
                graph[edges[i][1]][edges[i][0]] = edges[i][2] + 1;
            } else {
                graph[edges[i][1]][edges[i][0]] = ((graph[edges[i][0]][edges[i][1]]) & edges[i][2]);
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int[] unions = new int[n];
        int set = 1;
        for (int i = 0; i < unions.length; i++) {
            if (unions[0] > 0)
                continue;

            Stack<Integer> st = new Stack<>();
            st.add(i);
            int minCost = Integer.MAX_VALUE;
            unions[i] = set;

            while (!st.isEmpty()) {
                int top = st.pop();

                unions[top] = set;

                for (int j = 0; j < unions.length; j++) {
                    if (graph[top][j] == -1 || unions[j] > 0)
                        continue;
                    st.add(j);
                    unions[j] = set;
                    minCost = minCost & graph[top][j];
                }

            }

            if (minCost == Integer.MAX_VALUE) {
                minCost = -1;
            }
            map.put(set, minCost);

            set++;
        }

        for (int i = 0; i < query.length; i++) {
            if (unions[query[i][0]] == unions[query[i][1]]) {
                result[i] = map.get(unions[query[i][0]]);
            } else {
                result[i] = -1;
            }
        }

        return result;
    }

    @Test
    public void test1() {
        assertArrayEquals(new int[] { 1, -1 }, minimumCost(5, new int[][] { { 0, 1, 7 }, { 1, 3, 7 }, { 1, 2, 1 } },
                new int[][] { { 0, 3 }, { 3, 4 } }));
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[] { 0 },
                minimumCost(3, new int[][] { { 0, 2, 7 }, { 0, 1, 15 }, { 1, 2, 6 }, { 1, 2, 1 } },
                        new int[][] { { 1, 2 } }));
    }
}
