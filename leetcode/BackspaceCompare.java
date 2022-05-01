package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

public class BackspaceCompare {

    // https://leetcode.com/problems/backspace-string-compare/

    public boolean backspaceCompare(String s, String t) {

        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!stackS.empty())
                    stackS.pop();
            } else
                stackS.add(s.charAt(i));
        }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') {
                if (!stackT.empty())
                    stackT.pop();
            } else
                stackT.add(t.charAt(i));
        }

        if (stackS.size() != stackT.size())
            return false;

        while (!stackS.isEmpty() && !stackT.isEmpty()) {
            if (stackS.pop() != stackT.pop())
                return false;
        }

        return stackS.size() == stackT.size();
    }

    @Test
    public void test1() {
        String s = "ab#c";
        String t = "ad#c";
        boolean expected = true;
        boolean actual = backspaceCompare(s, t);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String s = "ab##";
        String t = "c#d#";
        boolean expected = true;
        boolean actual = backspaceCompare(s, t);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String s = "a#c";
        String t = "b";
        boolean expected = false;
        boolean actual = backspaceCompare(s, t);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        String s = "a##c";
        String t = "#a#c";
        boolean expected = true;
        boolean actual = backspaceCompare(s, t);
        assertEquals(expected, actual);
    }
}
