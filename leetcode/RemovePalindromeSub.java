package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RemovePalindromeSub {

    // https://leetcode.com/problems/remove-palindromic-subsequences/

    public int removePalindromeSub(String s) {
        return s.isEmpty() ? 0 : (s.equals(new StringBuilder(s).reverse().toString()) ? 1:2);
    }

    @Test
    public void test1() {
        String s = "ababa";
        int expected = 1;
        int actual = removePalindromeSub(s);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String s = "abb";
        int expected = 2;
        int actual = removePalindromeSub(s);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String s = "baabb";
        int expected = 2;
        int actual = removePalindromeSub(s);
        assertEquals(expected, actual);
    }
}
