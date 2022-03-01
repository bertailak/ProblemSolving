package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FirstPalindrome {

    // https://leetcode.com/problems/find-first-palindromic-string-in-the-array/

    public String firstPalindrome(String[] words) {
        String result = "";

        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            if (words[i].equals(sb.reverse().toString())) {
                result = words[i];
                break;
            }
        }

        return result;
    }

    @Test
    public void test1() {
        String[] words = new String[] { "abc", "car", "ada", "racecar", "cool" };
        String expected = "ada";
        String actual = firstPalindrome(words);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String[] words = new String[] { "notapalindrome", "racecar" };
        String expected = "racecar";
        String actual = firstPalindrome(words);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String[] words = new String[] { "def", "ghi" };
        String expected = "";
        String actual = firstPalindrome(words);
        assertEquals(expected, actual);
    }
}
