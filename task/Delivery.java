package task;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class Delivery {

    public boolean delivery(String s) {
        Queue<int[]> q = new LinkedList<>();
        int[] count = new int[2];
        if (s.charAt(0) == 'Z')
            return false;
        count[s.charAt(0) - 'X']++;
        q.add(count);
        int index = 0;

        while (!q.isEmpty() && ++index < s.length()) {
            int size = q.size();
            int ind = s.charAt(index) - 'X';
            for (int i = 0; i < size; i++) {
                int[] top = q.poll();
                if (ind == 0) {
                    q.add(new int[] { top[0] + 1, top[1] });
                }
                if (ind == 1) {
                    if (top[0] > 0) {
                        q.add(new int[] { top[0] - 1, top[1] });
                    }
                    q.add(new int[] { top[0], top[1] + 1 });
                }
                if (ind == 2) {
                    if (top[0] > 0) {
                        q.add(new int[] { top[0] - 1, top[1] });
                    }
                    if (top[1] > 0) {
                        q.add(new int[] { top[0], top[1] - 1 });
                    }
                }
            }
        }
        if (index == s.length() && !q.isEmpty()) {
            while (!q.isEmpty()) {
                int[] top = q.poll();
                if (top[0] == 0 && top[1] == 0) {
                    return true;
                }
            }
        }

        return false;

    }

    @Test
    public void test1() {
        assertEquals(true, delivery("YXYYZZ"));
    }

    @Test
    public void test2() {
        assertEquals(false, delivery("ZYXZ"));
    }

    @Test
    public void test3() {
        assertEquals(true, delivery("XYZXZY"));
    }

    @Test
    public void test4() {
        assertEquals(false, delivery("YYZYZZZZYXYZZXYX"));
    }

    @Test
    public void test5() {
        assertEquals(true, delivery("YYXXYXYZZXYXZZZYZZYY"));
    }

    @Test
    public void test6() {
        assertEquals(true, delivery("XYYXYZZZXY"));
    }
}