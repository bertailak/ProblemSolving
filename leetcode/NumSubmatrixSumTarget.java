package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumSubmatrixSumTarget {

    // https://leetcode.com/problems/number-of-submatrices-that-sum-to-target

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int count = 0;

        int[][][] prefixsum = new int[matrix.length][matrix[0].length][2];

        for (int i = 0; i < matrix.length; i++) {
            prefixsum[i][0][0] = matrix[i][0];
            for (int j = 1; j < matrix[i].length; j++) {
                prefixsum[i][j][0] = matrix[i][j] + prefixsum[i][j - 1][0];
            }
        }

        for (int i = 0; i < prefixsum[0].length; i++) {
            prefixsum[0][i][1] = matrix[0][i];
            for (int j = 1; j < prefixsum.length; j++) {
                prefixsum[j][i][1] = matrix[j][i] + prefixsum[j - 1][i][1];
            }
        }

        for (int i = 0; i < prefixsum.length; i++) {
            for (int j = 0; j < prefixsum[i].length; j++) {

                for (int k = i; k < prefixsum.length; k++) {
                    for (int l = j; l < prefixsum[i].length; l++) {

                        int sum = (prefixsum[k][l][0] - (k - i - 1 >= 0 ? prefixsum[k - i - 1][l][0] : 0))
                                + (prefixsum[k][l][1] - (l - j - 1 >= 0 ? prefixsum[k][l - j - 1][1] : 0));
                        if (target == sum)
                            count++;

                    }
                }

            }
        }

        return count;
    }

    @Test
    public void test1() {
        assertEquals(4, numSubmatrixSumTarget(new int[][] { { 0, 1, 0 }, { 1, 1, 1 }, { 0, 1, 0 } }, 0));
    }

    @Test
    public void test2() {
        assertEquals(5, numSubmatrixSumTarget(new int[][] { { 1, -1 }, { -1, 1 } }, 0));
    }

    @Test
    public void test3() {
        assertEquals(0, numSubmatrixSumTarget(new int[][] { { 904 } }, 0));
    }

    @Test
    public void test4() {
        assertEquals(1, numSubmatrixSumTarget(new int[][] { { 1 } }, 1));
    }
}
