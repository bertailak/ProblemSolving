package leetcode;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class CountRectangles {

    // https://leetcode.com/problems/count-number-of-rectangles-containing-each-point/

    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int[] count = new int[points.length];

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < rectangles.length; j++) {
                if (rectangles[j][0] >= points[i][0] && rectangles[j][1] >= points[i][1])
                    count[i]++;
            }
        }

        return count;
    }

    @Test
    public void test1() {
        int[][] rectangles = new int[][] { { 1, 1 }, { 2, 2 }, { 3, 3 } };
        int[][] points = new int[][] { { 1, 3 }, { 1, 1 } };
        int[] expecteds = new int[] { 1, 3 };
        int[] actuals = countRectangles(rectangles, points);
        assertArrayEquals(expecteds, actuals);
    }
}
