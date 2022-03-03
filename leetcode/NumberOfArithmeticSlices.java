package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumberOfArithmeticSlices {

    // https://leetcode.com/problems/arithmetic-slices/

    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] - nums[i + 1] == nums[i + 1] - nums[i + 2]) {
                count++;
                int j = i + 2;
                while (++j < nums.length) {
                    if (nums[j] - nums[j - 1] == nums[j - 1] - nums[j - 2])
                        count++;
                    else
                        break;
                }
            }

        }

        return count;
    }

    @Test
    public void test0() {
        int[] nums = new int[] { 1, 2, 3 };
        int expected = 1;
        int actual = numberOfArithmeticSlices(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        int[] nums = new int[] { 1, 2, 3, 4 };
        int expected = 3;
        int actual = numberOfArithmeticSlices(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = new int[] { 1 };
        int expected = 0;
        int actual = numberOfArithmeticSlices(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] nums = new int[] { 1, 2, 3, 4, 5, 6 };
        int expected = 10;
        int actual = numberOfArithmeticSlices(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[] nums = new int[] { 1, 2, 3, 8, 9, 10 };
        int expected = 2;
        int actual = numberOfArithmeticSlices(nums);
        assertEquals(expected, actual);
    }
}
