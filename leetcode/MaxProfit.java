package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 0;
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[l] < prices[r]) {
                profit = Math.max(profit, prices[r] - prices[l]);
            } else {
                l = r;
            }
            r++;
        }

        return profit;
    }

    @Test
    public void test1() {
        int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
        int expected = 5;
        int actual = maxProfit(prices);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] prices = new int[] { 7, 6, 4, 3, 1 };
        int expected = 0;
        int actual = maxProfit(prices);
        assertEquals(expected, actual);
    }
}
