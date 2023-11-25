package leetcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class AnswerQueries {

    // https://leetcode.com/contest/weekly-contest-308/problems/longest-subsequence-with-limited-sum/

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);

        int[] result = new int[queries.length];

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
            System.out.println(nums[i - 1]);
        }
        System.out.println(nums[nums.length - 1]);

        for (int i = 0; i < queries.length; i++) {
            result[i] = binser(nums, queries[i]);
        }

        return result;
    }

    private int binser(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    @Test
    public void test1() {
        int[] nums = { 4, 5, 2, 1 };
        int[] queries = { 3, 10, 21 };
        int[] expecteds = { 2, 3, 4 };
        int[] actuals = answerQueries(nums, queries);
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void test2() {
        int[] nums = { 2, 3, 4, 5 };
        int[] queries = { 1 };
        int[] expecteds = { 0 };
        int[] actuals = answerQueries(nums, queries);
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void test3() {
        int[] nums = { 736411, 184882, 914641, 37925, 214915 };
        int[] queries = { 331244, 273144, 118983, 118252, 305688, 718089, 665450 };
        int[] expecteds = { 2, 2, 1, 1, 2, 3, 3 };
        int[] actuals = answerQueries(nums, queries);
        assertArrayEquals(expecteds, actuals);
    }
}
