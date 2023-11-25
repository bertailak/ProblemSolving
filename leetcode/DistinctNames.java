package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class DistinctNames {

    // https://leetcode.com/contest/weekly-contest-297/problems/naming-a-company/

    public long distinctNames(String[] ideas) {
        long count = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < ideas.length; i++) {
            char firstLetter = ideas[i].charAt(0);
            int val = map.getOrDefault(firstLetter, 0);
            map.put(firstLetter, val + 1);
            set.add(ideas[i]);
        }

        for (int i = 0; i < ideas.length; i++) {
            int total = ideas.length;

            for (Character key : map.keySet()) {
                if (set.contains(key + ideas[i].substring(1))) {
                    total -= map.get(key);
                }
            }

            count += total;
        }

        return count;
    }

    @Test
    public void test1() {
        String[] ideas = new String[] { "coffee", "donuts", "time", "toffee" };
        long expected = 6;
        long actual = distinctNames(ideas);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String[] ideas = new String[] { "lack", "back" };
        long expected = 0;
        long actual = distinctNames(ideas);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String[] ideas = new String[] { "aaa", "baa", "caa", "bbb", "cbb", "dbb" };
        long expected = 2;
        long actual = distinctNames(ideas);
        assertEquals(expected, actual);
    }
}
