package leetcode.contest.contest00397;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class MaxScore {

    public int maxScore(List<List<Integer>> grid) {
        int max = 0;
        int n = grid.size();
        int m = grid.get(0).size();
        int[][][] preSum = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int total = grid.get(i).get(j);
            }
        }

        return max;
    }

    @Test
    public void test1() {
        assertEquals(1, List.of(List.of(9, 5, 7, 3), List.of(8, 9, 6, 1), List.of(6, 7, 14, 3), List.of(2, 5, 3, 1)));
    }
}
