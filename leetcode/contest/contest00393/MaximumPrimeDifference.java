package leetcode.contest.contest00393;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaximumPrimeDifference {
    public int maximumPrimeDifference(int[] nums) {

        boolean[] notPrime = new boolean[101];
        notPrime[1] = true;

        for (int i = 2; i <= (int)Math.sqrt(notPrime.length); i++) {

            if (notPrime[i])
                continue;

            int mult = i * 2;
            while (mult < notPrime.length) {
                notPrime[mult] = true;
                mult += i;
            }

        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (notPrime[nums[i]])
                continue;

            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        return max - min;
    }

    @Test
    public void test1() {
        assertEquals(3, maximumPrimeDifference(new int[] { 4, 2, 9, 5, 3 }));
    }

    @Test
    public void test2() {
        assertEquals(0, maximumPrimeDifference(new int[] { 4, 8, 2, 8 }));
    }

    @Test
    public void test3() {
        assertEquals(0, maximumPrimeDifference(new int[] { 1, 7 }));
    }
}
