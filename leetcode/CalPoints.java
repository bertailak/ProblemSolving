package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

public class CalPoints {

    // https://leetcode.com/problems/baseball-game/

    public int calPoints(String[] ops) {
        int result = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("+")) {
                int top = stack.pop();
                int sum = top + stack.peek();
                stack.push(top);
                stack.push(sum);
            } else if (ops[i].equals("D")) {
                stack.push(2 * stack.peek());
            } else if (ops[i].equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(ops[i]));
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    @Test
    public void test1() {
        String[] ops = new String[] { "5", "2", "C", "D", "+" };
        int expected = 30;
        int actual = calPoints(ops);
        assertEquals(expected, actual);
    }
}
