package leetcode.biweekly.contest00125;

import static org.junit.Assert.assertEquals;

import java.util.PriorityQueue;

import org.junit.Test;

public class MinOperations2 {

    public int minOperations(int[] nums, int k) {
        int step = 0;

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.add((long) num);
        }

        while (!pq.isEmpty()) {

            if (pq.peek() >= k)
                break;

            long num1 = pq.poll();
            long num2 = pq.poll();

            pq.add(num1 * 2 + num2);

            step++;
        }

        return step;
    }

    @Test
    public void test1() {
        assertEquals(2, minOperations(new int[] { 2, 11, 10, 1, 3 }, 10));
    }

    @Test
    public void test2() {
        assertEquals(4, minOperations(new int[] { 1, 1, 2, 4, 9 }, 20));
    }
}