package leetcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Insert {

    // https://leetcode.com/problems/insert-interval/

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> newList = new ArrayList<>();
        newList.add(newInterval[0]);
        newList.add(newInterval[1]);
        list.add(newList);

        for (int i = 0; i < intervals.length; i++) {

            int last = list.size() - 1;

            if (intervals[i][1] < list.get(last).get(0)) {
                List<Integer> inter = new ArrayList<>();
                inter.add(intervals[i][0]);
                inter.add(intervals[i][1]);
                list.add(last, inter);
            } else if (intervals[i][0] <= list.get(last).get(1)) {
                list.get(last).set(0, Math.min(list.get(last).get(0), intervals[i][0]));
                list.get(last).set(1, Math.max(list.get(last).get(1), intervals[i][1]));
            } else {
                List<Integer> inter = new ArrayList<>();
                inter.add(intervals[i][0]);
                inter.add(intervals[i][1]);
                list.add(inter);
            }
        }

        int[][] result = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i).get(0);
            result[i][1] = list.get(i).get(1);
        }

        return result;
    }

    @Test
    public void test1() {
        int[][] intervals = new int[][] { { 1, 3 }, { 6, 9 } };
        int[] newInterval = new int[] { 2, 5 };
        int[][] expecteds = new int[][] { { 1, 5 }, { 6, 9 } };
        int[][] actuals = insert(intervals, newInterval);
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void test2() {
        int[][] intervals = new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval = new int[] { 4, 8 };
        int[][] expecteds = new int[][] { { 1, 2 }, { 3, 10 }, { 12, 16 } };
        int[][] actuals = insert(intervals, newInterval);
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void test3() {
        int[][] intervals = new int[][] { };
        int[] newInterval = new int[] { 5, 7 };
        int[][] expecteds = new int[][] { { 5, 7 } };
        int[][] actuals = insert(intervals, newInterval);
        assertArrayEquals(expecteds, actuals);
    }
}
