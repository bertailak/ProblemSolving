package leetcode.contest.contest00394;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class MinimumOperations {

    public int minimumOperations(int[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;

        int[][][] values = new int[m][10][2];
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                values[i][j][1] = j;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < grid.length; j++) {
                values[i][grid[j][i]][0]++;
            }
        }

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                int[][] arr = Arrays.copyOf(values[i], 10);

                Arrays.sort(arr, (a, b) -> {
                    if (b[0] == a[0])
                        return a[1] - b[1];
                    return b[0] - a[0];
                });

                values[i] = arr;
            }
        }

        int lastValue = -1;
        for (int i = 0; i < values.length; i++) {
            int currentIndex = 0;
            if (lastValue == values[i][currentIndex][1])
                currentIndex = 1;

            count += n - values[i][currentIndex][0];
            lastValue = values[i][currentIndex][1];
        }

        int count2 = 0;
        lastValue = -1;
        for (int i = values.length - 1; i >= 0; i--) {
            int currentIndex = 0;
            if (lastValue == values[i][currentIndex][1])
                currentIndex = 1;

            count2 += n - values[i][currentIndex][0];
            lastValue = values[i][currentIndex][1];
        }

        return Math.min(count, count2);
    }

    @Test
    public void test1() {
        assertEquals(0, minimumOperations(new int[][] { { 1, 0, 2 }, { 1, 0, 2 } }));
    }

    @Test
    public void test2() {
        assertEquals(3, minimumOperations(new int[][] { { 1, 1, 1 }, { 0, 0, 0 } }));
    }

    @Test
    public void test3() {
        assertEquals(2, minimumOperations(new int[][] { { 1 }, { 2 }, { 3 } }));
    }

    @Test
    public void test4() {
        assertEquals(9,
                minimumOperations(new int[][] {
                        { 4, 5, 0, 1 },
                        { 1, 9, 0, 8 },
                        { 2, 2, 5, 3 },
                        { 2, 0, 9, 3 } }));
    }

}
