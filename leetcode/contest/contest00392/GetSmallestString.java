package leetcode.contest.contest00392;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GetSmallestString {

    public String getSmallestString(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int diff = Math.min(Math.abs(s.charAt(i) - 'a'), Math.abs(26 + ('a' - s.charAt(i))));
            if (diff <= k) {
                sb.append('a');
                k -= diff;
            } else if (k > 0) {
                sb.append((char) (s.charAt(i) - k));
                k = 0;
            } else {
                sb.append(s.charAt(i));
            }
            i++;
        }

        return sb.toString();

    }

    @Test
    public void test1() {
        assertEquals("aaaz", getSmallestString("zbbz", 3));
    }

    @Test
    public void test2() {
        assertEquals("aawcd", getSmallestString("xaxcd", 4));
    }

    @Test
    public void test3() {
        assertEquals("lol", getSmallestString("lol", 0));
    }
}
