package leetcode.contest.contest00390;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinOperations {
    public int minOperations(int k) {
        int step = 0;

        double sqrt = Math.ceil(Math.sqrt(k));

        step += sqrt - 1;
        step += Math.ceil(k / sqrt) - 1;

        return step;
    }

    @Test
    public void test1() {
        assertEquals(5, minOperations(11));
    }

    @Test
    public void test2() {
        assertEquals(0, minOperations(1));
    }
}
