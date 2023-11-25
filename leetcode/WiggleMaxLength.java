package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WiggleMaxLength {

    // https://leetcode.com/problems/wiggle-subsequence/

    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1)
            return 1;

        int left = 0;
        while (left + 1 < nums.length && nums[left + 1] - nums[left] == 0) {
            left++;
        }
        boolean isPositive = nums[left + 1] - nums[left] > 0;
        left++;
        int maxAll = 1;
        int max = 1;

        for (int i = left; i < nums.length - 1; i++) {
            if (nums[left + 1] - nums[left] == 0) {
                max = 1;
            } else {
                if (max == 1) {
                    isPositive = nums[left + 1] - nums[left] > 0;
                    max++;
                    maxAll = Math.max(maxAll, max);
                } else {
                    if ((isPositive && nums[left + 1] - nums[left] < 0)
                            || (!isPositive && nums[left + 1] - nums[left] > 0)) {
                        max++;
                        isPositive = nums[left + 1] - nums[left] > 0;
                        maxAll = Math.max(maxAll, max);
                    } else {
                        isPositive = nums[left + 1] - nums[left] > 0;
                        max = 1;
                    }
                }
            }
        }

        return maxAll;
    }

    @Test
    public void test1() {
        int[] nums = new int[] { 1, 7, 4, 9, 2, 5 };
        int expected = 6;
        int actual = wiggleMaxLength(nums);
        assertEquals(expected, actual);
    }
}
