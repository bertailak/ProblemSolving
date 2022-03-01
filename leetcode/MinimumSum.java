package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class MinimumSum {

    // https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/

    public int minimumSum(int num) {
        int[] nums = new int[4];
        int i = 0;
        while (num > 0) {
            nums[i++] = num % 10;
            num /= 10;
        }
        Arrays.sort(nums);

        return nums[0] * 10 + nums[1] * 10 + nums[2] + nums[3];
    }

    @Test
    public void test1() {
        int num = 2932;
        int expected = 52;
        int actual = minimumSum(num);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int num = 4009;
        int expected = 13;
        int actual = minimumSum(num);
        assertEquals(expected, actual);
    }

}