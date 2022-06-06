package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SolveNQueens {

    // https://leetcode.com/problems/n-queens/

    int[][] directions = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
            { 1, 1 } };

    List<List<String>> list;
    boolean[][] path;

    public List<List<String>> solveNQueens(int n) {
        list = new ArrayList<>();
        path = new boolean[n][n];
        StringBuilder[] sb = new StringBuilder[n];
        StringBuilder dots = new StringBuilder();
        for (int i = 0; i < n; i++) {
            dots.append('.');
        }
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder(dots.toString());
        }

        backtracking(sb, n, 0);

        return list;
    }

    public void backtracking(StringBuilder sb[], int n, int index) {
        if (index == n) {
            List<String> str = new ArrayList<>();
            for (int i = 0; i < sb.length; i++) {
                str.add(sb[i].toString());
            }
            list.add(str);
            return;
        }

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
                backtracking(sb, n, index + 1);
                sb[index].setCharAt(i, '.');

                path[index][i] = false;
                for (int[] ps : positions) {
                    path[ps[0]][ps[1]] = false;
                }
            }
        }

    }

    @Test
    public void test1() {
        int n = 1;
        List<List<String>> expected = List.of(List.of("Q"));
        List<List<String>> actual = solveNQueens(n);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int n = 4;
        List<List<String>> expected = List.of(List.of(".Q..", "...Q", "Q...", "..Q."),
                List.of("..Q.", "Q...", "...Q", ".Q.."));
        List<List<String>> actual = solveNQueens(n);
        assertEquals(expected, actual);
    }
}
