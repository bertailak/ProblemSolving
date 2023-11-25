package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

public class MinWindow {
    public String minWindow(String s, String t) {
        String result = "";

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();
        for (char l : t.toCharArray()) {
            tmap.put(l, tmap.getOrDefault(l, 0) + 1);
        }

        int left = 0;
        int right = 0;

        while (left < s.length()) {

            if (right < s.length())
                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            else
                left++;

            boolean isEqual = true;
            for (char l : tmap.keySet()) {
                int value = map.getOrDefault(l, 0);
                if (value == 0 || value < tmap.get(l)) {
                    isEqual = false;
                    break;
                }
            }

            if (isEqual) {
                if (result != "" && result.length() > right - left + 1) {
                    result = s.substring(left, right);
                }

                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }

            right++;
        }

        return result;
    }

    @Test
    public void test1() {
        assertEquals("BANC", minWindow("ADOBECODEBANC", "ABC"));
    }

}
