package leetcode.contest.contest00387;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ResultArray {

    public int[] resultArray(int[] nums) {
        int[] result = new int[nums.length];

        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        int ind = 0;
        arr1.add(nums[ind++]);
        arr2.add(nums[ind++]);

        while (ind < nums.length) {
            if (arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1)) {
                arr1.add(nums[ind++]);
            } else {
                arr2.add(nums[ind++]);
            }
        }
        for (int i = 0; i < arr1.size(); i++) {
            result[i] = arr1.get(i);
        }
        for (int i = 0; i < arr2.size(); i++) {
            result[arr1.size() + i] = arr2.get(i);
        }

        return result;
    }

    @Test
    public void test1() {
        assertArrayEquals(new int[] { 2, 3, 1 }, resultArray(new int[] { 2, 1, 3 }));
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[] { 5, 3, 4, 8 }, resultArray(new int[] { 5, 4, 3, 8 }));
    }

    @Test
    public void test3() {
        assertArrayEquals(new int[] { 1, 2, 4 }, resultArray(new int[] { 1, 2, 4 }));
    }
}
