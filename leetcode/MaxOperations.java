package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class MaxOperations {

    // https://leetcode.com/problems/max-number-of-k-sum-pairs/

    public int maxOperations(int[] nums, int k) {
        int count = 0;
        int l = 0;
        int r = nums.length - 1;

        Arrays.sort(nums);

        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum < k) {
                l++;
            } else if (sum > k) {
                r--;
            } else {
                count++;
                l++;
                r--;
            }
        }

        return count;
    }

    @Test
    public void test1() {
        int[] nums = new int[] { 1, 2, 3, 4 };
        int k = 5;
        int expected = 2;
        int actual = maxOperations(nums, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = new int[] { 3, 1, 3, 4, 3 };
        int k = 6;
        int expected = 1;
        int actual = maxOperations(nums, k);
        assertEquals(expected, actual);
    }
}
