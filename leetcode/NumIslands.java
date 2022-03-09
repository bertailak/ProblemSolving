package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

public class NumIslands {

    // https://leetcode.com/problems/number-of-islands/

    public int numIslands(char[][] grid) {
        int island = 0;
        if (grid.length == 0)
            return island;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    island++;
                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[] { i, j });
                    while (!stack.isEmpty()) {
                        int[] current = stack.pop();
                        visited[current[0]][current[1]] = true;

                        if (current[0] - 1 >= 0
                                && !visited[current[0] - 1][current[1]]
                                && grid[current[0] - 1][current[1]] == '1') {
                            stack.push(new int[] { current[0] - 1, current[1] });
                        }
                        if (current[1] - 1 >= 0
                                && !visited[current[0]][current[1] - 1]
                                && grid[current[0]][current[1] - 1] == '1') {
                            stack.push(new int[] { current[0], current[1] - 1 });
                        }
                        if (current[0] + 1 < grid.length
                                && !visited[current[0] + 1][current[1]]
                                && grid[current[0] + 1][current[1]] == '1') {
                            stack.push(new int[] { current[0] + 1, current[1] });
                        }
                        if (current[1] + 1 < grid[0].length
                                && !visited[current[0]][current[1] + 1]
                                && grid[current[0]][current[1] + 1] == '1') {
                            stack.push(new int[] { current[0], current[1] + 1 });
                        }

                    }

                }
            }
        }

        return island;
    }

    @Test
    public void test0() {
        char[][] grid = new char[][] { { '1', '1' },
                { '0', '0' } };
        int expected = 1;
        int actual = numIslands(grid);
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        char[][] grid = new char[][] { { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' } };
        int expected = 1;
        int actual = numIslands(grid);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        char[][] grid = new char[][] { { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' } };
        int expected = 3;
        int actual = numIslands(grid);
        assertEquals(expected, actual);
    }

}
