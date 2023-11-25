package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

public class RobotWithString {

    // https://leetcode.com/contest/weekly-contest-314/problems/using-a-robot-to-print-the-lexicographically-smallest-string/

    public String robotWithString(String s) {
        int[] alphabet = new int[26];
        for (char i : s.toCharArray()) {
            alphabet[i - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        Stack<Character> t = new Stack<>();
        int index = -1;
        while (sb.length() < s.length()) {
            int min = s.charAt(index + 1);
            for (int i = index + 1; i < s.length(); i++) {
                if (min > s.charAt(i)) {
                    min = i;
                }
            }

            if (t.size() > 0 && t.peek() <= min) {
                char last = t.pop();
                sb.append(last);
                alphabet[last - 'a']--;
            } else {

                if (index == s.length()) {
                    while (!t.isEmpty()) {
                        char last = t.pop();
                        sb.append(last);
                        alphabet[last - 'a']--;
                    }
                } else {

                    while (++index < s.length()) {
                        char c = s.charAt(index);
                        if (c - 'a' == min) {
                            sb.append(c);
                            alphabet[c - 'a']--;
                            break;
                        } else {
                            t.add(c);
                        }
                    }
                }

            }
        }
        return sb.toString();
    }

    @Test
    public void test1() {
        assertEquals("azz", robotWithString("zza"));
    }

    @Test
    public void test2() {
        assertEquals("abc", robotWithString("bac"));
    }

    @Test
    public void test3() {
        assertEquals("addb", robotWithString("bdda"));
    }

    @Test
    public void test4() {
        assertEquals("bdevfziy", robotWithString("bydizfve"));
    }

    @Test
    public void test5() {
        assertEquals("fnohopzv", robotWithString("vzhofnpo"));
    }

}
