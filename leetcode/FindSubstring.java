package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class FindSubstring {

    // https://leetcode.com/problems/substring-with-concatenation-of-all-words/

    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, List<Integer>> map = new HashMap<>();

        for (String word : words) {
            map.put(word, new ArrayList<>());
        }

        for (int i = 0; i < s.length(); i++) {
            String substring = s.substring(i);
            for (String word : words) {
                if (substring.startsWith(word)) {
                    map.get(word).add(i);
                }
            }
        }

        for (String key : map.keySet()) {
            List<Integer> indexes = map.get(key);
            for (int index : indexes) {
                System.out.print(index + " ");
            }
            System.out.println();
        }
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[words.length];

        return bactraking(result, map, words, visited, 0);
    }

    private List<Integer> bactraking(List<Integer> wordIndexes, HashMap<String, List<Integer>> map, String[] words,
            boolean[] visited, int index) {

        visited[index] = true;

        for (int i = 0; i < visited.length; i++) {
            if (visited[i])
                continue;

        }

        visited[index] = false;

        return wordIndexes;
    }

    public int binsearch(List<Integer> a, int target) {
        int left = 0;
        int right = a.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a.get(mid) < target) {
                left = mid + 1;
            } else if (a.get(mid) > target) {
                right = mid - 1;
            } else
                return mid;
        }
        return -1;
    }

    @Test
    public void test1() {
        String s = "barfoothefoobarman";
        String[] words = { "foo", "bar" };
        List<Integer> expected = List.of(0, 9);
        List<Integer> actual = findSubstring(s, words);
        assertEquals(expected, actual);
    }
}
