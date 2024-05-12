package leetcode;

import static org.junit.Assert.assertArrayEquals;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.junit.Test;

public class FindRelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        String[] result = new String[score.length];

        String[] desc = new String[] { "Gold Medal", "Silver Medal", "Bronze Medal" };
        int[][] arr = new int[score.length][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[] { score[i], i };
        }

        Arrays.sort(arr, (a, b) -> {
            return b[0] - a[0];
        });

        for (int i = 0; i < arr.length; i++) {
            result[arr[i][1]] = i < 3 ? desc[i] : String.valueOf(i + 1);
        }

        return result;
    }

    @Test
    public void test1() {
        assertArrayEquals(new String[] { "Gold Medal", "Silver Medal", "Bronze Medal", "4", "5" },
                findRelativeRanks(new int[] { 5, 4, 3, 2, 1 }));
    }
}
