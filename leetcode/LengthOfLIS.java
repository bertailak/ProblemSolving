package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LengthOfLIS {

    // https://leetcode.com/problems/longest-increasing-subsequence/

    public int lengthOfLIS(int[] nums) {
        int[] lengths = new int[nums.length];
        lengths[0] = 1;
        int maxLength = lengths[0];

        for (int i = 1; i < nums.length; i++) {

            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    max = Math.max(max, lengths[j]);
            }
            lengths[i] = max + 1;
            maxLength = Math.max(maxLength, lengths[i]);
        }

        return maxLength;
    }

    @Test
    public void test1() {
        int[] nums = new int[] { 10, 9, 2, 5, 3, 7, 101, 18 };
        int expected = 4;
        int actual = lengthOfLIS(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = new int[] { 0, 1, 0, 3, 2, 3 };
        int expected = 4;
        int actual = lengthOfLIS(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] nums = new int[] { 7, 7, 7, 7, 7, 7, 7 };
        int expected = 1;
        int actual = lengthOfLIS(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[] nums = new int[] { 1, 3, 6, 7, 9, 4, 10, 5, 6 };
        int expected = 6;
        int actual = lengthOfLIS(nums);
        assertEquals(expected, actual);
    }

}
