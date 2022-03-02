package leetcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Merge {

    // https://leetcode.com/problems/merge-intervals/

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int last = list.size() - 1;
            if (intervals[i][0] <= list.get(last)[1]) {
                list.get(last)[0] = Math.min(list.get(last)[0], intervals[i][0]);
                list.get(last)[1] = Math.max(list.get(last)[1], intervals[i][1]);
            } else {
                list.add(intervals[i]);
            }
        }

        return list.toArray(new int[list.size()][2]);
    }

    @Test
    public void test1() {
        int[][] intervals = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] expecteds = new int[][] { { 1, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] actuals = merge(intervals);
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void test2() {
        int[][] intervals = new int[][] { { 1, 4 }, { 4, 5 } };
        int[][] expecteds = new int[][] { { 1, 5 } };
        int[][] actuals = merge(intervals);
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void test3() {
        int[][] intervals = new int[][] { { 1, 4 }, { 0, 0 } };
        int[][] expecteds = new int[][] { { 0, 0 }, { 1, 4 } };
        int[][] actuals = merge(intervals);
        assertArrayEquals(expecteds, actuals);
    }

}
