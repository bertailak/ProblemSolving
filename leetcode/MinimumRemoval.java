package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class MinimumRemoval {

    // https://leetcode.com/problems/removing-minimum-number-of-magic-beans/

    public long minimumRemoval(int[] beans) {
        long area = 0;
        long totalArea = 0;

        Arrays.sort(beans);

        for (int i = 0; i < beans.length; i++) {
            totalArea += beans[i];
            Long currentArea = beans[i] * ((long) beans.length - i);
            area = Math.max(area, currentArea);
        }

        return totalArea - area;
    }

    @Test
    public void test1() {
        int[] beans = new int[] { 4, 1, 6, 5 };
        long expected = 4;
        long actual = minimumRemoval(beans);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] beans = new int[] { 2, 10, 3, 2 };
        long expected = 7;
        long actual = minimumRemoval(beans);
        assertEquals(expected, actual);
    }
}
