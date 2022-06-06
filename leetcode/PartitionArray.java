package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class PartitionArray {

    // https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/

    public int partitionArray(int[] nums, int k) {
        int count = 0;
        Arrays.sort(nums);

        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - min > k) {
                count++;
                min = nums[i];
            }
        }

        return count + 1;
    }

    @Test
    public void test1() {
        int[] nums = new int[] { 3, 6, 1, 2, 5 };
        int k = 2;
        int expected = 2;
        int actual = partitionArray(nums, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = new int[] { 1, 2, 3 };
        int k = 1;
        int expected = 2;
        int actual = partitionArray(nums, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] nums = new int[] { 2, 2, 4, 5 };
        int k = 0;
        int expected = 3;
        int actual = partitionArray(nums, k);
        assertEquals(expected, actual);
    }
}
