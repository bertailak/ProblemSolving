package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxValue {

    // https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/

    public int maxValue(int n, int index, int maxSum) {
        int max = 1;

        maxSum -= n;

        int doubleLength = Math.min(index, n - index);



        return max;
    }

    @Test
    public void test1() {
        // 1 2 2 1

        assertEquals(2, maxValue(4, 2, 6));
    }

    @Test
    public void test2() {
        // 3 4 3 2 1 1

        assertEquals(3, maxValue(6, 1, 10));
    }
}
