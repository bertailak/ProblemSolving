package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TotalNQueens {

    // https://leetcode.com/problems/n-queens-ii/

    int[][] directions = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
            { 1, 1 } };

    boolean[][] path;

    public int totalNQueens(int n) {

        path = new boolean[n][n];
        StringBuilder[] sb = new StringBuilder[n];
        StringBuilder dots = new StringBuilder();
        for (int i = 0; i < n; i++) {
            dots.append('.');
        }
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder(dots.toString());
        }

        return backtracking(sb, n, 0);
    }

    public int backtracking(StringBuilder sb[], int n, int index) {
        if (index == n) {
            return 1;
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!path[index][i]) {
                path[index][i] = true;

                List<int[]> positions = new ArrayList<>();
                for (int[] dir : directions) {
                    int k = 1;
                    while ((k * dir[0] + index >= 0 && k * dir[0] + index < n)
                            && (k * dir[1] + i >= 0 && k * dir[1] + i < n)) {
                        if (!path[k * dir[0] + index][k * dir[1] + i]) {
                            path[k * dir[0] + index][k * dir[1] + i] = true;
                            positions.add(new int[] { k * dir[0] + index, k * dir[1] + i });
                        }
                        k++;
                    }

                }

                sb[index].setCharAt(i, 'Q');
                count += backtracking(sb, n, index + 1);
                sb[index].setCharAt(i, '.');

                path[index][i] = false;
                for (int[] ps : positions) {
                    path[ps[0]][ps[1]] = false;
                }
            }
        }
        return count;
    }

    @Test
    public void test1() {
        int n = 1;
        int expected = 1;
        int actual = totalNQueens(n);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int n = 4;
        int expected = 2;
        int actual = totalNQueens(n);
        assertEquals(expected, actual);
    }

}
