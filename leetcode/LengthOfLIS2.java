package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LengthOfLIS2 {

    // https://leetcode.com/problems/longest-increasing-subsequence-ii/

    public int lengthOfLIS(int[] nums, int k) {
        int maxValue = nums[0];
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }
        int[] dp = new int[maxValue + 1];

        for (int num : nums) {
            int currentMax = 0;
            for (int i = Math.max(num - k, 0); i < num; i++) {
                currentMax = Math.max(currentMax, dp[i]);
            }
            dp[num] = currentMax + 1;
        }
        int longSequence = 1;
        for (int i = 0; i < dp.length; i++) {
            longSequence = Math.max(longSequence, dp[i]);
        }

        return longSequence;
    }

    @Test
    public void test1() {
        assertEquals(5, lengthOfLIS(new int[] { 4, 2, 1, 4, 3, 4, 5, 8, 15 }, 3));
    }

    @Test
    public void test2() {
        assertEquals(4, lengthOfLIS(new int[] { 7, 4, 5, 1, 8, 12, 4, 7 }, 5));
    }

    @Test
    public void test3() {
        assertEquals(1, lengthOfLIS(new int[] { 1, 5 }, 1));
    }

    @Test
    public void test4() {
        assertEquals(4, lengthOfLIS(new int[] { 1,100,500,100000,100000 }, 100000));
    }
}
