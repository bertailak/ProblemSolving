package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinimumTime {

    // https://leetcode.com/problems/minimum-time-to-complete-trips/

    public long minimumTime(int[] time, int totalTrips) {
        long min = time[0];
        for (int i = 1; i < time.length; i++) {
            min = Math.min(time[i], min);
        }

        long left = min;
        long right = min * totalTrips;

        while (left < right) {
            int step = 0;
            long mid = left + (right - left) / 2;
            for (int i = 0; i < time.length; i++) {
                step += mid / time[i];
                if (step > totalTrips)
                    break;
            }
            if (step >= totalTrips) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    @Test
    public void test1() {
        int[] time = new int[] { 1, 2, 3 };
        int totalTrips = 5;
        long expected = 3;
        long actual = minimumTime(time, totalTrips);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] time = new int[] { 2 };
        int totalTrips = 1;
        long expected = 2;
        long actual = minimumTime(time, totalTrips);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] time = new int[] { 5, 10, 10 };
        int totalTrips = 9;
        long expected = 25;
        long actual = minimumTime(time, totalTrips);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[] time = new int[] { 3, 3, 8 };
        int totalTrips = 6;
        long expected = 9;
        long actual = minimumTime(time, totalTrips);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        int[] time = new int[] { 1, 5 };
        int totalTrips = 4;
        long expected = 4;
        long actual = minimumTime(time, totalTrips);
        assertEquals(expected, actual);
    }

    @Test
    public void test6() {
        int[] time = new int[] { 9, 3, 10, 5 };
        int totalTrips = 2;
        long expected = 5;
        long actual = minimumTime(time, totalTrips);
        assertEquals(expected, actual);
    }

    @Test
    public void test7() {
        int[] time = new int[] { 9, 2 };
        int totalTrips = 8;
        long expected = 14;
        long actual = minimumTime(time, totalTrips);
        assertEquals(expected, actual);
    }

}
