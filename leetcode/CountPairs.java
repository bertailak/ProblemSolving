package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountPairs {

    // https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/

    public int countPairs(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0)
                    count++;
            }
        }

        return count;
    }

    @Test
    public void test1() {
        int[] nums = new int[] { 3, 1, 2, 2, 2, 1, 3 };
        int k = 2;
        int expected = 4;
        int actual = countPairs(nums, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = new int[] { 1, 2, 3, 4 };
        int k = 1;
        int expected = 0;
        int actual = countPairs(nums, k);
        assertEquals(expected, actual);
    }
}
