package leetcode.contest.contest00394;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumberOfSpecialChars2 {
    public int numberOfSpecialChars(String word) {
        int[] lowerAlphabet = new int[26];
        int[] upperAlphabet = new int[26];
        int count = 0;

        for (int i = 0; i < upperAlphabet.length; i++) {
            lowerAlphabet[i] = -1;
            upperAlphabet[i] = -1;
        }

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) <= 'Z') {
                if (upperAlphabet[word.charAt(i) - 'A'] == -1)
                    upperAlphabet[word.charAt(i) - 'A'] = i;
            } else {
                lowerAlphabet[word.charAt(i) - 'a'] = i;
            }
        }

        for (int i = 0; i < upperAlphabet.length; i++) {
            if (upperAlphabet[i] != -1 && lowerAlphabet[i] != -1 && lowerAlphabet[i] < upperAlphabet[i])
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
    public void test4() {
        assertEquals(0, numberOfSpecialChars("AbBCab"));
    }

    @Test
    public void test5() {
        assertEquals(0, numberOfSpecialChars("cCceDC"));
    }
}
