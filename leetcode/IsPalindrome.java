package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IsPalindrome {

    // https://leetcode.com/problems/valid-palindrome/

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9'))
                sb.append(s.charAt(i));
        }

        int l = 0;
        int r = sb.length() - 1;
        while (l < r) {

            if (sb.charAt(l) != sb.charAt(r))
                return false;

            l++;
            r--;
        }

        return true;
    }

    @Test
    public void test1() {
        String s = "A man, a plan, a canal: Panama";
        boolean expected = true;
        boolean actual = isPalindrome(s);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String s = "race a car";
        boolean expected = false;
        boolean actual = isPalindrome(s);
        assertEquals(expected, actual);
    }
}
