package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class PredictPartyVictory {

    // https://leetcode.com/problems/dota2-senate/description/

    public String predictPartyVictory(String senate) {
        boolean[] banned = new boolean[senate.length()];

        Queue<Integer> qr = new LinkedList<>();
        Queue<Integer> qd = new LinkedList<>();

        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R')
                qr.add(i);
            else
                qd.add(i);
        }

        while (!qr.isEmpty() && !qd.isEmpty()) {
            int r = qr.peek();
            int d = qd.peek();
            if (r < d) {
                banned[d] = true;
                qd.poll();
            } else {
                banned[r] = true;
                qr.poll();
            }
        }

        return qr.isEmpty() ? "Dire" : "Radiant";
    }

    @Test
    public void test1() {
        assertEquals("Radiant", predictPartyVictory("RD"));
    }

    @Test
    public void test2() {
        assertEquals("Dire", predictPartyVictory("RDD"));
    }
}