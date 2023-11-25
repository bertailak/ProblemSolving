package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.PriorityQueue;

import org.junit.Test;

public class FindMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        int substrLength = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

        for (int i = 0; i < strs.length; i++) {
            int countOnes = 0;
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].length() == '1')
                    countOnes++;
            }

            pq.add(new int[] { strs[i].length(), countOnes, strs[i].length() - countOnes });
        }

        int[] top = pq.poll();

        while (!pq.isEmpty() && (m - top[2] >= 0 && n - top[1] >= 0)) {
            substrLength++;

            m -= top[2];
            n -= top[1];

            top = pq.poll();
        }

        return substrLength;
    }

    @Test
    public void test1() {
        String[] strs = new String[] { "10", "0001", "111001", "1", "0" };
        int m = 5;
        int n = 3;
        int expected = 4;
        int actual = findMaxForm(strs, m, n);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String[] strs = new String[] { "10", "0", "1" };
        int m = 1;
        int n = 1;
        int expected = 2;
        int actual = findMaxForm(strs, m, n);
        assertEquals(expected, actual);
    }
}
