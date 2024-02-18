package leetcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class CountOfPairs2 {

    public long[] countOfPairs(int n, int x, int y) {
        long[] result = new long[n];

        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            visited[i] = true;

            int step = 0;

            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {

                    int top = q.poll();
                    if (top > 1 && !visited[top - 1]) {
                        q.add(top - 1);
                        visited[top - 1] = true;
                    }

                    if (top < n && !visited[top + 1]) {
                        q.add(top + 1);
                        visited[top + 1] = true;
                    }

                    if (x == top && !visited[y]) {
                        q.add(y);
                        visited[y] = true;
                    }
                    if (y == top && !visited[x]) {
                        q.add(x);
                        visited[x] = true;
                    }
                }
                result[step] += q.size();
                step++;
            }

        }

        return result;
    }

    @Test
    public void test1() {
        assertArrayEquals(new long[] { 6, 0, 0 }, countOfPairs(3, 1, 3));
    }

    @Test
    public void test2() {
        assertArrayEquals(new long[] { 10, 8, 2, 0, 0 }, countOfPairs(5, 2, 4));
    }

    @Test
    public void test3() {
        assertArrayEquals(new long[] { 6, 4, 2, 0 }, countOfPairs(4, 1, 1));
    }
}
