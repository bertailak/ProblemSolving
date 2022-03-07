package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class MinimalKSum {

    // https://leetcode.com/problems/append-k-integers-with-minimal-sum/

    public long minimalKSum(int[] nums, int k) {
        long sum = (1L * k * (k + 1)) / 2;

        nums = Arrays.stream(nums).distinct().sorted().toArray();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= k) {
                sum -= nums[i];
                sum += ++k;
            }
        }

        return sum;
    }

    @Test
    public void test0() {
        int[] nums = new int[] { 5, 6, 6, 7 };
        int k = 6;
        long expected = 27;
        long actual = minimalKSum(nums, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        int[] nums = new int[] { 1, 4, 25, 10, 25 };
        int k = 2;
        long expected = 5;
        long actual = minimalKSum(nums, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = new int[] { 5, 6 };
        int k = 6;
        long expected = 25;
        long actual = minimalKSum(nums, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] nums = new int[] { 96, 44, 99, 25, 61, 84, 88, 18, 19, 33, 60, 86, 52, 19, 32, 47, 35, 50, 94, 17, 29, 98,
                22, 21, 72, 100, 40, 84 };
        int k = 35;
        long expected = 794;
        long actual = minimalKSum(nums, k);
        assertEquals(expected, actual);
    }

}
