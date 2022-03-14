package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

public class SimplifyPath {

    // https://leetcode.com/problems/simplify-path/

    public String simplifyPath(String path) {
        String result = "";
        Stack<String> stack = new Stack<>();

        path = path.replaceAll("//", "/");

        for (String name : path.split("/")) {
            if (name.trim().length() > 0 && !name.equals(".")) {
                if (name.equals("..")) {
                    if (!stack.isEmpty())
                        stack.pop();
                } else
                    stack.add(name);
            }
        }

        while (!stack.isEmpty()) {
            result = "/" + stack.pop() + result;
        }
        if (result.length() == 0)
            result = "/";

        return result;
    }

    @Test
    public void tes1() {
        String path = "/home/";
        String expected = "/home";
        String actual = simplifyPath(path);
        assertEquals(expected, actual);
    }

    @Test
    public void tes2() {
        String path = "/../";
        String expected = "/";
        String actual = simplifyPath(path);
        assertEquals(expected, actual);
    }

    @Test
    public void tes3() {
        String path = "/home//foo/";
        String expected = "/home/foo";
        String actual = simplifyPath(path);
        assertEquals(expected, actual);
    }

    public void tes4() {
        String path = "/a/./b/../../c/";
        String expected = "/c";
        String actual = simplifyPath(path);
        assertEquals(expected, actual);
    }

}
