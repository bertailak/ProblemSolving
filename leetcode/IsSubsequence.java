package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IsSubsequence {

    // https://leetcode.com/problems/is-subsequence/

    public boolean isSubsequence(String s, String t) {
        int index_s = 0;
        int index_t = 0;

        while (index_s < s.length() && index_t < t.length()) {
            if (s.charAt(index_s) == t.charAt(index_t))
                index_s++;
            index_t++;
        }

        return index_s == s.length();
    }

    @Test
    public void test1() {
        String s = "abc";
        String t = "ahbgdc";
        boolean expected = true;
        boolean actual = isSubsequence(s, t);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String s = "axc";
        String t = "ahbgdc";
        boolean expected = false;
        boolean actual = isSubsequence(s, t);
        assertEquals(expected, actual);
    }
}