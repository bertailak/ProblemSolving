package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TotalSteps {

    // https://leetcode.com/contest/weekly-contest-295/problems/steps-to-make-array-non-decreasing/

    public int totalSteps(int[] nums) {
        int step = 0;

        int[] steps = new int[nums.length];

        for (int i = 0; i < nums.length - 1; i++) {

            int index = i + 1;

            while (index < nums.length && nums[i] > nums[index]) {
                index++;
            }

            // step = Math.max(step, index - i - 2);
            steps[i] = index - i - 1;

        }

        for (int i = 0; i < steps.length; i++) {
            if (step < steps[i]) {
                step = steps[i];
                for (int j = 1; j < steps[i]; j++) {
                    if (j + i < steps.length)
                        step -= steps[j + i];
                }
            }
        }

        return step;
    }

    @Test
    public void test1() {
        int[] nums = new int[] { 5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11 };
        int expected = 3;
        int actual = totalSteps(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = new int[] { 4, 5, 7, 7, 13 };
        int expected = 0;
        int actual = totalSteps(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] nums = new int[] { 10, 1, 2, 3, 4, 5, 6, 1, 2, 3 };
        int expected = 6;
        int actual = totalSteps(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[] nums = new int[] { 7, 11, 1 };
        int expected = 1;
        int actual = totalSteps(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        int[] nums = new int[] { 7, 14, 4, 14, 13, 2, 6, 13 };
        int expected = 3;
        int actual = totalSteps(nums);
        assertEquals(expected, actual);
    }
}
