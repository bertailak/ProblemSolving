package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class MaxArea2 {

    // https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int mod = 1_000000000 + 7;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int x = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        int y = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);

        for (int i = 0; i < horizontalCuts.length - 1; i++) {
            x = Math.max(x, horizontalCuts[i + 1] - horizontalCuts[i]);
        }

        for (int i = 0; i < verticalCuts.length - 1; i++) {
            y = Math.max(y, verticalCuts[i + 1] - verticalCuts[i]);
        }
        int maxArea = (int) ((long) x * y % mod);

        return maxArea;
    }

    @Test
    public void test1() {
        int h = 5;
        int w = 4;
        int[] horizontalCuts = new int[] { 1, 2, 4 };
        int[] verticalCuts = new int[] { 1, 3 };
        int expected = 4;
        int actual = maxArea(h, w, horizontalCuts, verticalCuts);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int h = 5;
        int w = 4;
        int[] horizontalCuts = new int[] { 3, 1 };
        int[] verticalCuts = new int[] { 1 };
        int expected = 6;
        int actual = maxArea(h, w, horizontalCuts, verticalCuts);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int h = 5;
        int w = 4;
        int[] horizontalCuts = new int[] { 3 };
        int[] verticalCuts = new int[] { 3 };
        int expected = 9;
        int actual = maxArea(h, w, horizontalCuts, verticalCuts);
        assertEquals(expected, actual);
    }
}
