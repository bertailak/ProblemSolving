package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinimumTimeToInitialState {

    public int minimumTimeToInitialState(String word, int k) {

        if (word.length() == k)
            return 1;

        int count = 0;

        StringBuilder sb = new StringBuilder(word);

        int step = sb.length();
        for (int i = 1; i < word.length(); i++) {
            String s1 = sb.substring(0, i);
            String s2 = sb.substring(sb.length() - i, sb.length());
            if (s1.equals(s2))
                step = sb.length() - i;
        }

        // if (step < k) {
        //     int lcm = step + step;
        //     while (lcm % k != 0) {
        //         lcm += step;
        //     }
        //     return lcm / k;
        // }

        count = (step + k - 1) / k;

        return count;
    }

    @Test
    public void test1() {
        assertEquals(2, minimumTimeToInitialState("abacaba", 3));
    }

    @Test
    public void test2() {
        assertEquals(1, minimumTimeToInitialState("abacaba", 4));
    }

    @Test
    public void test3() {
        assertEquals(4, minimumTimeToInitialState("abcbabcd", 2));
    }

    @Test
    public void test4() {
        assertEquals(1, minimumTimeToInitialState("aa", 1));
    }

    @Test
    public void test5() {
        assertEquals(2, minimumTimeToInitialState("baba", 3));
    }

    @Test
    public void test6() {
        assertEquals(1, minimumTimeToInitialState("baaba", 5));
    }

    @Test
    public void test7() {
        assertEquals(1, minimumTimeToInitialState("aabaaa", 5));
    }
}
