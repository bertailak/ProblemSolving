package leetcode.contest.contest00387;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinimumOperationsToWriteY {

    public int minimumOperationsToWriteY(int[][] grid) {
        int diff = 0;

        int n = grid.length;

        int[] inner = new int[3];
        int[] outer = new int[3];

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {
                if (isYform(n, i, j)) {
                    inner[grid[i][j]]++;
                } else {
                    outer[grid[i][j]]++;
                }

            }

        }

        if (true) {

            int innerInd = 0;
            for (int i = 1; i < inner.length; i++) {
                if (inner[i] > inner[innerInd]) {
                    innerInd = i;
                }
            }

            int outerInd = 0;
            if (innerInd == 0)
                outerInd++;

            for (int i = 1; i < outer.length; i++) {
                if (i != innerInd && outer[i] > outer[outerInd]) {
                    outerInd = i;
                }
            }

            diff = (inner[0] + inner[1] + inner[2] - inner[innerInd]);
            diff += (outer[0] + outer[1] + outer[2] - outer[outerInd]);

        }
        if (true) {

            int outerInd = 0;
            for (int i = 1; i < outer.length; i++) {
                if (outer[i] > outer[outerInd]) {
                    outerInd = i;
                }
            }

            int innerInd = 0;
            if (outerInd == 0)
                innerInd++;

            for (int i = 1; i < inner.length; i++) {
                if (i != outerInd && inner[i] > inner[innerInd]) {
                    innerInd = i;
                }
            }

            int diff2 = (inner[0] + inner[1] + inner[2] - inner[innerInd]);
            diff2 += (outer[0] + outer[1] + outer[2] - outer[outerInd]);

            diff = Math.min(diff, diff2);

        }

        return diff;
    }

    private boolean isYform(int n, int x, int y) {
        if (x < n / 2) {
            if (x == y)
                return true;
            if (x == n - y - 1)
                return true;
        } else {
            int mid = n / 2;
            if (mid == y)
                return true;
        }

        return false;
    }

    @Test
    public void test1() {
        assertEquals(3, minimumOperationsToWriteY(new int[][] { { 1, 2, 2 }, { 1, 1, 0 }, { 0, 1, 0 } }));
    }

    @Test
    public void test2() {
        assertEquals(12, minimumOperationsToWriteY(new int[][] { { 0, 1, 0, 1, 0 }, { 2, 1, 0, 1, 2 },
                { 2, 2, 2, 0, 1 }, { 2, 2, 2, 2, 2 }, { 2, 1, 2, 2, 2 } }));
    }

    @Test
    public void test3() {
        assertEquals(14, minimumOperationsToWriteY(new int[][] {
                { 1, 1, 0, 1, 1 },
                { 2, 1, 1, 1, 1 },
                { 1, 2, 0, 2, 1 },
                { 2, 0, 0, 1, 2 },
                { 2, 0, 0, 1, 0 } }));
    }

}
