package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class RemoveAnagrams {

    // https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/

    public List<String> removeAnagrams(String[] words) {
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        char[] letters1 = words[0].toCharArray();
        Arrays.sort(letters1);
        String last = new String(letters1);

        for (int i = 1; i < words.length; i++) {
            if (words[i - 1].length() == words[i].length()) {
                char[] letters = words[i].toCharArray();
                Arrays.sort(letters);
                String current = new String(letters);
                if (!current.equals(last)) {
                    list.add(words[i]);
                    last = current;
                }
            } else {
                list.add(words[i]);
                char[] letters = words[i].toCharArray();
                Arrays.sort(letters);
                last = new String(letters);
            }
        }

        return list;
    }

    @Test
    public void test1() {
        String[] words = new String[] { "abba", "baba", "bbaa", "cd", "cd" };
        List<String> expected = List.of("abba", "cd");
        List<String> actual = removeAnagrams(words);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String[] words = new String[] { "a", "b", "c", "d", "e" };
        List<String> expected = List.of("a", "b", "c", "d", "e");
        List<String> actual = removeAnagrams(words);
        assertEquals(expected, actual);
    }
}
