package topics;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinSearchBound {

    private int lowerBound(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    private int upperBound(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = r - (r - l) / 2;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private int lower(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        if (target <= nums[l]) {
            return l;
        }
        if (target > nums[r]) {
            return -1;
        }
        while (l < r) {
            int m = l + (r - l) / 2;

            if (nums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }

    private int upper(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        if (target < nums[0]) {
            return -1;
        }
        if (target >= nums[r]) {
            return r;
        }
        while (l < r - 1) {
            int m = l + (r - l) / 2;
            if (nums[m] <= target) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return nums[r] <= target ? r : l;
    }

    @Test
    public void test1() {
        assertEquals(1, lower(new int[] { 1, 2, 2, 2, 2, 3 }, 2));
        assertEquals(4, upper(new int[] { 1, 2, 2, 2, 2, 3 }, 2));
        assertEquals(3, lower(new int[] { 1, 2, 3, 5 }, 4));
        assertEquals(2, upper(new int[] { 1, 2, 3, 5 }, 4));
        assertEquals(-1, lower(new int[] { 1, 2, 3, 5 }, 6));
        assertEquals(3, upper(new int[] { 1, 2, 3, 5 }, 6));
        assertEquals(1, lowerBound(new int[] { 1, 2, 2, 2, 2, 3 }, 2));
        assertEquals(4, upperBound(new int[] { 1, 2, 2, 2, 2, 3 }, 2));
        assertEquals(3, lowerBound(new int[] { 1, 2, 3, 5 }, 4));
        assertEquals(2, upperBound(new int[] { 1, 2, 3, 5 }, 4));
    }
}
