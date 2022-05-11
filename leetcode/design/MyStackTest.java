package leetcode.design;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyStackTest {

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
