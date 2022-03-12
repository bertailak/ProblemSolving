package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class CoinChange {

    // https://leetcode.com/problems/coin-change/

    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;

        int[] counts = new int[amount + 1];
        Arrays.fill(counts, Integer.MAX_VALUE);
        counts[0] = 0;

        for (int i = 1; i < counts.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && counts[i - coins[j]] != Integer.MAX_VALUE)
                    counts[i] = Math.min(counts[i], counts[i - coins[j]] + 1);
            }
        }

        return counts[counts.length - 1] == Integer.MAX_VALUE ? -1 : counts[counts.length - 1];
    }

    @Test
    public void test1() {
        int[] coins = new int[] { 1, 2, 5 };
        int amount = 11;
        int expected = 3;
        int actual = coinChange(coins, amount);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] coins = new int[] { 2 };
        int amount = 3;
        int expected = -1;
        int actual = coinChange(coins, amount);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] coins = new int[] { 1 };
        int amount = 0;
        int expected = 0;
        int actual = coinChange(coins, amount);
        assertEquals(expected, actual);
    }

}
