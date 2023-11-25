package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class MinimizeSum {

    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int res = nums[nums.length - 2] - nums[1];
        res = Math.min(res, nums[nums.length - 1] - nums[2]);
        res = Math.min(res, nums[nums.length - 3] - nums[0]);
        return res;
    }

    @Test
    public void test1() {
        assertEquals(0, minimizeSum(new int[] { 1, 3, 4 }));
        assertEquals(3, minimizeSum(new int[] { 1, 4, 7, 8, 5 }));
    }

    @Test
    public void test2() {
        assertEquals(14, minimizeSum(new int[] { 31, 25, 72, 79, 74, 65 }));
    }

    @Test
    public void test3() {
        assertEquals(24, minimizeSum(new int[] { 59, 27, 9, 81, 33 }));
    }

    @Test
    public void test4() {
        assertEquals(30, minimizeSum(new int[] { 58, 42, 8, 75, 28 }));
    }

}
