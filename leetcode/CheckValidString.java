package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

public class CheckValidString {
    public boolean checkValidString(String s) {
        int counter = 0;

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.add(s.charAt(i));
            } else if (s.charAt(i) == '*') {
                counter++;
            } else if (s.charAt(i) == ')') {
                if (st.isEmpty()) {
                    if (counter > 0)
                        counter--;
                    else
                        return false;
                } else {
                    st.pop();
                }
            }
        }

        if (st.size() > 0 && st.size() > counter)
            return false;

        return true;
    }

    @Test
    public void test1() {
        assertEquals(true, checkValidString("()"));
    }

    @Test
    public void test2() {
        assertEquals(true, checkValidString("(*)"));
    }

    @Test
    public void test3() {
        assertEquals(true, checkValidString("(*))"));
    }

    @Test
    public void test4() {
        assertEquals(false, checkValidString("("));
    }

    @Test
    public void test5() {
        assertEquals(true, checkValidString(
                "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"));
    }

    @Test
    public void test6() {
        assertEquals(false, checkValidString(
                "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
    }
}
