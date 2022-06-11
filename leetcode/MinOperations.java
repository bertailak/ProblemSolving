package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinOperations {

    // https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/

    private int binarySearch(int[] sums, int number) {
        int left = 0;
        int right = sums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sums[mid] == number) {
                return mid + 1;
            } else if (sums[mid] < number) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public int minOperations(int[] nums, int x) {
        int minStep = Integer.MAX_VALUE;

        int[] sums = new int[nums.length];

        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        int step = binarySearch(sums, x);
        if (step != -1)
            minStep = step;

        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            if (sum == x) {
                minStep = Math.min(minStep, nums.length - i);
            } else {
                int index = binarySearch(sums, x - sum);
                if (index != -1)
                    minStep = Math.min(minStep, (nums.length - i) + index);
            }
        }

        return (minStep == Integer.MAX_VALUE || minStep > nums.length) ? -1 : minStep;
    }

    @Test
    public void test1() {
        int[] nums = new int[] { 1, 1, 4, 2, 3 };
        int x = 5;
        int expected = 2;
        int actual = minOperations(nums, x);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = new int[] { 5, 6, 7, 8, 9 };
        int x = 4;
        int expected = -1;
        int actual = minOperations(nums, x);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] nums = new int[] { 3, 2, 20, 1, 1, 3 };
        int x = 10;
        int expected = 5;
        int actual = minOperations(nums, x);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[] nums = new int[] { 1, 1 };
        int x = 3;
        int expected = -1;
        int actual = minOperations(nums, x);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        int[] nums = new int[] { 1, 1 };
        int x = 2;
        int expected = 2;
        int actual = minOperations(nums, x);
        assertEquals(expected, actual);
    }

    @Test
    public void test6() {
        int[] nums = new int[] { 8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819,
                1231, 6309 };
        int x = 134365;
        int expected = 16;
        int actual = minOperations(nums, x);
        assertEquals(expected, actual);
    }
}
