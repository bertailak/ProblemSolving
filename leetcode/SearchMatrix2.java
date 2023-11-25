package leetcode;

public class SearchMatrix2 {

    // https://leetcode.com/problems/search-a-2d-matrix-ii/

    public boolean searchMatrix(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {

            if (matrix[i][0] > target || matrix[i][matrix[i].length - 1] < target)
                continue;

            int left = 0;
            int right = matrix[i].length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }

        return false;
    }
}
