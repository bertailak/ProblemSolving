package leetcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FindKDistantIndices {

    // https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> list = new ArrayList<>();
        List<Integer> keys = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key)
                keys.add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < keys.size(); j++) {
                if (Math.abs(i - keys.get(j)) <= k) {
                    list.add(i);
                    break;
                }
            }
        }

        return list;
    }

    @Test
    public void test1() {
        int[] nums = new int[] { 3, 4, 9, 1, 3, 9, 5 };
        int key = 9;
        int k = 1;
        int[] expecteds = new int[] { 1, 2, 3, 4, 5, 6 };
        int[] actuals = findKDistantIndices(nums, key, k).stream().mapToInt(Integer::intValue).toArray();
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void test2() {
        int[] nums = new int[] { 2, 2, 2, 2, 2 };
        int key = 2;
        int k = 2;
        int[] expecteds = new int[] { 0, 1, 2, 3, 4 };
        int[] actuals = findKDistantIndices(nums, key, k).stream().mapToInt(Integer::intValue).toArray();
        assertArrayEquals(expecteds, actuals);
    }
}
