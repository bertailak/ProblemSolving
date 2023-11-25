package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CombinationSum4 {

    // https://leetcode.com/problems/combination-sum-iv/

    public int combinationSum4(int[] nums, int target) {
        int count = 0;

        if (target == 0)
            return 1;
        if (target < 0)
            return 0;

        for (int i = 0; i < nums.length && nums[i] <= target; i++) {
            count += combinationSum4(nums, target - nums[i]);
        }

        return count;
    }

    @Test
    public void test1() {
        int[] nums = new int[] { 1, 2, 3 };
        int target = 4;
        int expected = 7;
        int actual = combinationSum4(nums, target);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = new int[] { 9 };
        int target = 3;
        int expected = 0;
        int actual = combinationSum4(nums, target);
        assertEquals(expected, actual);
    }
}
