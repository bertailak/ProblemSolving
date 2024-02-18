package leetcode;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class GetSumAbsoluteDifferences {

    public int[] getSumAbsoluteDifferences(int[] nums) {

        int[] result = new int[nums.length];

        int sumr = 0;
        int suml = 0;
        for (int i = 0; i < nums.length; i++) {
            sumr += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            sumr -= nums[i];
            result[i] = (i * nums[i] - suml);
            if (i < nums.length - 1)
                result[i] += sumr - (nums.length - i - 1) * nums[i];
            suml += nums[i];
        }

        return result;
    }

    @Test
    public void test1() {
        assertArrayEquals(new int[] { 4, 3, 5 }, getSumAbsoluteDifferences(new int[] { 2, 3, 5 }));
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[] { 24, 15, 13, 15, 21 }, getSumAbsoluteDifferences(new int[] { 1, 4, 6, 8, 10 }));
    }
}
