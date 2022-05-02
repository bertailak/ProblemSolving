package leetcode;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SortArrayByParity {

    // https://leetcode.com/problems/sort-array-by-parity/

    public int[] sortArrayByParity(int[] nums) {
        int[] result = new int[nums.length];

        int i = 0, j = nums.length - 1;
        int l = 0, r = nums.length - 1;

        while (i <= j) {
            if (nums[i] % 2 == 0) {
                result[l] = nums[i];
                l++;
            } else {
                result[r] = nums[i];
                r--;
            }
            i++;
            if (i > j)
                continue;
            if (nums[j] % 2 == 0) {
                result[l] = nums[j];
                l++;
            } else {
                result[r] = nums[j];
                r--;
            }

            j--;
        }

        return result;
    }

    @Test
    public void test0() {
        int[] nums = new int[] { 1 };
        int[] expecteds = new int[] { 1 };
        int[] actuals = sortArrayByParity(nums);
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void test1() {
        int[] nums = new int[] { 3, 1, 2, 4 };
        int[] expecteds = new int[] { 4, 2, 1, 3 };
        int[] actuals = sortArrayByParity(nums);
        assertArrayEquals(expecteds, actuals);
    }
}
