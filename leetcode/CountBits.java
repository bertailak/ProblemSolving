package leetcode;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class CountBits {

    // https://leetcode.com/problems/counting-bits/

    public int[] countBits(int n) {
        int[] bits = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            bits[i] = (int) Integer.toBinaryString(i).chars().filter(c -> c == '1').count();
        }

        return bits;
    }

    @Test
    public void test1() {
        int n = 2;
        int[] expecteds = new int[] { 0, 1, 1 };
        int[] actuals = countBits(n);
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void test2() {
        int n = 5;
        int[] expecteds = new int[] { 0, 1, 1, 2, 1, 2 };
        int[] actuals = countBits(n);
        assertArrayEquals(expecteds, actuals);
    }
}
