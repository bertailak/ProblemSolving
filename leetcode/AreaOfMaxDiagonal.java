package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AreaOfMaxDiagonal {

    public int areaOfMaxDiagonal(int[][] dimensions) {
        int max = 0;
        int square = 0;

        for (int[] is : dimensions) {
            int sqr = is[0] * is[0] + is[1] * is[1];
            int mx = is[0] * is[1];

            if (sqr > square) {
                square = sqr;
                max = mx;
            } else if (sqr == square && mx > max) {
                max = mx;
            }
        }

        return max;
    }

    @Test
    public void test1() {
        assertEquals(48, areaOfMaxDiagonal(new int[][] { { 9, 3 }, { 8, 6 } }));
        assertEquals(12, areaOfMaxDiagonal(new int[][] { { 3, 4 }, { 4, 3 } }));
    }

    @Test
    public void test2() {
        assertEquals(30, areaOfMaxDiagonal(new int[][] { { 2, 6 }, { 5, 1 }, { 3, 10 }, { 8, 4 } }));
    }

}