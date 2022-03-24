package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UniquePaths {

    // https://leetcode.com/problems/unique-paths/

    public int uniquePaths(int m, int n) {
        int[][] a = new int[m][n];

        for (int i = 0; i < m; i++) {
            a[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            a[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                a[i][j] = a[i - 1][j] + a[i][j - 1];
            }
        }

        return a[m - 1][n - 1];
    }

    @Test
    public void test1() {
        int m = 3;
        int n = 7;
        int expected = 28;
        int actual = uniquePaths(m, n);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int m = 3;
        int n = 2;
        int expected = 3;
        int actual = uniquePaths(m, n);
        assertEquals(expected, actual);
    }

}
