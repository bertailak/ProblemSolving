package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinEatingSpeed {

    // https://leetcode.com/problems/koko-eating-bananas/description/

    private int getHour(int[] nums, int mid) {
        int count = 0;
        for (int num : nums) {
            count += (num - 1) / mid + 1;
        }
        return count;
    }

    public int minEatingSpeed(int[] nums, int target) {
        int l = 1;
        int r = Integer.MAX_VALUE;

        while (l < r) {
            int m = l + (r - l) / 2;
            int count = getHour(nums, m);
            if (count <= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    @Test
    public void test1() {
        assertEquals(4, minEatingSpeed(new int[] { 3, 6, 7, 11 }, 8));
    }

    @Test
    public void test2() {
        assertEquals(30, minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 5));
    }

    @Test
    public void test3() {
        assertEquals(23, minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 6));
    }
}
