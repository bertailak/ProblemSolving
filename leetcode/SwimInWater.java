package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.Test;

public class SwimInWater {

    // https://leetcode.com/problems/swim-in-rising-water/

    public int swimInWater(int[][] grid) {
        int[][] distance = new int[grid.length][grid[0].length];
        for (int i = 0; i < distance.length; i++)
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        distance[0][0] = grid[0][0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[] { 0, 0, grid[0][0] });

        int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!pq.isEmpty()) {

            int[] current = pq.poll();
            if (distance[current[0]][current[1]] < current[2])
                continue;
            if (current[0] == grid.length - 1 && current[1] == grid[0].length - 1)
                return current[2];

            for (int i = 0; i < directions.length; i++) {
                int dx = current[0] + directions[i][0];
                int dy = current[1] + directions[i][1];

                if (dx < 0 || dx > grid.length - 1 || dy < 0 || dy > grid[0].length - 1)
                    continue;

                int de = Math.max(current[2], grid[dx][dy]);

                if (distance[dx][dy] > de) {
                    distance[dx][dy] = de;
                    pq.add(new int[] { dx, dy, de });
                }

            }

        }

        return 0;
    }

    @Test
    public void test1() {
        int[][] grid = new int[][] { { 0, 2 }, { 1, 3 } };
        int expected = 3;
        int actual = swimInWater(grid);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[][] grid = new int[][] { { 0, 1, 2, 3, 4 }, { 24, 23, 22, 21, 5 }, { 12, 13, 14, 15, 16 },
                { 11, 17, 18, 19, 20 }, { 10, 9, 8, 7, 6 } };
        int expected = 16;
        int actual = swimInWater(grid);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[][] grid = new int[][] { { 3, 2 }, { 0, 1 } };
        int expected = 3;
        int actual = swimInWater(grid);
        assertEquals(expected, actual);
    }
}
