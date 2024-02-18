package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinMovesToCaptureTheQueen {

    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        int[][] diry = new int[][] { { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

        int miny = 2;

        for (int[] dir : diry) {
            int dx = c;
            int dy = d;
            while (dx > 0 && dx < 9 && dy > 0 && dy < 9) {
                if (dx == e && dy == f) {
                    miny = Math.min(miny, 1);
                    break;
                }
                if (dx == a && dy == b) {
                    miny = Math.min(miny, 2);
                    break;
                }
                dx = dx + dir[0];
                dy = dy + dir[1];
            }
        }

        int[][] dirx = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int minx = 2;

        for (int[] dir : dirx) {
            int dx = a;
            int dy = b;
            while (dx > 0 && dx < 9 && dy > 0 && dy < 9) {
                if (dx == e && dy == f) {
                    minx = Math.min(minx, 1);
                    break;
                }
                if (dx == c && dy == d) {
                    minx = Math.min(minx, 2);
                    break;
                }
                dx = dx + dir[0];
                dy = dy + dir[1];
            }
        }

        return Math.min(minx, miny);
    }

    @Test
    public void test1() {
        assertEquals(2, minMovesToCaptureTheQueen(1, 1, 8, 8, 2, 3));
    }

    @Test
    public void test2() {
        assertEquals(1, minMovesToCaptureTheQueen(5, 3, 3, 4, 5, 2));
    }

    @Test
    public void test22() {
        assertEquals(1, minMovesToCaptureTheQueen(6, 3, 3, 4, 5, 2));
    }

    @Test
    public void test3() {
        assertEquals(2, minMovesToCaptureTheQueen(1, 1, 1, 4, 1, 8));
    }

    @Test
    public void test4() {
        assertEquals(2, minMovesToCaptureTheQueen(4, 3, 3, 4, 5, 2));
    }

    @Test
    public void test5() {
        assertEquals(1, minMovesToCaptureTheQueen(1, 6, 3, 3, 5, 6));
    }

    @Test
    public void test6() {
        assertEquals(1, minMovesToCaptureTheQueen(8, 4, 8, 8, 7, 7));
    }

    @Test
    public void test7() {
        assertEquals(1, minMovesToCaptureTheQueen(7, 6, 2, 1, 2, 6));
    }
}
