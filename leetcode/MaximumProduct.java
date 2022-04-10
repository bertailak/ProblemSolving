package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.PriorityQueue;

import org.junit.Test;

public class MaximumProduct {

    // https://leetcode.com/problems/maximum-product-after-k-increments/

    public int maximumProduct(int[] nums, int k) {
        long result = 1;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }

        while (k-- > 0) {
            int num = maxHeap.poll();
            num++;
            maxHeap.add(num);
        }

        while (!maxHeap.isEmpty()) {
            int num = maxHeap.poll();
            result = (result * num) % 1000000007;
        }

        return (int)result;
    }

    @Test
    public void test1() {
        int[] nums = new int[] { 0, 4 };
        int k = 5;
        int expected = 20;
        int actual = maximumProduct(nums, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = new int[] { 0, 0, 0, 2 };
        int k = 6;
        int expected = 16;
        int actual = maximumProduct(nums, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] nums = new int[] { 0, 0, 0, 3 };
        int k = 7;
        int expected = 36;
        int actual = maximumProduct(nums, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[] nums = new int[] { 24, 5, 64, 53, 26, 38 };
        int k = 54;
        int expected = 180820950;
        int actual = maximumProduct(nums, k);
        assertEquals(expected, actual);
    }
}
