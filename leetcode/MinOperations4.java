package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinOperations4 {

    // https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string

    public int minOperations(String s) {
        char last = '0';
        int max1 = 0;
        int max2 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != last) {
                max1++;
            }
            last = last == '1' ? '0' : '1';
        }
        last = '1';

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != last) {
                max2++;
            }
            last = last == '1' ? '0' : '1';
        }

        return Math.min(max1, max2);
    }

    @Test
    public void test1() {
        assertEquals(1, minOperations("0100"));
    }

    @Test
    public void test2() {
        assertEquals(0, minOperations("10"));
    }

    @Test
    public void test3() {
        assertEquals(2, minOperations("1111"));
    }

    @Test
    public void test4() {
        assertEquals(2, minOperations("110010"));
    }
}
