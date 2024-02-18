package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class MaxScore {

    // https://leetcode.com/contest/biweekly-contest-96/problems/maximum-subsequence-score/

    public long maxScore(int[] nums1, int[] nums2, int k) {

        long max = 0;

        int[][] nums = new int[nums1.length][2];
        for (int i = 0; i < nums.length; i++) {
            nums[i][0] = nums1[i];
            nums[i][1] = nums2[i];
        }

        Arrays.sort(nums, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        for (int[] is : nums) {
            System.out.println(is[0] + " " + is[1]);
        }

        for (int i = 0; i < nums.length - k + 1; i++) {
            long sum = nums[i][0];
            int min = nums[i][1];
            for (int j = i + 1; j < i + k; j++) {
                sum += nums[j][0];
                min = Math.min(min, nums[j][1]);
            }
            max = Math.max(max, sum * min);
        }

        return max;
    }

    @Test
    public void test1() {
        assertEquals(12, maxScore(new int[] { 1, 3, 3, 2 }, new int[] { 2, 1, 3, 4 }, 3));
    }

    @Test
    public void test2() {
        assertEquals(30, maxScore(new int[] { 4, 2, 3, 1, 1 }, new int[] { 7, 5, 10, 9, 6 }, 1));
    }

    @Test
    public void test3() {
        assertEquals(5, maxScore(new int[] { 1, 4 }, new int[] { 3, 1 }, 2));
    }

}
