package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MonkeyMove {
    public int monkeyMove(int n) {
        int mod = 1_000_000_000 + 7;
        long pow = 1;
        while (n > 0) {
            int p = Math.min(n, 9);
            pow = (pow << p) % mod;
            n = n - p;
        }

        return (int) (pow) - 2;
    }

    @Test
    public void test1() {
        assertEquals(6, monkeyMove(3));
        assertEquals(14, monkeyMove(4));
    }

    @Test
    public void test3() {
        assertEquals(766762394, monkeyMove(55));
    }

    @Test
    public void test4() {
        assertEquals(1, monkeyMove(500000003));
    }
}
