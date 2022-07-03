package leetcode;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import leetcode.model.ListNode;

public class SpiralMatrix {

    // https://leetcode.com/contest/weekly-contest-300/problems/spiral-matrix-iv/

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = -1;
            }
        }

        int top = 0;
        int left = 0;
        int right = n - 1;
        int bottom = m - 1;

        while (head != null && (top <= bottom && left <= right)) {

            for (int i = left; i <= right; i++) {
                if (head != null) {
                    matrix[top][i] = head.val;
                    head = head.next;
                } else
                    break;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                if (head != null) {
                    matrix[i][right] = head.val;
                    head = head.next;
                } else
                    break;
            }
            right--;

            for (int i = right; i >= left; i--) {
                if (head != null) {
                    matrix[bottom][i] = head.val;
                    head = head.next;
                } else
                    break;
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                if (head != null) {
                    matrix[i][left] = head.val;
                    head = head.next;
                } else
                    break;
            }
            left++;
        }

        return matrix;
    }

    @Test
    public void test1() {
        int m = 3;
        int n = 5;
        ListNode head = ListNode.insertByOrder(new int[] { 3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0 });
        int[][] expecteds = new int[][] { { 3, 0, 2, 6, 8 }, { 5, 0, -1, -1, 1 }, { 5, 2, 4, 9, 7 } };
        int[][] actuals = spiralMatrix(m, n, head);
        assertArrayEquals(expecteds, actuals);
    }
}
