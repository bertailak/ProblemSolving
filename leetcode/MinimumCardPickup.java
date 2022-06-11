package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

public class MinimumCardPickup {

    // https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/

    public int minimumCardPickup(int[] cards) {
        int min = Integer.MAX_VALUE;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < cards.length; i++) {

            if (map.containsKey(cards[i])) {
                min = Math.min(min, i - map.get(cards[i]) + 1);
            }
            map.put(cards[i], i);

        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    @Test
    public void test1() {
        int[] cards = new int[] { 3, 4, 2, 3, 4, 7 };
        int expected = 4;
        int actual = minimumCardPickup(cards);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] cards = new int[] { 1, 0, 5, 3 };
        int expected = -1;
        int actual = minimumCardPickup(cards);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] cards = new int[] { 95, 11, 8, 65, 5, 86, 30, 27, 30, 73, 15, 91, 30, 7, 37, 26, 55, 76, 60, 43, 36, 85,
                47, 96, 6 };
        int expected = 3;
        int actual = minimumCardPickup(cards);
        assertEquals(expected, actual);
    }
}
