package leetcode.contest.contest00389;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IsSubstringPresent {

    public boolean isSubstringPresent(String s) {

        for (int i = 0; i < s.length() - 1; i++) {
            String sub = s.charAt(i + 1) + "" + s.charAt(i);
            if (s.contains(sub))
                return true;
        }

        return false;
    }

    @Test
    public void test1() {
        assertEquals(true, isSubstringPresent("leetcode"));
        assertEquals(true, isSubstringPresent("abcba"));
    }

    @Test
    public void test2() {
        assertEquals(false, isSubstringPresent("abcd"));
    }
}
