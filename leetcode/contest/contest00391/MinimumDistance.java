package leetcode.contest.contest00391;

import static org.junit.Assert.assertEquals;

import java.util.PriorityQueue;

import org.junit.Test;

public class MinimumDistance {

    public int minimumDistance(int[][] points) {
        int min = Integer.MAX_VALUE;

        int[][] graph = new int[points.length][points.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                graph[i][j] = dist;
                graph[j][i] = dist;
                pq.add(new int[] { dist, i, j });
            }

        }

        int top = pq.peek()[0];
        while (!pq.isEmpty() && top == pq.peek()[0]) {
            int max1 = 0;
            int max2 = 0;
            int[] t = pq.poll();
            for (int i = 0; i < graph.length; i++) {
                if (i != t[2])
                    max1 = Math.max(max1, graph[t[1]][i]);
                if (i != t[1])
                    max2 = Math.max(max2, graph[t[2]][i]);
            }
            min = Math.min(min, Math.min(max1, max2));
        }

        return min;
    }

    @Test
    public void test1() {
        assertEquals(12, minimumDistance(new int[][] { { 3, 10 }, { 5, 15 }, { 10, 2 }, { 4, 4 } }));
    }

    @Test
    public void test2() {
        assertEquals(0, minimumDistance(new int[][] { { 1, 1 }, { 1, 1 }, { 1, 1 } }));
    }

    @Test
    public void test3() {
        assertEquals(13, minimumDistance(new int[][] { { 9, 8 }, { 1, 8 }, { 3, 1 }, { 9, 1 }, { 7, 7 }, { 3, 6 } }));
    }
}
