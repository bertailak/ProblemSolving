package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LongestSubarray {
    public int longestSubarray(int[] nums) {
        int max = 0;

        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                j++;
            nums[i] = j;
        }

        int l = 0;
        int r = 0;
        while (r < nums.length) {
            while (r < nums.length && nums[r] - nums[l] < 1) {
                r++;
            }
            max = Math.max(max, r - l - 1);
            int k = l + 1;
            while (k < nums.length && nums[k] == nums[l]) {
                k++;
            }
            l = k;
        }

        return max;
    }

    @Test
    public void test1() {
        assertEquals(3, longestSubarray(new int[] { 1, 1, 0, 1 }));
    }

    @Test
    public void test2() {
        assertEquals(5, longestSubarray(new int[] { 0, 1, 1, 1, 0, 1, 1, 0, 1 }));
    }

    @Test
    public void test3() {
        assertEquals(2, longestSubarray(new int[] { 1, 1, 1 }));
    }
}
