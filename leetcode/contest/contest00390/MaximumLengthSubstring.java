package leetcode.contest.contest00390;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaximumLengthSubstring {

    public int maximumLengthSubstring(String s) {
        int maxLength = 0;

        int[] alphabet = new int[26];

        int left = 0;
        int right = 0;

        while (right < s.length()) {
            alphabet[s.charAt(right) - 'a']++;

            while (left < right && alphabet[s.charAt(right) - 'a'] > 2) {
                alphabet[s.charAt(left) - 'a']--;
                left++;
            }

            maxLength = Math.max(right - left + 1, maxLength);
            right++;
        }

        return maxLength;
    }

    @Test
    public void test1() {
        assertEquals(4, maximumLengthSubstring("bcbbbcba"));
    }

    @Test
    public void test2() {
        assertEquals(2, maximumLengthSubstring("aaaa"));
    }
}