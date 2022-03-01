package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IsSameAfterReversals {

    // https://leetcode.com/problems/a-number-after-a-double-reversal/

    public boolean isSameAfterReversals(int num) {
        return num == 0 || num % 10 != 0;
    }

    @Test
    public void test1() {
        int num = 0;
        boolean expected = true;
        boolean actual = isSameAfterReversals(num);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int num = 526;
        boolean expected = true;
        boolean actual = isSameAfterReversals(num);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int num = 1800;
        boolean expected = false;
        boolean actual = isSameAfterReversals(num);
        assertEquals(expected, actual);
    }

}
