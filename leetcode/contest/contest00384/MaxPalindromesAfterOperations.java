package leetcode.contest.contest00384;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class MaxPalindromesAfterOperations {

    public int maxPalindromesAfterOperations(String[] words) {
        int[] alphabet = new int[26];

        int pairs = 0;

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                alphabet[word.charAt(i) - 'a']++;
                if (alphabet[word.charAt(i) - 'a'] % 2 == 0)
                    pairs++;
            }
        }

        Arrays.sort(words, (a, b) -> {
            return a.length() - b.length();
        });

        for (int i = 0; i < words.length; i++) {
            int len = words[i].length();

            pairs -= len / 2;

            if (pairs < 0)
                return i;

        }

        return words.length;
    }

    public int maxPalindromesAfterOperations2(String[] words) {
        int count = 0;
        int[] alphabet = new int[26];

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                alphabet[word.charAt(i) - 'a']++;
            }
        }

        Arrays.sort(words, (a, b) -> {
            return a.length() - b.length();
        });

        for (int i = 0; i < words.length; i++) {
            int len = words[i].length();

            if ((len & 1) == 1) {

                for (int j = 0; j < alphabet.length; j++) {
                    if (alphabet[j] == 0)
                        continue;

                    if ((alphabet[j] & 1) == 0)
                        continue;

                    len--;
                    alphabet[j]--;
                    break;
                }

            }

            if (len > 0) {

                for (int j = 0; j < alphabet.length; j++) {
                    if (alphabet[j] == 0)
                        continue;
                    int curr = Math.min(alphabet[j] / 2, len / 2);

                    alphabet[j] -= curr * 2;
                    len -= curr * 2;
                    if (len < 2)
                        break;
                }
            }

            if ((len & 1) == 1) {

                for (int j = 0; j < alphabet.length; j++) {
                    if (alphabet[j] == 0)
                        continue;

                    len--;
                    alphabet[j]--;
                    break;
                }

            }

            if (len == 0)
                count++;

        }

        return count;
    }

    @Test
    public void test1() {
        assertEquals(3, maxPalindromesAfterOperations(new String[] { "abbb", "ba", "aa" }));
    }

    @Test
    public void test2() {
        assertEquals(2, maxPalindromesAfterOperations(new String[] { "abc", "ab" }));
    }

    @Test
    public void test3() {
        assertEquals(1, maxPalindromesAfterOperations(new String[] { "cd", "ef", "a" }));
    }

    @Test
    public void test4() {
        assertEquals(3, maxPalindromesAfterOperations(new String[] { "a", "bbb", "ba" }));
    }

    @Test
    public void test5() {
        assertEquals(3, maxPalindromesAfterOperations(new String[] { "adeab", "hhegh", "dddb", "cd" }));
    }

}
