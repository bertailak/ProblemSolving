package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinSubArrayLen {

    // https://leetcode.com/problems/minimum-size-subarray-sum/submissions/

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = nums[0];

        int min = Integer.MAX_VALUE;

        while (left < nums.length && right < nums.length) {
            if (sum < target) {
                right++;
                if (right < nums.length)
                    sum += nums[right];
                else
                    break;
            } else {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    @Test
    public void test1() {
        int target = 7;
        int[] nums = new int[] { 2, 3, 1, 2, 4, 3 };
        int expected = 2;
        int actual = minSubArrayLen(target, nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int target = 4;
        int[] nums = new int[] { 1, 4, 4 };
        int expected = 1;
        int actual = minSubArrayLen(target, nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int target = 11;
        int[] nums = new int[] { 1, 1, 1, 1, 1, 1, 1, 1 };
        int expected = 0;
        int actual = minSubArrayLen(target, nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int target = 11;
        int[] nums = new int[] { 1, 2, 3, 4, 5 };
        int expected = 3;
        int actual = minSubArrayLen(target, nums);
        assertEquals(expected, actual);
    }
}
