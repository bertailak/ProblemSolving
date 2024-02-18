package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class CloseStrings {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;
        int[] alphabet1 = new int[26];
        int[] alphabet2 = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            alphabet1[word1.charAt(i) - 'a']++;
            alphabet2[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < alphabet1.length; i++) {
            if ((alphabet1[i] > 0 && alphabet2[i] == 0) || (alphabet1[i] == 0 && alphabet2[i] > 0))
                return false;
        }

        Arrays.sort(alphabet1);
        Arrays.sort(alphabet2);

        for (int i = 0; i < alphabet1.length; i++) {
            if (alphabet1[i] != alphabet2[i])
                return false;
        }

        return true;
    }

    @Test
    public void test1() {
        assertEquals(true, closeStrings("abc", "bca"));
    }

    @Test
    public void test2() {
        assertEquals(false, closeStrings("a", "aa"));
    }

    @Test
    public void test3() {
        assertEquals(true, closeStrings("cabbba", "abbccc"));
    }

    @Test
    public void test4() {
        assertEquals(true, closeStrings("zaabbccc", "abbcczzz"));
    }

    @Test
    public void test5() {
        assertEquals(false, closeStrings("uau", "ssx"));
    }
}
