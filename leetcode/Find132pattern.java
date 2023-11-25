package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

public class Find132pattern {

    // https://leetcode.com/problems/132-pattern/

    public boolean find132pattern(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int second = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < second)
                return true;
            while (!stack.isEmpty() && nums[i] > stack.peek())
                second = stack.pop();
            stack.push(nums[i]);
        }
        return false;
    }

    @Test
    public void test1() {
        int[] nums = new int[] { 1, 2, 3, 4 };
        boolean expected = false;
        boolean actual = find132pattern(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = new int[] { 3, 1, 4, 2 };
        boolean expected = true;
        boolean actual = find132pattern(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] nums = new int[] { -1, 3, 2, 0 };
        boolean expected = true;
        boolean actual = find132pattern(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[] nums = new int[] { -2, 1, -2 };
        boolean expected = false;
        boolean actual = find132pattern(nums);
        assertEquals(expected, actual);
    }
}