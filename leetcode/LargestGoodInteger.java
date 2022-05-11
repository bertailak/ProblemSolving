package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LargestGoodInteger {

    // https://leetcode.com/problems/largest-3-same-digit-number-in-string/

    public String largestGoodInteger(String num) {
        String result = "";

        for (int i = 2; i < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i - 1) && num.charAt(i) == num.charAt(i - 2)) {
                String good = num.substring(i - 2, i + 1);
                if (result.compareTo(good) < 0)
                    result = good;
            }
        }

        return result;
    }

    @Test
    public void test1() {
        String num = "6777133339";
        String expected = "777";
        String actual = largestGoodInteger(num);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String num = "2300019";
        String expected = "000";
        String actual = largestGoodInteger(num);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String num = "42352338";
        String expected = "";
        String actual = largestGoodInteger(num);
        assertEquals(expected, actual);
    }
}
