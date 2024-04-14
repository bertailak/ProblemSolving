package leetcode.contest.contest00393;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FindLatestTime {
    public String findLatestTime(String s) {
        StringBuilder sb = new StringBuilder();

        if (s.charAt(0) != '?' && s.charAt(1) != '?') {
            sb.append(s.charAt(0));
            sb.append(s.charAt(1));
        } else if (s.charAt(0) == '?' && s.charAt(1) == '?') {
            sb.append("11");
        } else {
            if (s.charAt(0) == '?') {
                if (s.charAt(1) == '1' || s.charAt(1) == '0') {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
                sb.append(s.charAt(1));
            } else {
                sb.append(s.charAt(0));
                if (sb.charAt(0) == '1') {
                    sb.append("1");
                } else {
                    sb.append("9");
                }
            }
        }

        sb.append(":");

        if (s.charAt(3) != '?' && s.charAt(4) != '?') {
            sb.append(s.charAt(3));
            sb.append(s.charAt(4));
        } else if (s.charAt(3) == '?' && s.charAt(4) == '?') {
            sb.append("59");
        } else {
            if (s.charAt(3) == '?') {
                sb.append("5");
                sb.append(s.charAt(4));
            } else {
                sb.append(s.charAt(3));
                sb.append("9");
            }
        }

        return sb.toString();
    }

    @Test
    public void test1() {
        assertEquals("11:54", findLatestTime("1?:?4"));
    }

    @Test
    public void test2() {
        assertEquals("09:59", findLatestTime("0?:5?"));
    }

    @Test
    public void test3() {
        assertEquals("03:12", findLatestTime("?3:12"));
    }

    @Test
    public void test4() {
        assertEquals("11:19", findLatestTime("??:1?"));
    }
}
