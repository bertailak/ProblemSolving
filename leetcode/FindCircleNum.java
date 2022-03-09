package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

public class FindCircleNum {

    // https://leetcode.com/problems/number-of-provinces/

    public int findCircleNum(int[][] isConnected) {
        int[] groups = new int[isConnected.length];

        int group = 0;

        for (int i = 0; i < isConnected.length; i++) {

            if (groups[i] == 0) {
                group++;

                Stack<Integer> st = new Stack<>();
                st.add(i);

                while (!st.isEmpty()) {
                    int curr = st.pop();
                    groups[curr] = group;
                    for (int j = 0; j < isConnected[curr].length; j++) {
                        if (groups[j] == 0 && isConnected[curr][j] == 1)
                            st.add(j);
                    }
                }

            }

        }

        int max = groups[0];
        for (int i : groups) {
            max = Math.max(max, i);
        }

        return max;
    }

    @Test
    public void test1() {
        int[][] isConnected = new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        int expected = 2;
        int actual = findCircleNum(isConnected);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[][] isConnected = new int[][] { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
        int expected = 3;
        int actual = findCircleNum(isConnected);
        assertEquals(expected, actual);
    }
}
