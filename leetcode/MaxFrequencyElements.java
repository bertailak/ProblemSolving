package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxFrequencyElements {

    public int maxFrequencyElements(int[] nums) {
        int max = 0;
        int sum = 0;

        int[] a = new int[101];
        for (int num : nums) {
            a[num]++;
            max = Math.max(max, a[num]);
        }

        for (int num : a) {
            if (num == max) {
                sum += max;
            }
        }

        return sum;
    }

    @Test
    public void test1() {
        assertEquals(4, maxFrequencyElements(new int[] { 1, 2, 2, 3, 1, 4 }));
    }

    @Test
    public void test2() {
        assertEquals(5, maxFrequencyElements(new int[] { 1, 2, 3, 4, 5 }));
    }
}