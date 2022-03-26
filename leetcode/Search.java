package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Search {

    // https://leetcode.com/problems/binary-search/

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else {
                if (nums[mid] < target)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }

        return -1;
    }

    @Test
    public void test1() {
        int[] nums = new int[] { -1, 0, 3, 5, 9, 12 };
        int target = 9;
        int expected = 4;
        int actual = search(nums, target);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = new int[] { -1, 0, 3, 5, 9, 12 };
        int target = 2;
        int expected = -1;
        int actual = search(nums, target);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] nums = new int[] { 5 };
        int target = 5;
        int expected = 0;
        int actual = search(nums, target);
        assertEquals(expected, actual);
    }
}
