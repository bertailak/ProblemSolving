package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SubarraySum {

    // https://leetcode.com/problems/subarray-sum-equals-k/

    public int subarraySum(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int sum = nums[0];
        int count = 0;

        while (left < nums.length || right < nums.length) {
            if (left > right || (right < nums.length && sum <= k)) {
                right++;
                if (right < nums.length) {
                    sum += nums[right];
                    if (sum == k) {
                        count++;
                    }
                }
            } else {
                sum -= nums[left];
                left++;
                if (left < nums.length - 1 && sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    @Test
    public void test1() {
        int[] nums = new int[] { 1, 1, 1 };
        int k = 2;
        int expected = 2;
        int actual = subarraySum(nums, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = new int[] { 1, 2, 3 };
        int k = 3;
        int expected = 2;
        int actual = subarraySum(nums, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] nums = new int[] { 1, 2, 1, 2, 1 };
        int k = 3;
        int expected = 4;
        int actual = subarraySum(nums, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[] nums = new int[] { -1, -1, 1 };
        int k = 0;
        int expected = 1;
        int actual = subarraySum(nums, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        int[] nums = new int[] { 1, -1, 0 };
        int k = 0;
        int expected = 3;
        int actual = subarraySum(nums, k);
        assertEquals(expected, actual);
    }
}
