package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Transpose {

    // https://leetcode.com/problems/transpose-matrix/

    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] result = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    @Test
    public void test1() {
        int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };
        int[][] expected = new int[][] { { 1, 4 }, { 2, 5 }, { 3, 6 } };
        int[][] actual = transpose(matrix);
        assertEquals(expected, actual);
    }
}
