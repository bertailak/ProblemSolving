package leetcode.contest.contest00395;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinEnd {

    int count = 0;
    Long result = 0L;

    public long minEnd(int n, int x) {
        if (n == 1)
            return x;
        count = n - 1;
        String s = Integer.toBinaryString(x);
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        int pow = sb.length();
        for (int i = sb.length(); i < 32; i++) {
            sb.append('0');
        }
        dfs(sb, pow);
        return result;
    }

    private void dfs(StringBuilder sb, int pow) {
        for (int i = 0; i < pow; i++) {
            if (count == 0)
                break;
            if (sb.charAt(i) == '1')
                continue;
            sb.setCharAt(i, '1');
            count--;
            if (count == 0) {
                sb.reverse();
                result = Long.parseLong(sb.toString(), 2);
                break;
            }
            sb.setCharAt(i, '0');
        }
        if (count == 0)
            return;
        int ind = -1;
        while (++ind < pow) {
            if (sb.charAt(ind) == '1')
                continue;
            sb.setCharAt(ind, '1');
            pow = Math.max(pow, ind + 1);
            break;
        }
        if (ind == pow) {
            count--;
            sb.setCharAt(ind, '1');
            pow = Math.max(pow, ind + 1);
        }
        if (count == 0) {
            sb.reverse();
            result = Long.parseLong(sb.toString(), 2);
        }

        dfs(sb, pow);
    }

    @Test
    public void test1() {
        assertEquals(6, minEnd(3, 4));
    }

    @Test
    public void test2() {
        assertEquals(7, minEnd(4, 4));
    }

    @Test
    public void test3() {
        assertEquals(15, minEnd(2, 7));
    }

    @Test
    public void test4() {
        assertEquals(1, minEnd(1, 1));
    }

    @Test
    public void test5() {
        assertEquals(5, minEnd(3, 1));
    }
}
