package leetcode.design;

public class NumArray {

    // https://leetcode.com/problems/range-sum-query-immutable/

    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        for (int i = 1; i < nums.length; i++) {
            this.nums[i] += this.nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return left == 0 ? nums[right] : nums[right] - nums[left - 1];
    }
}
