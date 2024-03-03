package leetcode.biweekly.contest00125;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class MinOperations {

    public int minOperations(int[] nums, int k) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k)
                continue;
            return i;
        }

        return nums.length;
    }

    @Test
    public void test1() {
        assertEquals(3, minOperations(new int[] { 2, 11, 10, 1, 3 }, 10));
    }
}