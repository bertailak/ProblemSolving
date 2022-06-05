package leetcode.design;

import static org.junit.Assert.assertEquals;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;

public class MyStack {

    // https://leetcode.com/problems/implement-stack-using-queues/

    private Deque<Integer> deque;

    public MyStack() {
        deque = new LinkedList<>();
    }

    public void push(int x) {
        deque.push(x);
    }

    public int pop() {
        return deque.pop();
    }

    public int top() {
        return deque.peek();
    }

    public boolean empty() {
        return deque.isEmpty();
    }

    @Test
    public void test1() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.top());
        assertEquals(2, stack.pop());
        assertEquals(false, stack.empty());
    }
}
