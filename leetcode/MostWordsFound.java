package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MostWordsFound {

    // https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/

    public int mostWordsFound(String[] sentences) {
        int max = sentences[0].split(" ").length;

        for (int i = 1; i < sentences.length; i++) {
            max = Math.max(max, sentences[i].split(" ").length);
        }

        return max;
    }

    @Test
    public void test1() {
        String[] sentences = new String[] { "alice and bob love leetcode", "i think so too",
                "this is great thanks very much" };
        int expected = 6;
        int actual = mostWordsFound(sentences);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String[] sentences = new String[] { "please wait", "continue to fight", "continue to win" };
        int expected = 3;
        int actual = mostWordsFound(sentences);
        assertEquals(expected, actual);
    }

}
