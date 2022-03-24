package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinPathSum {

    // https://leetcode.com/problems/minimum-path-sum/

    public int minPathSum(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0) {
                    if (j != 0)
                        grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }

    @Test
    public void test1() {
        int[][] grid = new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        int expected = 7;
        int actual = minPathSum(grid);
        assertEquals(expected, actual);
    }
}
