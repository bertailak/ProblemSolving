package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DistinctAverages {

    // https://leetcode.com/problems/number-of-distinct-averages/

    public int distinctAverages(int[] nums) {
        Set<Double> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            set.add((1.0 * nums[i] + nums[nums.length - 1 - i]) / 2);
        }

        return set.size();
    }
}