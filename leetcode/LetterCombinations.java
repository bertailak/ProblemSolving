package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class LetterCombinations {

    // https://leetcode.com/problems/letter-combinations-of-a-phone-number/
    List<String> result;

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();

        HashMap<Character, List<Character>> map = new HashMap<>();
        map.put('2', List.of('a', 'b', 'c'));
        map.put('3', List.of('d', 'e', 'f'));
        map.put('4', List.of('g', 'h', 'i'));
        map.put('5', List.of('j', 'k', 'l'));
        map.put('6', List.of('m', 'n', 'o'));
        map.put('7', List.of('p', 'q', 'r', 's'));
        map.put('8', List.of('t', 'u', 'v'));
        map.put('9', List.of('w', 'x', 'y', 'z'));

        if (digits.length() > 0)
            helper(map, new StringBuilder(), digits);

        return result;
    }

    public void helper(HashMap<Character, List<Character>> map, StringBuilder sb, String digits) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        List<Character> letters = map.get(digits.charAt(sb.length()));
        for (char letter : letters) {
            sb.append(letter);
            helper(map, sb, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    @Test
    public void test1() {
        String digits = "23";
        List<String> expected = List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        List<String> actual = letterCombinations(digits);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String digits = "";
        List<String> expected = new ArrayList<>();
        List<String> actual = letterCombinations(digits);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String digits = "2";
        List<String> expected = List.of("a", "b", "c");
        List<String> actual = letterCombinations(digits);
        assertEquals(expected, actual);
    }
}