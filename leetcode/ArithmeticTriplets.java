package leetcode;

public class ArithmeticTriplets {

    // https://leetcode.com/problems/number-of-arithmetic-triplets/

    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;

        boolean[] N = new boolean[201];
        for (int i = 0; i < nums.length; i++) {
            N[nums[i]] = true;
        }

        for (int i = 0; i < nums.length - 2; i++) {
            if ((nums[i] + diff < N.length && N[nums[i] + diff])
                    && (nums[i] + 2 * diff < N.length && N[nums[i] + 2 * diff])) {
                count++;
            }
        }
        return count;
    }
}
