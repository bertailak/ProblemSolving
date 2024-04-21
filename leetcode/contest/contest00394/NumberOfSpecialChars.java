package leetcode.contest.contest00394;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumberOfSpecialChars {
    public int numberOfSpecialChars(String word) {
        boolean[] lowerAlphabet = new boolean[26];
        boolean[] upperAlphabet = new boolean[26];
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) <= 'Z') {
                upperAlphabet[word.charAt(i) - 'A'] = true;
            } else {
                lowerAlphabet[word.charAt(i) - 'a'] = true;
            }
        }

        for (int i = 0; i < upperAlphabet.length; i++) {
            if (upperAlphabet[i] && lowerAlphabet[i])
                count++;
        }

        return count;
    }

    @Test
    public void test1() {
        assertEquals(3, numberOfSpecialChars("aaAbcBC"));
    }

    @Test
    public void test2() {
        assertEquals(0, numberOfSpecialChars("abc"));
    }

    @Test
    public void test3() {
        assertEquals(1, numberOfSpecialChars("abBCab"));
    }

    @Test
    public void test4() {
        assertEquals(0, numberOfSpecialChars("AbBCab"));
    }
}
