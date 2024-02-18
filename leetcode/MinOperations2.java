package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class MinOperations2 {

    // https://leetcode.com/contest/biweekly-contest-96/problems/minimum-operations-to-make-array-equal-ii/

    public long minOperations(int[] nums1, int[] nums2, int k) {
        long count = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for (int i = 0; i < nums2.length; i++) {
            if (nums1[i] == nums2[i])
                continue;

            if (Math.abs(nums1[i] - nums2[i]) == k)
                count++;
            else
                return -1;
        }

        return count;
    }

    @Test
    public void test2() {
        assertEquals(2, minOperations(new int[] { 4, 3, 1, 4 }, new int[] { 1, 3, 7, 1 }, 3));
    }

    @Test
    public void test1() {
        assertEquals(-1, minOperations(new int[] { 3, 8, 5, 2 }, new int[] { 2, 4, 1, 6 }, 1));
    }
}
