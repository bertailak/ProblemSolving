package leetcode;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class FindColumnWidth {
    public int[] findColumnWidth(int[][] grid) {
        int[] result = new int[grid[0].length];

        for (int i = 0; i < grid[0].length; i++) {
            int max = (grid[0][i] + "").length();
            for (int j = 1; j < grid.length; j++) {
                int len = (grid[j][i] + "").length();
                max = Math.max(max, len);
            }
            result[i] = max;
        }

        return result;
    }

    @Test
    public void test1() {
        assertArrayEquals(new int[] { 3 }, findColumnWidth(new int[][] { { 1 }, { 22 }, { 333 } }));
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[] { 3, 1, 2 },
                findColumnWidth(new int[][] { { -15, 1, 3 }, { 15, 7, 12 }, { 5, 6, -2 } }));
    }
}
