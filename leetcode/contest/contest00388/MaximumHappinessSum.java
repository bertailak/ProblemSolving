package leetcode.contest.contest00388;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class MaximumHappinessSum {
    public long maximumHappinessSum(int[] happiness, int k) {
        long sum = 0;

        Arrays.sort(happiness);
        int index = happiness.length - 1;
        int inc = 0;
        while (k-- > 0) {
            sum += Math.max(happiness[index--] - inc, 0);
            inc++;
        }

        return sum;
    }

    @Test
    public void test1() {
        assertEquals(4, maximumHappinessSum(new int[] { 1, 2, 3 }, 2));
    }

    @Test
    public void test2() {
        assertEquals(1, maximumHappinessSum(new int[] { 1, 1, 1, 1 }, 2));
    }

    @Test
    public void test3() {
        assertEquals(5, maximumHappinessSum(new int[] { 2, 3, 4, 5 }, 1));
    }
}
