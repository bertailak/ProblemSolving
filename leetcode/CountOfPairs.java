package leetcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class CountOfPairs {

    public int[] countOfPairs(int n, int x, int y) {
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            visited[i] = true;

            int step = 0;

            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {

                    int top = q.poll();
                    if (top > 0 && !visited[top - 1]) {
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
            }

        }

        return result;
    }

    @Test
    public void test1() {
        assertArrayEquals(new int[] { 6, 0, 0 }, countOfPairs(3, 1, 3));
    }
}
