package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.PriorityQueue;

import org.junit.Test;

public class MaxConsecutive {

    // https://leetcode.com/problems/maximum-consecutive-floors-without-special-floors/

    public int maxConsecutive(int bottom, int top, int[] special) {
        int max = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int last = bottom;

        for (int i = 0; i < special.length; i++) {
            pq.add(special[i]);
        }

        while (!pq.isEmpty()) {
            int current = pq.poll();
            max = Math.max(max, current - last);
            last = current + 1;
        }
        max = Math.max(max, top + 1 - last);

        return max;
    }

    @Test
    public void test1() {
        int bottom = 2;
        int top = 9;
        int[] special = new int[] { 4, 6 };
        int expected = 3;
        int actual = maxConsecutive(bottom, top, special);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int bottom = 6;
        int top = 8;
        int[] special = new int[] { 7, 6, 8 };
        int expected = 0;
        int actual = maxConsecutive(bottom, top, special);
        assertEquals(expected, actual);
    }

}
