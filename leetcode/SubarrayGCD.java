package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SubarrayGCD {

    // https://leetcode.com/problems/number-of-subarrays-with-gcd-equal-to-k/

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public int subarrayGCD(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % k == 0) {
                int gcd = nums[i];
                if (gcd == k)
                    count++;
                int j = i;
                while (++j < nums.length && nums[j] % k == 0) {
                    gcd = gcd(Math.max(gcd, nums[j]), Math.min(gcd, nums[j]));

                    if (gcd == k)
                        count++;
                }

            }
        }

        return count;
    }

    @Test
    public void test1() {
        assertEquals(4, subarrayGCD(new int[] { 9, 3, 1, 2, 6, 3 }, 3));
    }

    @Test
    public void test2() {
        assertEquals(0, subarrayGCD(new int[] { 4 }, 7));
    }

    @Test
    public void test3() {
        assertEquals(7, subarrayGCD(new int[] { 3, 12, 9, 6 }, 3));
    }
}
