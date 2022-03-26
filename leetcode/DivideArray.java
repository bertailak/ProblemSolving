package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class DivideArray {

    // https://leetcode.com/problems/divide-array-into-equal-pairs/

    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i += 2) {
            if (nums[i] != nums[i + 1])
                return false;
        }

        return true;
    }

    @Test
    public void test1() {
        int[] nums = new int[] { 3, 2, 3, 2, 2, 2 };
        boolean expected = true;
        boolean actual = divideArray(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = new int[] { 1, 2, 3, 4 };
        boolean expected = false;
        boolean actual = divideArray(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        // int[] nums = new int[] { 9, 9, 19, 10, 9, 12, 2, 12, 3, 3, 11, 5, 8, 4, 13,
        // 6, 2, 11, 9, 19, 11, 15, 9, 17, 15,
        // 12, 5, 14, 12, 16, 18, 16, 10, 3, 8, 9, 16, 20, 2, 4, 16, 12, 11, 14, 20, 16,
        // 2, 18, 17, 20, 3, 13, 16,
        // 17, 1, 1, 11, 20, 20, 4 };
        int[] nums = new int[] { 6, 20, 12, 11, 17, 4 };
        boolean expected = false;
        boolean actual = divideArray(nums);
        assertEquals(expected, actual);
    }
}
