package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permute {

    // https://leetcode.com/problems/permutations/
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list, new HashSet<>(), new ArrayList<>(), nums);
        return list;
    }

    public void helper(List<List<Integer>> list, Set<Integer> indexes, List<Integer> permutation, int[] nums) {
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
}
