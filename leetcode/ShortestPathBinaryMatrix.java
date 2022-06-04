package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class ShortestPathBinaryMatrix {

    // https://leetcode.com/problems/shortest-path-in-binary-matrix/

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1)
            return -1;
        if (n == 1)
            return 1;

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        int[][] directions = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
                { 1, 1 } };

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0 });
        int step = 1;

        while (!queue.isEmpty()) {
            step++;
            for (int i = queue.size() - 1; i >= 0; i--) {
                int[] top = queue.poll();

                for (int j = 0; j < directions.length; j++) {
                    if (0 <= top[0] + directions[j][0] && top[0] + directions[j][0] < n
                            && 0 <= top[1] + directions[j][1] && top[1] + directions[j][1] < n
                            && grid[top[0] + directions[j][0]][top[1] + directions[j][1]] == 0
                            && !visited[top[0] + directions[j][0]][top[1] + directions[j][1]]) {
                        if (top[0] + directions[j][0] == n - 1 && top[1] + directions[j][1] == n - 1) {
                            return step;
                        }
                        queue.add(new int[] { top[0] + directions[j][0], top[1] + directions[j][1] });
                        visited[top[0] + directions[j][0]][top[1] + directions[j][1]] = true;
                    }
                }

            }

        }

        return -1;
    }

    @Test
    public void test1() {
        int[][] grid = new int[][] { { 0, 1 }, { 1, 0 } };
        int expected = 2;
        int actual = shortestPathBinaryMatrix(grid);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[][] grid = new int[][] { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
        int expected = 4;
        int actual = shortestPathBinaryMatrix(grid);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[][] grid = new int[][] { { 1, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
        int expected = -1;
        int actual = shortestPathBinaryMatrix(grid);
        assertEquals(expected, actual);
    }
}