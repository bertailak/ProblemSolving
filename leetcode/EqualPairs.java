package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EqualPairs {

    // https://leetcode.com/problems/equal-row-and-column-pairs/

    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (grid[i][k] != grid[k][j])
                        break;

                    if (k == n - 1) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    @Test
    public void test1() {
        int[][] grid = { { 3, 2, 1 }, { 1, 7, 6 }, { 2, 7, 7 } };
        int expected = 1;
        int actual = equalPairs(grid);
        assertEquals(expected, actual);
    }
}
