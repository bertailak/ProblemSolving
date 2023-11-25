package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FindUnsortedSubarray {

    // https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

    public int findUnsortedSubarray(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < nums.length - 1) {
            if (nums[l] <= nums[l + 1]) {
                l++;
            } else {
                break;
            }
        }
        while (r > l) {
            if (nums[r] >= nums[r - 1]) {
                r--;
            } else {
                break;
            }
        }

        return r - l == 0 ? 0 : r - l + 1;
    }

    @Test
    public void test1() {
        int[] nums = new int[] { 2, 6, 4, 8, 10, 9, 15 };
        int expected = 5;
        int actual = findUnsortedSubarray(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = new int[] { 1, 2, 3, 4 };
        int expected = 0;
        int actual = findUnsortedSubarray(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] nums = new int[] { 1 };
        int expected = 0;
        int actual = findUnsortedSubarray(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[] nums = new int[] { 1, 2, 3, 3, 3 };
        int expected = 0;
        int actual = findUnsortedSubarray(nums);
        assertEquals(expected, actual);
    }
}
