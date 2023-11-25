package leetcode;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class FindPrefixScore {

    public long[] findPrefixScore(int[] nums) {
        long[] result = new long[nums.length];
        int max = nums[0];
        result[0] = 2 * max;

        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            result[i] = result[i - 1] + nums[i] + max;
        }

        return result;
    }

    @Test
    public void test1() {
        assertArrayEquals(new long[] { 4, 10, 24, 36, 56 }, findPrefixScore(new int[] { 2, 3, 7, 5, 10 }));
    }

    @Test
    public void test2() {
        assertArrayEquals(new long[] { 2, 4, 8, 16, 32, 64 }, findPrefixScore(new int[] { 1, 1, 2, 4, 8, 16 }));
    }
}
