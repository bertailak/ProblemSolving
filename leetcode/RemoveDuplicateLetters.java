package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RemoveDuplicateLetters {

    // https://leetcode.com/problems/remove-duplicate-letters/

    public String removeDuplicateLetters(String s) {
        boolean[] a = new boolean['z' - 'a' + 1];

        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (a[i])
                sb.append((char) ('a' + i));
        }

        return sb.toString();
    }

    @Test
    public void test1() {
        String s = "bcabc";
        String expected = "abc";
        String actual = removeDuplicateLetters(s);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String s = "cbacdcbc";
        String expected = "acdb";
        String actual = removeDuplicateLetters(s);
        assertEquals(expected, actual);
    }
}
