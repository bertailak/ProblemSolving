package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ChampagneTower {

    // https://leetcode.com/problems/champagne-tower/

    public double champagneTower(int poured, int query_row, int query_glass) {

        double[][] triangle = new double[query_row + 1][query_row + 1];

        triangle[0][0] = poured;
        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (triangle[i][j] > 1.0) {
                    triangle[i + 1][j] += (triangle[i][j] - 1) / 2.0;
                    triangle[i + 1][j + 1] += (triangle[i][j] - 1) / 2.0;
                    // triangle[i][j] = 1.0;
                }
            }
        }
        return Math.min(1.0, triangle[query_row][query_glass]);
    }

    @Test
    public void test1() {
        int poured = 1;
        int query_row = 1;
        int query_glass = 1;
        double expected = 0;
        double actual = champagneTower(poured, query_row, query_glass);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void test2() {
        int poured = 100000009;
        int query_row = 33;
        int query_glass = 17;
        double expected = 12;
        double actual = champagneTower(poured, query_row, query_glass);
        assertEquals(expected, actual, 0.00001);
    }

}
