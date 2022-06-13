package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MinimumTotal {

    // https://leetcode.com/problems/triangle/

    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < triangle.size() - 1; i++) {

            List<Integer> list = new ArrayList<>(i + 1);

            for (int j = 0; j <= i; j++) {
                list.add(Integer.MAX_VALUE);
            }

            result.add(list);
        }
        result.add(triangle.get(triangle.size() - 1));

        for (int i = triangle.size() - 1; i > 0; i--) {

            for (int j = 0; j < triangle.get(i).size(); j++) {

                if (j < triangle.get(i).size() - 1) {
                    result.get(i - 1).set(j,
                            Math.min(result.get(i - 1).get(j), result.get(i).get(j) + triangle.get(i - 1).get(j)));
                }
                if (j > 0) {
                    result.get(i - 1).set(j - 1,
                            Math.min(result.get(i - 1).get(j - 1),
                                    result.get(i).get(j) + triangle.get(i - 1).get(j - 1)));
                }
            }

        }

        return result.get(0).get(0);
    }

    @Test
    public void test0() {
        List<List<Integer>> triangle = List.of(List.of(1), List.of(3, 2));
        int expected = 3;
        int actual = minimumTotal(triangle);
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        List<List<Integer>> triangle = List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3));
        int expected = 11;
        int actual = minimumTotal(triangle);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        List<List<Integer>> triangle = List.of(List.of(-10));
        int expected = -10;
        int actual = minimumTotal(triangle);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        List<List<Integer>> triangle = List.of(List.of(-1), List.of(3, 2), List.of(-3, 1, -1));
        int expected = -1;
        int actual = minimumTotal(triangle);
        assertEquals(expected, actual);
    }
}