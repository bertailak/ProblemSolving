package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DeleteAndEarn {

    // https://leetcode.com/problems/delete-and-earn/

    public int deleteAndEarn(int[] nums) {
        int max = nums[0];
        int[] values = new int[10001];
        for (int i = 0; i < nums.length; i++) {
            values[nums[i]] += nums[i];
            max = Math.max(max, nums[i]);
        }
        for (int i = 1; i < max; i++) {
            values[i + 1] = Math.max(values[i], values[i - 1] + values[i + 1]);
        }

        return Math.max(values[max], values[max - 1]);
    }

    @Test
    public void test0() {
        int[] nums = new int[] { 1, 2 };
        int expected = 2;
        int actual = deleteAndEarn(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        int[] nums = new int[] { 3, 4, 2 };
        int expected = 6;
        int actual = deleteAndEarn(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = new int[] { 2, 2, 3, 3, 3, 4 };
        int expected = 9;
        int actual = deleteAndEarn(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] nums = new int[] { 8, 3, 4, 7, 6, 6, 9, 2, 5, 8, 2, 4, 9, 5, 9, 1, 5, 7, 1, 4 };
        int expected = 61;
        int actual = deleteAndEarn(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[] nums = new int[] { 8, 10, 4, 9, 1, 3, 5, 9, 4, 10 };
        int expected = 37;
        int actual = deleteAndEarn(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        int[] nums = new int[] { 1, 6, 3, 3, 8, 4, 8, 10, 1, 3 };
        int expected = 43;
        int actual = deleteAndEarn(nums);
        assertEquals(expected, actual);
    }
}