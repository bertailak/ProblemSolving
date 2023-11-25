package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Divide {

    // https://leetcode.com/problems/divide-two-integers/

    public int divide(int dividend, int divisor) {
        if (dividend == 1 << 31 && divisor == -1)
            return (1 << 31) - 1;
        int sign = (dividend >= 0 ^ divisor >= 0) ? -1 : 1;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        if (dividend < divisor)
            return 0;

        int quotient = 0;
        int quot = 1;

        int div = divisor;

        while (div <= dividend) {
            int div2 = div << 1;
            if (div2 < dividend) {
                quot *= 2;
                div = div2;
            } else {
                quotient += quot;
                dividend -= div;
                quot = 1;
                div = divisor;
            }
        }

        return sign * quotient;
    }

    @Test
    public void test1() {
        int dividend = 10;
        int divisor = 3;
        int expected = 3;
        int actual = divide(dividend, divisor);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int dividend = 7;
        int divisor = -3;
        int expected = -2;
        int actual = divide(dividend, divisor);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int dividend = 1;
        int divisor = 1;
        int expected = 1;
        int actual = divide(dividend, divisor);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int dividend = -2147483648;
        int divisor = -1;
        int expected = 2147483647;
        int actual = divide(dividend, divisor);
        assertEquals(expected, actual);
    }
}
