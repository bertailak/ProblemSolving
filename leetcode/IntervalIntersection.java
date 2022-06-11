package leetcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class IntervalIntersection {

    // https://leetcode.com/problems/interval-list-intersections/

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();

        int n = 0;
        int m = 0;

        while (n < firstList.length && m < secondList.length) {
            int[] first = firstList[n];
            int[] second = secondList[m];

            if (first[1] < second[0]) {
                n++;
            } else if (first[0] > second[1]) {
                m++;
            } else {
                int left = Math.max(first[0], second[0]);
                int right = Math.min(first[1], second[1]);

                list.add(new int[] { left, right });

                if (first[1] < second[1]) {
                    n++;
                } else {
                    m++;
                }
            }

        }

        return list.toArray(new int[list.size()][2]);
    }

    @Test
    public void test1() {
        int[][] firstList = new int[][] { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
        int[][] secondList = new int[][] { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };
        int[][] expecteds = new int[][] { { 1, 2 }, { 5, 5 }, { 8, 10 }, { 15, 23 }, { 24, 24 }, { 25, 25 } };
        int[][] actuals = intervalIntersection(firstList, secondList);
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void test2() {
        int[][] firstList = new int[][] { { 1, 3 }, { 5, 9 } };
        int[][] secondList = new int[][] {};
        int[][] expecteds = new int[][] {};
        int[][] actuals = intervalIntersection(firstList, secondList);
        assertArrayEquals(expecteds, actuals);
    }
}
