package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.PriorityQueue;

import org.junit.Test;

public class MinimumLines {

    // https://leetcode.com/contest/weekly-contest-294/problems/minimum-lines-to-represent-a-line-chart/

    public int minimumLines(int[][] stockPrices) {
        if (stockPrices.length < 2)
            return 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        int count = 0;

        for (int i = 0; i < stockPrices.length; i++) {
            pq.add(stockPrices[i]);
        }

        count++;
        int[] top = pq.poll();
        double angle = getAngle(top, pq.peek());

        while (pq.size() > 1) {
            top = pq.poll();
            double a = getAngle(top, pq.peek());
            if (angle != a) {
                count++;
                angle = a;
            }
        }

        return count;
    }

    public double getAngle(int[] a, int[] b) {
        double angle = Math.toDegrees(Math.atan2((double)a[1] - (double)b[1], (double)a[0] - (double)b[0]));

        if (angle < 0) {
            angle += 360;
        }

        return angle;
    }

    @Test
    public void test1() {
        int[][] stockPrices = new int[][] { { 1, 7 }, { 2, 6 }, { 3, 5 }, { 4, 4 }, { 5, 4 }, { 6, 3 }, { 7, 2 },
                { 8, 1 } };
        int expected = 3;
        int actual = minimumLines(stockPrices);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[][] stockPrices = new int[][] { { 3, 4 }, { 1, 2 }, { 7, 8 }, { 2, 3 } };
        int expected = 1;
        int actual = minimumLines(stockPrices);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[][] stockPrices = new int[][] { { 93, 6 }, { 87, 11 }, { 26, 58 }, { 28, 1 }, { 69, 87 }, { 45, 59 },
                { 29, 3 }, { 5, 58 }, { 60, 94 }, { 46, 54 }, { 38, 58 }, { 88, 10 }, { 94, 7 }, { 72, 96 }, { 2, 93 },
                { 63, 54 }, { 74, 22 }, { 77, 84 }, { 33, 64 }, { 13, 71 }, { 78, 59 }, { 76, 93 }, { 3, 31 },
                { 7, 95 }, { 68, 32 }, { 27, 61 }, { 96, 31 }, { 4, 67 }, { 75, 36 }, { 67, 21 }, { 8, 66 }, { 83, 66 },
                { 71, 58 }, { 6, 36 }, { 34, 7 }, { 86, 78 } };
        int expected = 35;
        int actual = minimumLines(stockPrices);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[][] stockPrices = new int[][] { { 1, 1 }, { 5, 52 }, { 12, 53 }, { 13, 48 } };
        int expected = 3;
        int actual = minimumLines(stockPrices);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        int[][] stockPrices = new int[][] { { 1, 1000000000 }, { 1000000000, 1000000000 }, { 999999999, 1 },
                { 2, 999999999 } };
        int expected = 3;
        int actual = minimumLines(stockPrices);
        assertEquals(expected, actual);
    }

    @Test
    public void test6() {
        int[][] stockPrices = new int[][] { { 200, 1 }, { 201, 499999999 }, { 202, 999999998 }, { 203, 1000000000 } };
        int expected = 3;
        int actual = minimumLines(stockPrices);
        assertEquals(expected, actual);
    }

}
