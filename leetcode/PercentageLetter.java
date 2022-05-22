package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PercentageLetter {

    // https://leetcode.com/problems/percentage-of-letter-in-string/

    public int percentageLetter(String s, char letter) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter)
                count++;
        }
        return count * 100 / s.length();
    }

    @Test
    public void test1() {
        String s = "foobar";
        char letter = 'o';
        int expected = 33;
        int actual = percentageLetter(s, letter);
        assertEquals(expected, actual);
    }
}
