package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountPaths {

    // https://leetcode.com/problems/number-of-increasing-paths-in-a-grid/

    int[][] dir = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    int mod = 1_000000000 + 7;

    public int countPaths(int[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                visited[i][j] = true;

                count = (count + countPaths(grid, visited, i, j)) % mod;

                visited[i][j] = false;
            }
        }

        return count;
    }

    public int countPaths(int[][] grid, boolean[][] visited, int x, int y) {
        int count = 1;

        for (int i = 0; i < dir.length; i++) {

            int dirx = x + dir[i][0];
            int diry = y + dir[i][1];

            if ((0 <= dirx && dirx < grid.length)
                    && (0 <= diry && diry < grid[0].length)
                    && !visited[dirx][diry]
                    && grid[x][y] < grid[dirx][diry]) {
                visited[dirx][diry] = true;
                count = (count + countPaths(grid, visited, dirx, diry)) % mod;
                visited[dirx][diry] = false;
            }

        }

        return count;
    }

    @Test
    public void test1() {
        int[][] grid = new int[][] { { 1, 1 }, { 3, 4 } };
        int expected = 8;
        int actual = countPaths(grid);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[][] grid = new int[][] { { 1 }, { 2 } };
        int expected = 3;
        int actual = countPaths(grid);
        assertEquals(expected, actual);
    }
}
