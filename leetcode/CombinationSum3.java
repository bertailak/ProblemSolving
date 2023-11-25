package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CombinationSum3 {

    // https://leetcode.com/problems/combination-sum-iii/

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list, new ArrayList<>(), k, n, 0, 0);
        return list;
    }

    public void helper(List<List<Integer>> list, List<Integer> combination, int k, int n, int sum, int index) {

        if (combination.size() == k - 1) {

            if (n - sum > combination.get(k - 2)) {
                combination.add(n - sum);
                list.add(new ArrayList<>(combination));
                combination.remove(k - 1);
            }
            return;
        }

        for (int i = index + 1; i <= 9 - k + combination.size() + 1; i++) {
            combination.add(i);
            helper(list, combination, k, n, sum + i, i);
            combination.remove(combination.size() - 1);
        }

    }

    @Test
    public void test1() {
        int k = 3;
        int n = 7;
        List<List<Integer>> expected = List.of(List.of(1, 2, 4));
        List<List<Integer>> actual = combinationSum3(k, n);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int k = 3;
        int n = 9;
        List<List<Integer>> expected = List.of(List.of(1, 2, 6), List.of(1, 3, 5), List.of(2, 3, 4));
        List<List<Integer>> actual = combinationSum3(k, n);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int k = 9;
        int n = 45;
        List<List<Integer>> expected = List.of(
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<List<Integer>> actual = combinationSum3(k, n);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int k = 2;
        int n = 18;
        List<List<Integer>> expected = List.of(
                List.of(1, 17),
                List.of(2, 16),
                List.of(3, 15),
                List.of(4, 14),
                List.of(5, 13),
                List.of(6, 12),
                List.of(7, 11),
                List.of(8, 10));

        List<List<Integer>> actual = combinationSum3(k, n);
        assertEquals(expected, actual);
    }
}
