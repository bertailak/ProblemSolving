package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class OddString {
    public String oddString(String[] words) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < word.length(); i++) {
                int diff = word.charAt(i) - word.charAt(i - 1);
                sb.append(diff);
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(word);
            map.put(key, list);
        }

        String result = "";
        for (String key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
            if (map.get(key).size() == 1) {
                result = map.get(key).get(0);
                break;
            }
        }
        System.out.println("---------");
        return result;
    }

    @Test
    public void test1() {
        assertEquals("abc", oddString(new String[] { "adc", "wzy", "abc" }));
    }

    @Test
    public void test2() {
        assertEquals("bob", oddString(new String[] { "aaa", "bob", "ccc", "ddd" }));
    }
}
