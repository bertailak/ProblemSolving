package leetcode.design;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumMatrixTest {

    @Test
    public void test1() {
        int[][] nums = new int[][] { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
                { 1, 0, 3, 0, 5 } };
        NumMatrix cl = new NumMatrix(nums);
        assertEquals(8, cl.sumRegion(2, 1, 4, 3));
        assertEquals(11, cl.sumRegion(1, 1, 2, 2));
        assertEquals(12, cl.sumRegion(1, 2, 2, 4));
    }

}