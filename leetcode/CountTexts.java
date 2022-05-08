package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountTexts {

    // https://leetcode.com/contest/weekly-contest-292/problems/count-number-of-texts/

    public int countTexts(String pressedKeys) {
        long result = 1L;
        int mod = 1_000_000_007;
        char letter = '0';
        int count = 1;

        int[] d3 = new int[pressedKeys.length() + 1];
        int[] d4 = new int[pressedKeys.length() + 1];
        d3[0] = 1;
        d4[0] = 1;
        for (int i = 1; i < d3.length; i++) {
            for (int j = 1; j <= Math.min(i, 3); j++) {
                d3[i] += d3[i - j];
                d3[i] %= mod;
            }
            for (int j = 1; j <= Math.min(i, 4); j++) {
                d4[i] += d4[i - j];
                d4[i] %= mod;
            }
        }

        for (int i = 0; i < pressedKeys.length(); i++) {
            if (pressedKeys.charAt(i) == letter) {
                count++;
            } else {
                int texts = d3[count];
                if (letter == '7' || letter == '9')
                    texts = d4[count];
                result = (result * texts) % mod;

                letter = pressedKeys.charAt(i);
                count = 1;
            }
        }

        int texts = d3[count];
        if (letter == '7' || letter == '9')
            texts = d4[count];
        result = (result * texts) % mod;

        return (int) result;
    }

    @Test
    public void test1() {
        String pressedKeys = "22233";
        int expected = 8;
        int actual = countTexts(pressedKeys);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String pressedKeys = "2222";
        int expected = 7;
        int actual = countTexts(pressedKeys);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String pressedKeys = "88888888888888888888888888888999999999999999999999999999994444444444444444444444444444488888888888888888888888888888555555555555555555555555555556666666666666666666666666666666666666666666666666666666666222222222222222222222222222226666666666666666666666666666699999999999999999999999999999888888888888888888888888888885555555555555555555555555555577777777777777777777777777777444444444444444444444444444444444444444444444444444444444433333333333333333333333333333555555555555555555555555555556666666666666666666666666666644444444444444444444444444444999999999999999999999999999996666666666666666666666666666655555555555555555555555555555444444444444444444444444444448888888888888888888888888888855555555555555555555555555555555555555555555555555555555555555555555555555555555555999999999999999555555555555555555555555555554444444444444444444444444444444555";
        int expected = 886136986;
        int actual = countTexts(pressedKeys);
        assertEquals(expected, actual);
    }
}
