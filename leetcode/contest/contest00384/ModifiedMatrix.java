package leetcode.contest.contest00384;

import java.util.Arrays;

public class ModifiedMatrix {

    // https://leetcode.com/problems/modify-the-matrix/description/

    public int[][] modifiedMatrix(int[][] matrix) {

        int[] maxArray = new int[matrix[0].length];
        Arrays.fill(maxArray, -1);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                maxArray[j] = Math.max(maxArray[j], matrix[i][j]);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == -1)
                    matrix[i][j] = maxArray[j];
            }
        }

        return matrix;
    }

    public int[][] modifiedMatrix2(int[][] matrix) {

    for (int j = 0; j < matrix[0].length; j++) {
        int max = -1;

        for (int i = 0; i < matrix.length; i++) {
            max = Math.max(max, matrix[i][j]);
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][j] == -1)
                matrix[i][j] = max;
        }

    }

        return matrix;
    }
}