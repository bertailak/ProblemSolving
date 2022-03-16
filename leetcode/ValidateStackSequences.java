package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

public class ValidateStackSequences {

    // https://leetcode.com/problems/validate-stack-sequences/

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        if (pushed.length != popped.length)
            return false;

        Stack<Integer> stack = new Stack<>();
        int j = 0;

        for (int i = 0; i < pushed.length; i++) {
            stack.add(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }

    @Test
    public void test1() {
        int[] pushed = new int[] { 1, 2, 3, 4, 5 };
        int[] popped = new int[] { 4, 5, 3, 2, 1 };
        boolean expected = true;
        boolean actual = validateStackSequences(pushed, popped);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] pushed = new int[] { 1, 2, 3, 4, 5 };
        int[] popped = new int[] { 4, 3, 5, 1, 2 };
        boolean expected = false;
        boolean actual = validateStackSequences(pushed, popped);
        assertEquals(expected, actual);
    }
}
