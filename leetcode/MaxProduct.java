package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxProduct {

    // https://leetcode.com/problems/maximum-product-of-word-lengths/

    public int maxProduct(String[] words) {
        int mult = 0;

        boolean[][] alphabet = new boolean[words.length][26];

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                alphabet[i][words[i].charAt(j) - 'a'] = true;
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {

                boolean hasSame = false;
                for (int k = 0; k < alphabet[0].length; k++) {
                    if (alphabet[i][k] && alphabet[j][k]) {
                        hasSame = true;
                        break;
                    }
                }

                if (!hasSame) {
                    mult = Math.max(mult, words[i].length() * words[j].length());
                }

            }
        }

        return mult;
    }

    @Test
    public void test1() {
        String[] words = new String[] { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" };
        int expected = 16;
        int actual = maxProduct(words);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String[] words = new String[] { "a", "ab", "abc", "d", "cd", "bcd", "abcd" };
        int expected = 4;
        int actual = maxProduct(words);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String[] words = new String[] { "a", "aa", "aaa", "aaaa" };
        int expected = 0;
        int actual = maxProduct(words);
        assertEquals(expected, actual);
    }
}
