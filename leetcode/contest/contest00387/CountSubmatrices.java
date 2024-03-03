package leetcode.contest.contest00387;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountSubmatrices {

    public int countSubmatrices(int[][] grid, int k) {
        int count = 0;
        if (grid[0][0] > k) {
            return count;
        }

        int[][] presum = new int[grid.length][grid[0].length];
        presum[0][0] = grid[0][0];

        for (int i = 0; i < presum[0].length; i++) {
            for (int j = 0; j < presum.length; j++) {
                presum[j][i] = (j == 0 ? 0 : presum[j - 1][i]) + grid[j][i];
            }
        }

        for (int i = 0; i < presum.length; i++) {
            int curr = 0;
            for (int j = 0; j < presum[0].length; j++) {
                curr += presum[i][j];
                if (curr <= k)
                    count++;
                else
                    break;
            }
        }

        return count;
    }

    @Test
    public void test1() {
        assertEquals(4, countSubmatrices(new int[][] { { 7, 6, 3 }, { 6, 6, 1 } }, 18));
    }

    @Test
    public void test2() {
        assertEquals(6, countSubmatrices(new int[][] { { 7, 2, 9 }, { 1, 5, 0 }, { 2, 6, 6 } }, 20));
    }

    @Test
    public void test3() {
        assertEquals(4, countSubmatrices(new int[][] { { 1, 2 }, { 3, 4 } }, 20));
    }

    @Test
    public void test4() {
        assertEquals(1, countSubmatrices(new int[][] { { 5 }, { 9 }, { 9 } }, 8));
    }
}
