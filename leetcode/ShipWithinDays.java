package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShipWithinDays {

    // https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

    public int shipWithinDays(int[] weights, int days) {
        int l = 1;
        int r = 50000;

        while (l < r) {
            int m = l + (r - l) / 2;
            int day = getDay(weights, m);
            if (day <= days) {
                r = m;
            } else {
                l = m + 1;
            }

        }

        return l;
    }

    private int getDay(int[] weights, int min) {
        int sum = 0;
        int day = 0;

        for (int i = 0; i < weights.length; i++) {
            if (min < weights[i])
                return getDay(weights, weights.length);
            if (sum + weights[i] <= min) {
                sum += weights[i];
            } else {
                sum = weights[i];
                day++;
            }
        }
        return day + 1;
    }

    @Test
    public void test1() {
        assertEquals(15, shipWithinDays(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 5));
    }

    @Test
    public void test2() {
        assertEquals(6, shipWithinDays(new int[] { 3, 2, 2, 4, 1, 4 }, 3));
    }

    @Test
    public void test3() {
        assertEquals(3, shipWithinDays(new int[] { 1, 2, 3, 1, 1 }, 4));
    }

}