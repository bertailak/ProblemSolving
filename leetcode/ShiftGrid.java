package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ShiftGrid {

    // https://leetcode.com/problems/shift-2d-grid/

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> table = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;

        k = k % (m * n);

        while (k > 0) {
            int temp = grid[n - 1][m - 1];
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    if (i == 0 && j == 0) {
                        grid[0][0] = temp;
                    } else if (j == 0) {
                        grid[i][j] = grid[i - 1][m - 1];
                    } else {
                        grid[i][j] = grid[i][j - 1];
                    }
                }
            }
            k--;
        }

        for (int i = 0; i < grid.length; i++) {
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j < grid[0].length; j++) {
                l.add(grid[i][j]);
            }
            table.add(l);
        }

        return table;
    }

    @Test
    public void test1() {
        int[][] grid = new int[][] { { 1 }, { 3 } };
        int k = 1;
        List<List<Integer>> expecteds = List.of(List.of(3), List.of(1));
        List<List<Integer>> actuals = shiftGrid(grid, k);
        assertEquals(expecteds, actuals);
    }

    @Test
    public void test2() {
        int[][] grid = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int k = 1;
        List<List<Integer>> expecteds = List.of(List.of(9, 1, 2), List.of(3, 4, 5), List.of(6, 7, 8));
        List<List<Integer>> actuals = shiftGrid(grid, k);
        assertEquals(expecteds, actuals);
    }

    @Test
    public void test3() {
        int[][] grid = new int[][] { { 3, 8, 1, 9 }, { 19, 7, 2, 5 }, { 4, 6, 11, 10 }, { 12, 0, 21, 13 } };
        int k = 4;
        List<List<Integer>> expecteds = List.of(List.of(12, 0, 21, 13), List.of(3, 8, 1, 9), List.of(19, 7, 2, 5),
                List.of(4, 6, 11, 10));
        List<List<Integer>> actuals = shiftGrid(grid, k);
        assertEquals(expecteds, actuals);
    }
}
