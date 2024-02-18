package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class MinimumPushes {
    public int minimumPushes(String word) {
        int[] alphabet = new int[26];

        for (int i = 0; i < word.length(); i++) {
            alphabet[word.charAt(i) - 'a']++;
        }

        Arrays.sort(alphabet);

        int count = 0;
        int order = 0;

        for (int i = 0; i < alphabet.length; i++) {
            if (i % 8 == 0)
                order++;
            int n = alphabet[alphabet.length - 1 - i];
            count += n * order;
        }

        return count;
    }

    @Test
    public void test1() {
        assertEquals(5, minimumPushes("abcde"));
    }

    @Test
    public void test2() {
        assertEquals(12, minimumPushes("xycdefghij"));
    }

    @Test
    public void test3() {
        assertEquals(12, minimumPushes("xyzxyzxyzxyz"));
    }

    @Test
    public void test4() {
        assertEquals(24, minimumPushes("aabbccddeeffgghhiiiiii"));
    }
}
