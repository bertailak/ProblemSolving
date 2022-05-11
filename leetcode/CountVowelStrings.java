package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountVowelStrings {

    // https://leetcode.com/problems/count-sorted-vowel-strings/

    public int countVowelStrings(int n) {
        int[][] combintions = new int[5][n + 1];
        for (int i = 0; i < combintions.length; i++) {
            combintions[i][1] = 1;
        }

        for (int i = 2; i < combintions[0].length; i++) {
            int count = 0;
            for (int j = 0; j < combintions.length; j++) {
                count += combintions[j][i - 1];
                combintions[j][i] = count;
            }
        }

        int sum = 0;
        for (int i = 0; i < combintions.length; i++) {
            sum += combintions[i][n];
        }

        return sum;
    }

    @Test
    public void test1() {
        int n = 1;
        int expected = 5;
        int actual = countVowelStrings(n);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int n = 2;
        int expected = 15;
        int actual = countVowelStrings(n);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int n = 33;
        int expected = 66045;
        int actual = countVowelStrings(n);
        assertEquals(expected, actual);
    }

}
