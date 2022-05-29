package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RearrangeCharacters {

    // https://leetcode.com/problems/rearrange-characters-to-make-target-string/

    public int rearrangeCharacters(String s, String target) {
        int count = 0;

        int[] alpha = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a']++;
        }

        while (true) {

            boolean isCopy = true;

            for (int i = 0; i < target.length(); i++) {
                if (--alpha[target.charAt(i) - 'a'] < 0) {
                    isCopy = false;
                    break;
                }
            }

            if (isCopy) {
                count++;
            } else {
                break;
            }

        }

        return count;
    }

    @Test
    public void test1() {
        String s = "ilovecodingonleetcode";
        String target = "code";
        int expected = 2;
        int actual = rearrangeCharacters(s, target);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String s = "abcba";
        String target = "abc";
        int expected = 1;
        int actual = rearrangeCharacters(s, target);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String s = "abbaccaddaeea";
        String target = "aaaaa";
        int expected = 1;
        int actual = rearrangeCharacters(s, target);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        String s = "lrnvlcqukanpdnluowenfxquitzryponxsikhciohyostvmkapkfpglzikitwiraqgchxnpryhwpuwpozacjhmwhjvslprqlnxrk";
        String target = "woijih";
        int expected = 2;
        int actual = rearrangeCharacters(s, target);
        assertEquals(expected, actual);
    }
}
