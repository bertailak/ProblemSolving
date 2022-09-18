package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LongestContinuousSubstring {

    public int longestContinuousSubstring(String s) {
        int left = 0;
        int right = 1;
        int index = s.charAt(0) - 'a' + 1;
        int max = 1;

        while (right < s.length()) {
            if (s.charAt(right) == (char) ('a' + index) && index < 26) {
                index++;
                right++;
                max = Math.max(max, right - left);
            } else {
                index = s.charAt(right) - 'a' + 1;
                left = right;
                right++;
            }
        }
        return max;
    }

    @Test
    public void test() {
        assertEquals(2, longestContinuousSubstring("abacaba"));
        assertEquals(5, longestContinuousSubstring("abcde"));
        assertEquals(1, longestContinuousSubstring("z"));
        assertEquals(2, longestContinuousSubstring("yrpjofyzubfsiypfre"));
        assertEquals(2, longestContinuousSubstring("fyzu"));
    }
}
