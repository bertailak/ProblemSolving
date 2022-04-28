package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.Test;

public class MinimumEffortPath {

    // https://leetcode.com/problems/path-with-minimum-effort/

    public int minimumEffortPath(int[][] heights) {

        int[][] distance = new int[heights.length][heights[0].length];
        for (int i = 0; i < distance.length; i++)
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        distance[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[] { 0, 0, 0 });

        int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!pq.isEmpty()) {

            int[] current = pq.poll();
            if (distance[current[0]][current[1]] < current[2])
                continue;
            if (current[0] == heights.length - 1 && current[1] == heights[0].length - 1)
                return current[2];

            for (int i = 0; i < directions.length; i++) {
                int dx = current[0] + directions[i][0];
                int dy = current[1] + directions[i][1];

                if (dx < 0 || dx > heights.length - 1 || dy < 0 || dy > heights[0].length - 1)
                    continue;

                int de = Math.max(current[2], Math.abs(heights[dx][dy] - heights[current[0]][current[1]]));

                if (distance[dx][dy] > de) {
                    distance[dx][dy] = de;
                    pq.add(new int[] { dx, dy, de });
                }

            }

        }

        return 0;
    }

    @Test
    public void test0() {
        int[][] heights = new int[][] { { 1 } };
        int expected = 0;
        int actual = minimumEffortPath(heights);
        assertEquals(expected, actual);
    }

    @Test
    public void test00() {
        int[][] heights = new int[][] { { 1, 2 }, { 2, 3 } };
        int expected = 1;
        int actual = minimumEffortPath(heights);
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        int[][] heights = new int[][] { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } };
        int expected = 2;
        int actual = minimumEffortPath(heights);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[][] heights = new int[][] { { 1, 2, 3 }, { 3, 8, 4 }, { 5, 3, 5 } };
        int expected = 1;
        int actual = minimumEffortPath(heights);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[][] heights = new int[][] { { 1, 2, 1, 1, 1 }, { 1, 2, 1, 2, 1 }, { 1, 2, 1, 2, 1 }, { 1, 2, 1, 2, 1 },
                { 1, 1, 1, 2, 1 } };
        int expected = 0;
        int actual = minimumEffortPath(heights);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[][] heights = new int[][] { { 1, 10, 6, 7, 9, 10, 4, 9 } };
        int expected = 9;
        int actual = minimumEffortPath(heights);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        int[][] heights = new int[][] { { 4, 3, 4, 10, 5, 5, 9, 2 }, { 10, 8, 2, 10, 9, 7, 5, 6 },
                { 5, 8, 10, 10, 10, 7, 4, 2 }, { 5, 1, 3, 1, 1, 3, 1, 9 }, { 6, 4, 10, 6, 10, 9, 4, 6 } };
        int expected = 5;
        int actual = minimumEffortPath(heights);
        assertEquals(expected, actual);
    }

}