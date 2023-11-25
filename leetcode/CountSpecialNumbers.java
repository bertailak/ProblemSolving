package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountSpecialNumbers {

    public int countSpecialNumbers(int n) {
        n++;
        int distinct = 0;

        int mult = 0;
        int tens = 10;
        while (n > 0) {

            if (n >= tens) {
                distinct += tens - 1;
            } else {
                distinct += n;
                if (mult < n)
                    distinct--;
            }
            n -= Math.min(tens, n);

            mult++;
            if (mult == 10) {
                mult = 0;
                tens *= 10;
            }
        }

        return distinct;
    }

    @Test
    public void test1() {
        int n = 20;
        int expected = 19;
        int actual = countSpecialNumbers(n);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int n = 5;
        int expected = 5;
        int actual = countSpecialNumbers(n);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int n = 135;
        int expected = 110;
        int actual = countSpecialNumbers(n);
        assertEquals(expected, actual);
    }

}
