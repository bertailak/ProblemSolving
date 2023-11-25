package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CountSmaller {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();

        List<Integer> sorted = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int index = binsearch(sorted, nums[i]);
            sorted.add(index, nums[i]);
            result.add(0, index);
        }

        return result;
    }

    public int binsearch(List<Integer> sorted, int target) {
        int index = 0;

        int left = 0;
        int right = sorted.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sorted.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index;
    }

    @Test
    public void test1() {
        int[] nums = new int[] { 2, 1 };
        List<Integer> expected = List.of(1, 0);
        List<Integer> actual = countSmaller(nums);
        assertEquals(expected, actual);
    }
}