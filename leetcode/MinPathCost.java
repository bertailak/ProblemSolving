package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinPathCost {

    // https://leetcode.com/problems/minimum-path-cost-in-a-grid/

    public int minPathCost(int[][] grid, int[][] moveCost) {
        int[][] values = new int[grid.length][grid[0].length];
        for (int i = 1; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                values[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < values.length - 1; i++) {

            for (int j = 0; j < values[i].length; j++) {

                for (int k = 0; k < values[i].length; k++) {
                    int cost = values[i][j] + grid[i][j] + moveCost[grid[i][j]][k];
                    values[i + 1][k] = Math.min(values[i + 1][k], cost);
                }

            }

        }

        int min = grid[grid.length - 1][0] + values[values.length - 1][0];
        for (int i = 1; i < values[values.length - 1].length; i++) {
            min = Math.min(min, grid[grid.length - 1][i] + values[values.length - 1][i]);
        }
        return min;
    }

    @Test
    public void test2() {
        int[][] grid = new int[][] { { 5, 3 }, { 4, 0 }, { 2, 1 } };
        int[][] moveCost = new int[][] { { 9, 8 }, { 1, 5 }, { 10, 12 }, { 18, 6 }, { 2, 4 }, { 14, 3 } };
        int expected = 17;
        int actual = minPathCost(grid, moveCost);
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        int[][] grid = new int[][] { { 5, 1, 2 }, { 4, 0, 3 } };
        int[][] moveCost = new int[][] { { 12, 10, 15 }, { 20, 23, 8 }, { 21, 7, 1 }, { 8, 1, 13 }, { 9, 10, 25 },
                { 5, 3, 2 } };
        int expected = 6;
        int actual = minPathCost(grid, moveCost);
        assertEquals(expected, actual);
    }
}
