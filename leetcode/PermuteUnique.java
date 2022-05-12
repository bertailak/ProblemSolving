package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class PermuteUnique {

    // https://leetcode.com/problems/permutations-ii/

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> sets = new HashSet<>();
        helper(sets, new HashSet<>(), new ArrayList<>(), nums);
        List<List<Integer>> list = new ArrayList<>(sets);
        return list;
    }

    public void helper(Set<List<Integer>> list, Set<Integer> indexes, List<Integer> permutation, int[] nums) {
        if (permutation.size() == nums.length) {
            list.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!indexes.contains(i)) {
                indexes.add(i);
                permutation.add(nums[i]);
                helper(list, indexes, permutation, nums);
                permutation.remove(permutation.size() - 1);
                indexes.remove(i);
            }
        }
    }

    @Test
    public void test1() {
        int[] nums = new int[] { 1, 1, 2 };
        List<List<Integer>> expected = List.of(List.of(1, 1, 2), List.of(1, 2, 1), List.of(2, 1, 1));
        List<List<Integer>> actual = permuteUnique(nums);   //return any order
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = new int[] { 1, 2, 3 };
        List<List<Integer>> expected = List.of(
                List.of(1, 2, 3),
                List.of(1, 3, 2),
                List.of(2, 1, 3),
                List.of(2, 3, 1),
                List.of(3, 1, 2),
                List.of(3, 2, 1));
        List<List<Integer>> actual = permuteUnique(nums);   //return any order
        assertEquals(expected, actual);
    }

}