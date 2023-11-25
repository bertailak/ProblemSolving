package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppendCharacters {
    public int appendCharacters(String s, String t) {
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            if (index < t.length() && s.charAt(i) == t.charAt(index))
                index++;
        }

        return t.length() - index;
    }

    @Test
    public void test1() {
        assertEquals(4, appendCharacters("coaching", "coding"));
    }

    @Test
    public void test2() {
        assertEquals(0, appendCharacters("abcde", "a"));
    }

    @Test
    public void test3() {
        assertEquals(5, appendCharacters("z", "abcde"));
    }

    @Test
    public void test4() {
        assertEquals(2, appendCharacters("vrykt", "rkge"));
    }
}