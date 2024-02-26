package leetcode.contest.contest00385;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountPrefixSuffixPairs {

    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;

        for (int i = 0; i < words.length - 1; i++) {

            for (int j = i + 1; j < words.length; j++) {

                if (isPrefixAndSuffix(words[i], words[j]))
                    count++;

            }

        }

        return count;
    }

    private boolean isPrefixAndSuffix(String s1, String s2) {

        if (s1.length() > s2.length())
            return false;

        if (!s2.startsWith(s1))
            return false;

        if (!s2.endsWith(s1))
            return false;

        return true;
    }

    @Test
    public void test1() {
        assertEquals(4, countPrefixSuffixPairs(new String[] { "a", "aba", "ababa", "aa" }));
    }

    @Test
    public void test2() {
        assertEquals(2, countPrefixSuffixPairs(new String[] { "pa", "papa", "ma", "mama" }));
    }

    @Test
    public void test3() {
        assertEquals(0, countPrefixSuffixPairs(new String[] { "abab", "ab" }));
    }
}
