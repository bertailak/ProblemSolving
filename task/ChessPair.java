package task;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
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

    public int chessPair(int n, int m, int k, int[] arr) {
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
