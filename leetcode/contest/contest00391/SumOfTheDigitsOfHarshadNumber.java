package leetcode.contest.contest00391;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SumOfTheDigitsOfHarshadNumber {

    public int sumOfTheDigitsOfHarshadNumber(int x) {

        int sum = 0;
        int temp = x;

        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }

        if (x % sum == 0)
            return sum;

        return -1;
    }

    @Test
    public void test1() {
        assertEquals(9, sumOfTheDigitsOfHarshadNumber(18));
    }

    @Test
    public void test2() {
        assertEquals(-1, sumOfTheDigitsOfHarshadNumber(23));
    }
}