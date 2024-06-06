package leetcode.contest.contest00397;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FindPermutationDifference {
    
    public int findPermutationDifference(String s, String t) {
        int[] alphabet = new int[26];
        int diff = 0;

        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            diff += Math.abs(alphabet[t.charAt(i) - 'a'] - i);
        }

        return diff;
    }

    @Test
    public void test1() {
        assertEquals(2, findPermutationDifference("abc", "bac"));
    }
}
