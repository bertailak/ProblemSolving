package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MaximumUniqueSubarray {

    // https://leetcode.com/problems/maximum-erasure-value/

    public int maximumUniqueSubarray(int[] nums) {
        int sum = 0;
        int maxSum = 0;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

            if (list.contains(nums[i])) {
                int index = list.indexOf(nums[i]);
                while (index-- >= 0) {
                    sum -= list.get(0);
                    list.remove(0);
                }
            }

            list.add(nums[i]);
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    @Test
    public void test1() {
        int[] nums = new int[] { 4, 2, 4, 5, 6 };
        int expected = 17;
        int actual = maximumUniqueSubarray(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = new int[] { 5, 2, 1, 2, 5, 2, 1, 2, 5 };
        int expected = 8;
        int actual = maximumUniqueSubarray(nums);
        assertEquals(expected, actual);
    }
}
