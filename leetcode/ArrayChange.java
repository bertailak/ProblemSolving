package leetcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.HashMap;

import org.junit.Test;

public class ArrayChange {

    // https://leetcode.com/problems/replace-elements-in-an-array/

    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> indexes = new HashMap<>();
        HashMap<Integer, Integer> values = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            indexes.put(i, nums[i]);
            values.put(nums[i], i);
        }

        for (int i = 0; i < operations.length; i++) {
            int index = values.get(operations[i][0]);
            indexes.put(index, operations[i][1]);
            values.remove(operations[i][0]);
            values.put(operations[i][1], index);
        }

        int[] result = new int[indexes.size()];
        for (int i : indexes.keySet()) {
            result[i] = indexes.get(i);
        }
        return result;
    }

    @Test
    public void test1() {
        int[] nums = new int[] { 1, 2, 4, 6 };
        int[][] operations = new int[][] { { 1, 3 }, { 4, 7 }, { 6, 1 } };
        int[] expecteds = new int[] { 3, 2, 7, 1 };
        int[] actuals = arrayChange(nums, operations);
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void test2() {
        int[] nums = new int[] { 1, 2 };
        int[][] operations = new int[][] { { 1, 3 }, { 2, 1 }, { 3, 2 } };
        int[] expecteds = new int[] { 2, 1 };
        int[] actuals = arrayChange(nums, operations);
        assertArrayEquals(expecteds, actuals);
    }
}
