package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

public class FillCups {

    // https://leetcode.com/contest/weekly-contest-301/problems/minimum-amount-of-time-to-fill-cups/

    public int fillCups(int[] amount) {
        int count = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(amount[0]);
        pq.add(amount[1]);
        pq.add(amount[2]);

        while (!pq.isEmpty()) {

            int top = pq.poll();

            if (!pq.isEmpty()) {
                int next = pq.poll();
                if (next == 0) {
                    count += top;
                } else {
                    count++;
                    if (top > 1)
                        pq.add(--top);
                    if (next > 1)
                        pq.add(--next);
                }
            } else {
                count += top;
            }

        }

        return count;
    }

    @Test
    public void test1() {
        int[] amount = new int[] { 5, 4, 4 };
        int expected = 7;
        int actual = fillCups(amount);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] amount = new int[] { 0, 0, 0 };
        int expected = 0;
        int actual = fillCups(amount);
        assertEquals(expected, actual);
    }

}
