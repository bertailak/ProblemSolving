package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.PriorityQueue;

import org.junit.Test;

public class LastStoneWeight {

    // https://leetcode.com/problems/last-stone-weight/

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }

        while (!pq.isEmpty() && pq.size() > 1) {
            int top = pq.poll();
            int top2 = pq.poll();
            if (top != top2)
                pq.add(top - top2);
        }

        return pq.size() > 0 ? pq.poll() : 0;
    }

    @Test
    public void test1() {
        int[] stones = new int[] { 2, 7, 4, 1, 8, 1 };
        int expected = 1;
        int actual = lastStoneWeight(stones);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] stones = new int[] { 1 };
        int expected = 1;
        int actual = lastStoneWeight(stones);
        assertEquals(expected, actual);
    }
}
