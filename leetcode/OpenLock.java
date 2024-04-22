package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class OpenLock {

    public int openLock(String[] deadends, String target) {
        String init = "0000";
        if (target.equals(init))
            return 0;
        HashSet<String> set = new HashSet<>(Arrays.asList(deadends));
        Queue<String> q = new LinkedList<>();
        if (!set.contains(init)) {
            q.add(init);
            set.add(init);
        }

        int step = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                StringBuilder sb = new StringBuilder(q.poll());
                if (target.equals(sb.toString()))
                    return step;

                for (int j = 0; j < 4; j++) {

                    int val = sb.charAt(j) - '0';
                    int prev = (val + 9) % 10;
                    int next = (val + 1) % 10;

                    sb.setCharAt(j, (char) (prev + '0'));
                    if (!set.contains(sb.toString())) {
                        q.add(sb.toString());
                        set.add(sb.toString());
                    }

                    sb.setCharAt(j, (char) (next + '0'));
                    if (!set.contains(sb.toString())) {
                        q.add(sb.toString());
                        set.add(sb.toString());
                    }
                    sb.setCharAt(j, (char) (val + '0'));
                }
            }

            step++;
        }

        return -1;
    }

    @Test
    public void test1() {
        assertEquals(6, openLock(new String[] { "0201", "0101", "0102", "1212", "2002" }, "0202"));
    }

    @Test
    public void test2() {
        assertEquals(1, openLock(new String[] { "8888" }, "0009"));
    }

    @Test
    public void test3() {
        assertEquals(-1, openLock(new String[] { "0000" }, "8888"));
    }

}
