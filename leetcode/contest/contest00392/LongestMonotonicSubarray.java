package leetcode.contest.contest00392;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LongestMonotonicSubarray {
    public int longestMonotonicSubarray(int[] nums) {
        int maxInc = 1;
        int maxDec = 1;

        int left = 0;
        int right = 0;

        while (right < nums.length) {

            if (right != 0 && nums[right - 1] >= nums[right])
                left = right;

            maxInc = Math.max(maxInc, right - left + 1);

            right++;
        }

        left = 0;
        right = 0;

        while (right < nums.length) {

            if (right != 0 && nums[right - 1] <= nums[right])
                left = right;

            maxDec = Math.max(maxDec, right - left + 1);

            right++;
        }

        return Math.max(maxInc, maxDec);
    }

    @Test
    public void test1() {
        assertEquals(2, longestMonotonicSubarray(new int[] { 1, 4, 3, 3, 2 }));
    }

    @Test
    public void test2() {
        assertEquals(1, longestMonotonicSubarray(new int[] { 3, 3, 3, 3 }));
    }

    @Test
    public void test3() {
        assertEquals(3, longestMonotonicSubarray(new int[] { 3, 2, 1 }));
    }

}
