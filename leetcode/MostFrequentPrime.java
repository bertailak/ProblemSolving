package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;

public class MostFrequentPrime {

    public int mostFrequentPrime(int[][] mat) {

        int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 },
                { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {

                for (int k = 0; k < dirs.length; k++) {
                    int dx = i;
                    int dy = j;
                    int curr = 0;
                    while (dx >= 0 && dx < mat.length && dy >= 0 && dy < mat[0].length) {

                        curr = curr * 10 + mat[dx][dy];
                        dx = dx + dirs[k][0];
                        dy = dy + dirs[k][1];

                        if (curr < 10)
                            continue;

                        map.put(curr, map.getOrDefault(curr, 0) + 1);
                    }
                }

            }
        }

        int[][] arr = new int[map.size()][2];
        int ind = 0;
        for (int key : map.keySet()) {
            arr[ind++] = new int[] { key, map.get(key) };
        }

        Arrays.sort(arr, (a, b) -> {
            if (b[1] == a[1])
                return b[0] - a[0];
            return b[1] - a[1];
        });

        for (int i = 0; i < arr.length; i++) {
            if (isPrime(arr[i][0]))
                return arr[i][0];
        }

        return -1;
    }

    private boolean isPrime(int n) {
        if (n <= 1)
            return false;

        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    @Test
    public void test1() {
        assertEquals(19, mostFrequentPrime(new int[][] { { 1, 1 }, { 9, 9 }, { 1, 1 } }));
    }

    @Test
    public void test2() {
        assertEquals(-1, mostFrequentPrime(new int[][] { { 7 } }));
    }

    @Test
    public void test3() {
        assertEquals(97, mostFrequentPrime(new int[][] { { 9, 7, 8 }, { 4, 6, 5 }, { 2, 8, 6 } }));
    }
}
