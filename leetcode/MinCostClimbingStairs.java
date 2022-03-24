package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinCostClimbingStairs {
    
    // https://leetcode.com/problems/min-cost-climbing-stairs/

    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }

    @Test
    public void test1() {
        int[] cost = new int[] { 10, 15, 20 };
        int expected = 15;
        int actual = minCostClimbingStairs(cost);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] cost = new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        int expected = 6;
        int actual = minCostClimbingStairs(cost);
        assertEquals(expected, actual);
    }

}
