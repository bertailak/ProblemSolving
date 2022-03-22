package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GetSmallestString {

    // https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/

    public String getSmallestString(int n, int k) {
        String result = "";

        while (n-- > 0) {
            int letter = Math.min(26, k - n);
            k -= letter;
            result = (char) ('a' + letter - 1) + result;
        }

        return result;
    }

    @Test
    public void test1() {
        int n = 3;
        int k = 27;
        String expected = "aay";
        String actual = getSmallestString(n, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int n = 5;
        int k = 73;
        String expected = "aaszz";
        String actual = getSmallestString(n, k);
        assertEquals(expected, actual);
    }
}
