package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

public class CountCollisions {

    // https://leetcode.com/problems/count-collisions-on-a-road/

    public int countCollisions(String directions) {
        int count = 0;

        Stack<Character> st = new Stack<>();

        for (char c : directions.toCharArray()) {
            if (!st.empty() && c == 'L') {

                if (st.peek() == 'R') {
                    count += 2;
                    st.pop();
                    while (!st.isEmpty() && st.peek() == 'R') {
                        st.pop();
                        count++;
                    }
                    st.push('S');
                } else if (st.peek() == 'S') {
                    count++;
                } else {
                    st.push(c);
                }

            } else if (!st.empty() && c == 'S') {
                while (!st.isEmpty() && st.peek() == 'R') {
                    st.pop();
                    count++;
                }
                st.push(c);
            } else {
                st.push(c);
            }
        }

        return count;
    }

    @Test
    public void test1() {
        String directions = "RLRSLL";
        int expected = 5;
        int actual = countCollisions(directions);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String directions = "LLRR";
        int expected = 0;
        int actual = countCollisions(directions);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String directions = "LLRLRLLSLRLLSLSSSS";
        int expected = 10;
        int actual = countCollisions(directions);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        String directions = "SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR";
        int expected = 20;
        int actual = countCollisions(directions);
        assertEquals(expected, actual);
    }
}
