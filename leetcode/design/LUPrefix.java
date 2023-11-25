package leetcode.design;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LUPrefix {

    boolean[] videos;
    int longest = 0;

    public LUPrefix() {
    }

    public void setN(int n) {
        videos = new boolean[n];
    }

    // public LUPrefix(int n) {
    // videos = new boolean[n];
    // }

    public void upload(int video) {
        videos[video - 1] = true;
    }

    public int longest() {
        while (longest < videos.length && videos[longest]) {
            longest++;
        }

        return longest;
    }

    @Test
    public void test1() {
        LUPrefix l = new LUPrefix();
        l.setN(4);
        l.upload(3);
        assertEquals(0, l.longest());
        l.upload(1);
        assertEquals(1, l.longest());
        l.upload(2);
        assertEquals(3, l.longest());
    }
}
