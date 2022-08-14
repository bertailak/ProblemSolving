package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SmallestNumber {

    public String smallestNumber(String pattern) {
        char[] result = new char[pattern.length() + 1];

        int index = 0;

        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'I') {
                result[i] = (char) ('1' + (index++));

                int j = i - 1;
                while (j >= 0 && result[j] < '0') {
                    result[j] = (char) ('1' + (index++));
                    j--;
                }

            }
        }

        int j2 = pattern.length();
        while (j2 >= 0 && result[j2] < '0') {
            result[j2] = (char) ('1' + (index++));
            j2--;
        }

        return String.valueOf(result);
    }

    @Test
    public void test1() {
        String pattern = "IIIDIDDD";
        String expected = "123549876";
        String actual = smallestNumber(pattern);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String pattern = "DDD";
        String expected = "4321";
        String actual = smallestNumber(pattern);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String pattern = "DDDIII";
        String expected = "4321567";
        String actual = smallestNumber(pattern);
        assertEquals(expected, actual);
    }
}
