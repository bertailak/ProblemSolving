package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        List<Integer> values1 = new ArrayList<>();
        List<Integer> values2 = new ArrayList<>();

        boolean isZero = true;
        for (int i = 0; i < word1.length(); i++) {
            if (isZero && alphabet1[i] - alphabet2[i] != 0) {
                isZero = false;
            }
        }
        if (isZero)
            return true;

        for (int i = 0; i < alphabet1.length; i++) {
            if (alphabet1[i] != 0)
                values1.add(alphabet1[i]);
            if (alphabet2[i] != 0)
                values2.add(alphabet2[i]);
        }

        if (values1.size() != values2.size())
            return false;
        Collections.sort(values1);
        Collections.sort(values2);
        boolean isEqual = true;
        for (int i = 0; i < values1.size(); i++) {
            if (values1.get(i) != values2.get(i)) {
                isEqual = false;
                break;
            }
        }

        if (isEqual)
            return true;

        return false;
    }

    @Test
    public void test1() {
        assertEquals(true, closeStrings("abc", "bca"));
        assertEquals(false, closeStrings("a", "aa"));
        assertEquals(true, closeStrings("cabbba", "abbccc"));
    }

    @Test
    public void test2() {
        assertEquals(true, closeStrings("zaabbccc", "abbcczzz"));
    }
}
