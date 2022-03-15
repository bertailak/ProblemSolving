package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

public class MinRemoveToMakeValid {

    // https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

    public String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> indexes = new Stack<>();
        boolean[] b = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                if (s.charAt(i) == '(') {
                    indexes.push(i);
                } else {
                    if (indexes.isEmpty()) {
                        b[i] = true;
                    } else {
                        indexes.pop();
                    }
                }
            }
        }
        while (!indexes.isEmpty()) {
            b[indexes.pop()] = true;
        }

        for (int i = 0; i < b.length; i++) {
            if (!b[i])
                result.append(s.charAt(i));
        }

        return result.toString();
    }

    @Test
    public void test1() {
        String s = "lee(t(c)o)de)";
        String expected = "lee(t(c)o)de";
        String actual = minRemoveToMakeValid(s);
        assertEquals(expected, actual);
    }

}
