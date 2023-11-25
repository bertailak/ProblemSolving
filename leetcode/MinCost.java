package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinCost {

    // https://leetcode.com/contest/weekly-contest-316/problems/minimum-cost-to-make-array-equal/

    public long minCost(int[] nums, int[] cost) {
        int min = nums[0];
        int max = nums[0];
        long result = Long.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        if (min == max)
            return 0;

        while (min != max) {
            long minCost = 0;
            long maxCost = 0;

            for (int i = 0; i < nums.length; i++) {
                minCost += Math.abs(nums[i] - min) * cost[i];
                maxCost += Math.abs(nums[i] - max) * cost[i];
            }
            result = Math.min(minCost, maxCost);
            // System.out.println(minCost + " " + maxCost);

            if (minCost < maxCost) {
                max = min + (max - min) / 2;
            } else {
                min = min + (max - min) / 2;
            }
        }

        return result;
    }

    @Test
    public void test1() {
        assertEquals(8, minCost(new int[] { 1, 3, 5, 2 }, new int[] { 2, 3, 1, 14 }));
    }

    @Test
    public void test2() {
        assertEquals(0, minCost(new int[] { 2, 2, 2, 2, 2 }, new int[] { 4, 2, 8, 1, 3 }));
    }
}
