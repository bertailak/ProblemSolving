package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinOperations3 {

    public int minOperations(int n) {
        String binary = "0" + Integer.toBinaryString(n);
        System.out.println(n + ": " + binary);
        int count = 0;
        int i = binary.length() - 1;
        char[] bins = binary.toCharArray();
        while (i >= 0) {
            if (bins[i] == '1') {
                while (i >= 0 && bins[i] == '1') {
                    bins[i] = '0';
                    i--;
                }
                bins[i] = '1';
                count++;
                i++;
            }
            i--;
        }

        return count;
    }

    @Test
    public void test1() {
        // assertEquals(3, minOperations(39));
        assertEquals(3, minOperations(54));
    }

    @Test
    public void test2() {
        assertEquals(3, minOperations(38));
        assertEquals(3, minOperations(27));
    }
}
