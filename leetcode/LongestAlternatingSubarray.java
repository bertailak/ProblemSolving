package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LongestAlternatingSubarray {

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int max = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > threshold || nums[i] % 2 == 1)
                continue;

            int r = i;

            while (r + 1 < nums.length && nums[r + 1] <= threshold && nums[r] % 2 != nums[r + 1] % 2) {
                r++;
            }

            max = Math.max(max, r - i + 1);

        }

        return max;
    }

    @Test
    public void test1() {
        assertEquals(3, longestAlternatingSubarray(new int[] { 3, 2, 5, 4 }, 5));
        assertEquals(1, longestAlternatingSubarray(new int[] { 1, 2 }, 2));
        assertEquals(3, longestAlternatingSubarray(new int[] { 2, 3, 4, 5 }, 4));
    }

    @Test
    public void test2() {
        assertEquals(1, longestAlternatingSubarray(new int[] { 2, 2 }, 18));
    }

    @Test
    public void test3() {
        assertEquals(2, longestAlternatingSubarray(new int[] { 4, 3, 1 }, 4));
    }

}