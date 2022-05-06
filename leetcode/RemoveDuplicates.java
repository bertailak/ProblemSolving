package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RemoveDuplicates {

    // https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

    public String removeDuplicates(String s, int k) {

        StringBuilder sb = new StringBuilder(s);
        int i = k - 1;
        while (i < sb.length()) {
            if (i - k + 1 >= 0) {
                boolean hasDuplicate = true;
                for (int j = i - k + 1; j <= i; j++) {
                    if (sb.charAt(i) != sb.charAt(j)) {
                        hasDuplicate = false;
                        break;
                    }
                }
                if (hasDuplicate) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                }
            }
            i++;
        }

        return sb.toString();
    }

    @Test
    public void test1() {
        String s = "abcd";
        int k = 2;
        String expected = "abcd";
        String actual = removeDuplicates(s, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String s = "deeedbbcccbdaa";
        int k = 3;
        String expected = "aa";
        String actual = removeDuplicates(s, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String s = "pbbcggttciiippooaais";
        int k = 2;
        String expected = "ps";
        String actual = removeDuplicates(s, k);
        assertEquals(expected, actual);
    }
}