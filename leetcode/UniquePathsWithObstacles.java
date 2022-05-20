package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UniquePathsWithObstacles {

    // https://leetcode.com/problems/unique-paths-ii/

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int[][] grid = new int[obstacleGrid.length][obstacleGrid[0].length];
        grid[0][0] = 1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (obstacleGrid[i][j] == 0) {
                    if (i > 0)
                        grid[i][j] += grid[i - 1][j];
                    if (j > 0)
                        grid[i][j] += grid[i][j - 1];
                }
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }

    @Test
    public void test1() {
        int[][] obstacleGrid = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        int expected = 2;
        int actual = uniquePathsWithObstacles(obstacleGrid);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[][] obstacleGrid = new int[][] { { 0, 1 }, { 0, 0 } };
        int expected = 1;
        int actual = uniquePathsWithObstacles(obstacleGrid);
        assertEquals(expected, actual);
    }
}
