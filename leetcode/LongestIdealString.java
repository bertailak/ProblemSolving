package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

public class LongestIdealString {

    public int longestIdealString(String s, int k) {
        int max = 1;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            int val = 1;

            for (int j = -k; j <= k; j++) {
                if (map.containsKey(index + j))
                    val = Math.max(val, map.get(index + j) + 1);
            }
            map.put(index, val);

            max = Math.max(max, val);

        }

        return max;
    }

    @Test
    public void test1() {
        assertEquals(4, longestIdealString("acfgbd", 2));
    }

    @Test
    public void test2() {
        assertEquals(4, longestIdealString("abcd", 3));
    }
}
