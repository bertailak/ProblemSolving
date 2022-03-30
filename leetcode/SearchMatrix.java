package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SearchMatrix {

    // https://leetcode.com/problems/search-a-2d-matrix/

    public boolean searchMatrix(int[][] matrix, int target) {

        int top = 0;
        int bottom = matrix.length - 1;
        while (top <= bottom) {
            int mid = top + (bottom - top) / 2;
            if ((matrix[mid][0] < target) && (mid + 1 == matrix.length || target < matrix[mid + 1][0])) {
                top = mid;
                break;
            } else if (matrix[mid][0] < target) {
                top = mid + 1;
            } else {
                bottom = mid - 1;
            }
        }

        int left = 0;
        int right = matrix[top].length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[top][mid] == target)
                return true;
            else if (matrix[top][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    @Test
    public void test1() {
        int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 3;
        boolean expected = true;
        boolean actual = searchMatrix(matrix, target);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 13;
        boolean expected = false;
        boolean actual = searchMatrix(matrix, target);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[][] matrix = new int[][] { { 1 } };
        int target = 2;
        boolean expected = false;
        boolean actual = searchMatrix(matrix, target);
        assertEquals(expected, actual);
    }

}
