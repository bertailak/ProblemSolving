package leetcode.contest.contest00393;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

import org.junit.Test;

public class FindKthSmallest {

    public long findKthSmallestPQ(int[] coins, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashSet<Long> set = new HashSet<>();

        Arrays.sort(coins);
        long max = (long) k * coins[0];
        // pq.add(max);

        for (int i = 0; i < coins.length; i++) {
            long product = 0;
            while (product < max) {
                product += coins[i];

                if (set.contains(product))
                    continue;

                pq.add(product);
                set.add(product);
                if (pq.size() > k)
                    pq.poll();
            }
        }

        while (pq.size() > k) {
            pq.poll();
        }

        return pq.poll();
    }

    public long findKthSmallest(int[] coins, int k) {

        Arrays.sort(coins);
        int[] dp = new int[coins[0] * k + 1];
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] < 0)
                    continue;
                dp[i] = dp[i - coins[j]] + 1;
                break;
            }
            if (dp[i] >= k)
                return i;
        }

        return dp[dp.length];
    }

    @Test
    public void test1() {
        assertEquals(9, findKthSmallest(new int[] { 3, 6, 9 }, 3));
    }

    @Test
    public void test2() {
        assertEquals(12, findKthSmallest(new int[] { 5, 2 }, 7));
    }

    @Test
    public void test3() {
        assertEquals(36, findKthSmallest(new int[] { 10, 6 }, 8));
    }
}
