package leetcode.contest.contest00397;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaximumEnergy {

    public int maximumEnergy(int[] energy, int k) {
        int maxSum = energy[energy.length - 1];
        int[] sums = new int[energy.length];

        for (int i = energy.length - 1; i >= 0; i--) {
            if (i + k >= energy.length) {
                sums[i] = energy[i];
            } else {
                sums[i] = energy[i] + sums[i + k];
            }
            maxSum = Math.max(maxSum, sums[i]);
        }

        return maxSum;
    }

    @Test
    public void test1() {
        assertEquals(3, maximumEnergy(new int[] { 5, 2, -10, -5, 1 }, 3));
    }

    @Test
    public void test2() {
        assertEquals(-1, maximumEnergy(new int[] { -2, -3, -1 }, 2));
    }

    @Test
    public void test3() {
        assertEquals(23, maximumEnergy(new int[] { 5, -10, 4, 3, 5, -9, 9, -7 }, 2));
    }

}
