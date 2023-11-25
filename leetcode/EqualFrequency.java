package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EqualFrequency {
    int M = 26;

    public int getIdx(char ch) {
        return (ch - 'a');
    }

    public boolean allSame(int freq[], int N) {
        int same = 0;

        int i;
        for (i = 0; i < N; i++) {
            if (freq[i] > 0) {
                same = freq[i];
                break;
            }
        }

        for (int j = i + 1; j < N; j++)
            if (freq[j] > 0 && freq[j] != same)
                return false;

        return true;
    }

    public boolean equalFrequency(String word) {
        int l = word.length();

        int[] freq = new int[M];

        for (int i = 0; i < l; i++)
            freq[getIdx(word.charAt(i))]++;

        int same = 0;

        for (int j = 0; j < M; j++) {
            if (freq[j] > 0) {
                same = freq[j];
                break;
            }
        }

        if (allSame(freq, M) && same == 1)
            return true;

        for (char c = 'a'; c <= 'z'; c++) {
            int i = getIdx(c);

            if (freq[i] > 0) {
                freq[i]--;

                if (allSame(freq, M))
                    return true;
                freq[i]++;
            }
        }

        return false;
    }

    @Test
    public void test1() {
        assertEquals(true, equalFrequency("abcc"));
    }

    @Test
    public void test2() {
        assertEquals(false, equalFrequency("aazz"));
    }

    @Test
    public void test3() {
        assertEquals(true, equalFrequency("bac"));
    }

    @Test
    public void test4() {
        assertEquals(true, equalFrequency("acbda"));
    }

    @Test
    public void test5() {
        assertEquals(true, equalFrequency("abbcc"));
    }

}