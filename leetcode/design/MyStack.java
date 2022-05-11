package leetcode.design;

import java.util.Deque;
import java.util.LinkedList;

class MyStack {

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
}
