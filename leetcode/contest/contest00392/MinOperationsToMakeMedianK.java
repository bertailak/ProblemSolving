package leetcode.contest.contest00392;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class MinOperationsToMakeMedianK {

    public long minOperationsToMakeMedianK(int[] nums, int k) {
        long count = 0;

        Arrays.sort(nums);

        int mid = nums.length / 2;

        while (mid < nums.length && nums[mid] < k) {
            count += k - nums[mid];
            nums[mid] = k;
            mid++;
        }

        mid = nums.length / 2;
        while (mid >= 0 && nums[mid] > k) {
            count += nums[mid] - k;
            nums[mid] = k;
            mid--;
        }

        return count;
    }

    @Test
    public void test1() {
        assertEquals(2, minOperationsToMakeMedianK(new int[] { 2, 5, 6, 8, 5 }, 4));
    }

    @Test
    public void test2() {
        assertEquals(3, minOperationsToMakeMedianK(new int[] { 2, 5, 6, 8, 5 }, 7));
    }

    @Test
    public void test3() {
        assertEquals(0, minOperationsToMakeMedianK(new int[] { 1, 2, 3, 4, 5, 6 }, 4));
    }

    @Test
    public void test4() {
        assertEquals(999999999, minOperationsToMakeMedianK(new int[] { 1000000000 }, 1));
    }
}
