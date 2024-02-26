package leetcode.contest.contest00386;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class LargestSquareArea {
    
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long maxSquare = 0;

        for (int i = 0; i < bottomLeft.length - 1; i++) {
            for (int j = i + 1; j < bottomLeft.length; j++) {

                int tLeft = Math.min(topRight[i][0], topRight[j][0]);
                int tRight = Math.min(topRight[i][1], topRight[j][1]);

                int bLeft = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int bRight = Math.max(bottomLeft[i][1], bottomLeft[j][1]);

                if (bLeft > tLeft || bRight > tRight)
                    continue;

                long minLength = Math.min(
                        Math.abs(tLeft - bLeft),
                        tRight - bRight);

                maxSquare = Math.max(maxSquare, minLength * minLength);
            }
        }

        return maxSquare;
    }

    public long largestSquareArea2(int[][] bottomLeft, int[][] topRight) {
        long maxSquare = 0;

        int[][] squares = new int[bottomLeft.length][4];
        for (int i = 0; i < squares.length; i++) {
            squares[i] = new int[] { bottomLeft[i][0], bottomLeft[i][1], topRight[i][0], topRight[i][1] };
        }

        Arrays.sort(squares, (a, b) -> {
            if (a[0] == b[0] && a[1] == b[1] && a[2] == b[2])
                return a[3] - b[3];
            if (a[0] == b[0] && a[1] == b[1])
                return a[2] - b[2];
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });

        for (int i = 0; i < squares.length - 1; i++) {
            for (int j = i + 1; j < squares.length; j++) {

                int tLeft = Math.min(squares[i][2], squares[j][2]);
                int tRight = Math.min(squares[i][3], squares[j][3]);

                int bLeft = Math.max(squares[i][0], squares[j][0]);
                int bRight = Math.max(squares[i][1], squares[j][1]);

                if (bLeft > tLeft || bRight > tRight)
                    continue;

                long minLength = Math.min(
                        tLeft - bLeft,
                        tRight - bRight);

                maxSquare = Math.max(maxSquare, minLength * minLength);
            }
        }

        return maxSquare;
    }

    @Test
    public void test1() {
        assertEquals(1, largestSquareArea(new int[][] { { 1, 1 }, { 2, 2 }, { 3, 1 } },
                new int[][] { { 3, 3 }, { 4, 4 }, { 6, 6 } }));
    }

    @Test
    public void test2() {
        assertEquals(1, largestSquareArea(new int[][] { { 1, 1 }, { 2, 2 }, { 1, 2 } },
                new int[][] { { 3, 3 }, { 4, 4 }, { 3, 4 } }));
    }

    @Test
    public void test3() {
        assertEquals(0, largestSquareArea(new int[][] { { 1, 1 }, { 3, 3 }, { 3, 1 } },
                new int[][] { { 2, 2 }, { 4, 4 }, { 4, 2 } }));
    }

    @Test
    public void test4() {
        assertEquals(1, largestSquareArea(new int[][] { { 2, 2 }, { 1, 3 } },
                new int[][] { { 3, 4 }, { 5, 5 } }));
    }

    @Test
    public void test5() {
        assertEquals(0, largestSquareArea(new int[][] { { 3, 1 }, { 2, 4 } },
                new int[][] { { 4, 2 }, { 3, 5 } }));
    }

    @Test
    public void test6() {
        assertEquals(1, largestSquareArea(new int[][] { { 1, 1 }, { 2, 2 } },
                new int[][] { { 4, 4 }, { 3, 3 } }));
    }

    @Test
    public void test7() {
        assertEquals(1, largestSquareArea(new int[][] { { 4, 6 }, { 6, 2 }, { 3, 3 } },
                new int[][] { { 10, 8 }, { 9, 4 }, { 7, 5 } }));
    }

}
