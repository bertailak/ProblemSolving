package leetcode.contest.contest00389;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountSubstrings {
    
    public long countSubstrings(String s, char c) {
        long count = 0;
        int ind = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count += ++ind;
            }
        }

        return count;
    }

    @Test
    public void test1() {
        assertEquals(6, countSubstrings("abada", 'a'));
    }

    @Test
    public void test2() {
        assertEquals(6, countSubstrings("zzz", 'z'));
    }

    @Test
    public void test3() {
        assertEquals(0, countSubstrings("goxo", 'q'));
    }

    @Test
    public void test4() {
        assertEquals(15, countSubstrings("eeeee", 'e'));
    }
}
