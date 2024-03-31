package leetcode.contest.contest00391;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountAlternatingSubarrays {

    public long countAlternatingSubarrays(int[] nums) {
        long count = 0;

        int left = 0;
        int right = 0;

        while (right < nums.length) {

            if (right > 0 && nums[right - 1] == nums[right]) {
                left = right;
            }

            count += right - left + 1;

            right++;
        }

        return count;
    }

    @Test
    public void test1() {
        assertEquals(5, countAlternatingSubarrays(new int[] { 0, 1, 1, 1 }));
    }

    @Test
    public void test2() {
        assertEquals(10, countAlternatingSubarrays(new int[] { 1, 0, 1, 0 }));
    }
}
