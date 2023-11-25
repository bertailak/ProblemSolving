package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PivotInteger {
    public int pivotInteger(int n) {
        int sumL = 0;
        int sumR = 0;
        int l = 1;
        int r = n;
        while (l < r) {
            if (sumL <= sumR) {
                sumL += l;
                l++;
            } else {
                sumR += r;
                r--;
            }
        }
        return sumL == sumR ? l : -1;
    }

    @Test
    public void test1() {
        assertEquals(6, pivotInteger(8));
    }

    @Test
    public void test2() {
        assertEquals(1, pivotInteger(1));
    }

    @Test
    public void test3() {
        assertEquals(-1, pivotInteger(4));
    }
}
