package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Intersection {

    // https://leetcode.com/problems/intersection-of-multiple-arrays/

    public List<Integer> intersection(int[][] nums) {

        int[] arr = new int[1001];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                arr[nums[i][j]]++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == nums.length) {
                result.add(i);
            }
        }

        return result;
    }

    @Test
    public void test1() {
        int[][] nums = new int[][] { { 3, 1, 2, 4, 5 }, { 1, 2, 3, 4 }, { 3, 4, 5, 6 } };
        List<Integer> expected = List.of(3, 4);
        List<Integer> actual = intersection(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[][] nums = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };
        List<Integer> expected = List.of();
        List<Integer> actual = intersection(nums);
        assertEquals(expected, actual);
    }
}
