package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountKeyChanges {
    public int countKeyChanges(String s) {
        int count = 0;

        s = s.toLowerCase();

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1))
                count++;
        }

        return count;
    }

    @Test
    public void test1() {
        assertEquals(2, countKeyChanges("aAbBcC"));
    }

    @Test
    public void test2() {
        assertEquals(0, countKeyChanges("AaAaAaaA"));
    }
}
