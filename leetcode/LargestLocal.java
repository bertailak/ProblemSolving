package leetcode;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class LargestLocal {

    public int[][] largestLocal(int[][] grid) {
        
        int[][] maxLocal = new int[grid.length - 2][grid.length - 2];

        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid.length - 2; j++) {
                maxLocal[i][j] = getMaxLocal(grid, i, j);
            }
        }

        return maxLocal;
    }

    public int getMaxLocal(int[][] grid, int x, int y) {
        int max = grid[x][y];
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }

    @Test
    public void test1() {
        int[][] grid = { { 9, 9, 8, 1 }, { 5, 6, 2, 6 }, { 8, 2, 6, 4 }, { 6, 2, 2, 2 } };
        int[][] expecteds = { { 9, 9 }, { 8, 6 } };
        int[][] actuals = largestLocal(grid);
        assertArrayEquals(expecteds, actuals);
    }

}
