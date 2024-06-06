package task;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import org.junit.Test;

public class ChessPair {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 0;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] - arr[i] > m)
                    break;
                if (arr[j] + arr[i] > k)
                    break;
                count++;
            }
        }

        System.out.println(count);

        sc.close();
    }

    public long chessPair(int n, int m, int k, int[] arr) {
        long count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int[][] arr2 = new int[map.size()][2];
        int index = 0;
        int max = 0;

        for (int key : map.keySet()) {
            max = Math.max(max, map.get(key));
            arr2[index++] = new int[] { key, map.get(key) };
        }

        long[] preSum = new long[max + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = i - 1 + preSum[i - 1];
        }

        Arrays.sort(arr2, (a, b) -> {
            return a[0] - b[0];
        });

        for (int i = 0; i < arr2.length; i++) {
            if (2 * arr2[i][0] <= k)
                count += preSum[arr2[i][1]];
            for (int j = i + 1; j < arr2.length; j++) {
                if (arr2[j][0] - arr2[i][0] > m)
                    break;
                if (arr2[j][0] + arr2[i][0] > k)
                    break;
                long mult = 1 * arr2[j][1];
                mult *= arr2[i][1];
                count += mult;
            }
        }

        return count;
    }

    @Test
    public void test1() {
        assertEquals(3, chessPair(4, 1, 5, new int[] { 1, 3, 2, 3 }));
    }

    @Test
    public void test2() {
        assertEquals(24, chessPair(9, 1, 5, new int[] { 1, 1, 2, 3, 2, 2, 1, 3, 3 }));
    }

    @Test
    public void test3() {
        assertEquals(24, chessPair(10, 4, 15, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
    }
}
