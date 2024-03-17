package leetcode.contest.contest00389;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class MinimumDeletions {

    public int minimumDeletions(String word, int k) {

        int min = Integer.MAX_VALUE;
        int sum = word.length();

        int[] alphabet = new int[26];

        for (int i = 0; i < word.length(); i++) {
            alphabet[word.charAt(i) - 'a']++;
        }

        Arrays.sort(alphabet);

        for (int i = 0; i < alphabet.length; i++) {
            int j = i;
            int currSum = 0;
            while (j < alphabet.length) {
                currSum += Math.min(alphabet[j], alphabet[i] + k);
                j++;
            }

            min = Math.min(min, sum - currSum);

        }

        return min;
    }

    @Test
    public void test1() {
        assertEquals(3, minimumDeletions("aabcaba", 0));
    }

    @Test
    public void test2() {
        assertEquals(2, minimumDeletions("dabdcbdcdcd", 2));
    }

    @Test
    public void test3() {
        assertEquals(1, minimumDeletions("aaabaaa", 2));
    }

}
