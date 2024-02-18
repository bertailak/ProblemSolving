package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class JobScheduling {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] data = new int[startTime.length + 1][4];
        data[0] = new int[] { 0, 0, 0, 0 };

        for (int i = 0; i < profit.length; i++) {
            data[i] = new int[] { endTime[i], startTime[i], profit[i], 0 };
        }

        Arrays.sort(data, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });

        // for (int i = 0; i < data.length; i++) {
        // System.out.println(data[i][0] + ", " + data[i][1] + ", " + data[i][2]);
        // }

        for (int i = 1; i < data.length; i++) {

            int j = i - 1;
            while (data[j][0] > data[i][1]) {
                j--;
            }
            data[i][3] = Math.max(data[i - 1][3], data[j][3] + data[i][2]);
        }

        return data[data.length - 1][3];
    }

    @Test
    public void test1() {
        assertEquals(120,
                jobScheduling(
                        new int[] { 1, 2, 3, 3 },
                        new int[] { 3, 4, 5, 6 },
                        new int[] { 50, 10, 40, 70 }));
    }

    @Test
    public void test2() {
        assertEquals(150,
                jobScheduling(
                        new int[] { 1, 2, 3, 4, 6 },
                        new int[] { 3, 5, 10, 6, 9 },
                        new int[] { 20, 20, 100, 70, 60 }));
    }

    @Test
    public void test3() {
        assertEquals(6,
                jobScheduling(
                        new int[] { 1, 1, 1 },
                        new int[] { 2, 3, 4 },
                        new int[] { 5, 6, 4 }));
    }
}