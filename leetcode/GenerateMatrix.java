package leetcode;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class GenerateMatrix {

    // https://leetcode.com/problems/spiral-matrix-ii/

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int counter = 0;
        int top = 0;
        int left = 0;
        int right = n - 1;
        int bottom = n - 1;

        while (counter < n * n) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = ++counter;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = ++counter;
            }
            right--;
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = ++counter;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = ++counter;
            }
            left++;
        }

        return matrix;
    }

    @Test
    public void test1() {
        int n = 3;
        int[][] expecteds = new int[][] { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
        int[][] actuals = generateMatrix(n);
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void test2() {
        int n = 1;
        int[][] expecteds = new int[][] { { 1 } };
        int[][] actuals = generateMatrix(n);
        assertArrayEquals(expecteds, actuals);
    }
}
