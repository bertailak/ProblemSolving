package task;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

public class Intersection {

    public int intersection(int[] a, int[] b) {
        HashSet<Integer> set = new HashSet<>();

        int[][] arr = new int[a.length][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[] { a[i], b[i] };
        }

        Arrays.sort(arr, (x, y) -> {
            return x[0] - y[0];
        });

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i][1] >= arr[j][1]) {
                    set.add(i);
                    set.add(j);
                }
            }
        }

        return a.length - set.size();
    }

    @Test
    public void test1() {
        assertEquals(1, intersection(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 5, 1, 5, 6 }));
    }

    @Test
    public void test2() {
        assertEquals(1, intersection(new int[] { 2, 3, 4, 6, 9 }, new int[] { 6, 9, 2, 9, 10 }));
    }

}
