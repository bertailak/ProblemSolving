package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountGoodStrings {

    //https://leetcode.com/problems/count-ways-to-build-good-strings/

    int mod = 1_000000000 + 7;

    public int countGoodStrings(int low, int high, int zero, int one) {
        int count = 0;

        int[] dp = backtracking(high, zero, one, 0);

        for (int i = low; i <= high; i++) {
            count = (count + dp[i]) % mod;
        }

        return count;
    }

    private int[] backtracking(int length, int zero, int one, int sb) {
        int[] dp = new int[length + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            if (i - zero >= 0)
                dp[i] = (dp[i] + dp[i - zero]) % mod;
            if (i - one >= 0)
                dp[i] = (dp[i] + dp[i - one]) % mod;
        }

        return dp;
    }

    @Test
    public void test0() {
        assertEquals(2, countGoodStrings(1, 1, 1, 1));
    }

    @Test
    public void test1() {
        assertEquals(8, countGoodStrings(3, 3, 1, 1));
    }

    @Test
    public void test2() {
        assertEquals(5, countGoodStrings(2, 3, 1, 2));
    }

    @Test
    public void test3() {
        assertEquals(764262396, countGoodStrings(200, 200, 10, 1));
    }
}
