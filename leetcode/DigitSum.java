package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DigitSum {

    // https://leetcode.com/contest/weekly-contest-289/problems/calculate-digit-sum-of-a-string/

    public String digitSum(String s, int k) {

        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > k) {
            StringBuilder sb2 = new StringBuilder();
            int i = 0;
            while (i < sb.length()) {

                int sum = 0;
                for (int j = 0; i < sb.length() && j < k; j++, i++) {
                    sum += (int) sb.charAt(i) - 48;
                }
                sb2.append(Integer.toString(sum));

                if (i == sb.length())
                    sb = sb2;

            }
        }
        return sb.toString();
    }

    @Test
    public void test1() {
        String s = "11111222223";
        int k = 3;
        String expected = "135";
        String actual = digitSum(s, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String s = "00000000";
        int k = 3;
        String expected = "000";
        String actual = digitSum(s, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String s = "248689";
        int k = 4;
        String expected = "2017";
        String actual = digitSum(s, k);
        assertEquals(expected, actual);
    }
}