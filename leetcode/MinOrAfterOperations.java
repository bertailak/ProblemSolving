package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinOrAfterOperations {

    public int minOrAfterOperations(int[] nums, int k) {
        int min = 0;
        if (k == 0) {
            for (int num : nums) {
                if (num < 0)
                    continue;
                min |= num;
            }

            return min;
        }

        min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 1; i++) {

            int index = i + 1;
            while (index < nums.length && nums[index] == -1) {
                index++;
            }
            if (index == nums.length)
                break;

            int num1 = nums[i];
            int num2 = nums[index];

            nums[i] = num1 & num2;
            nums[index] = -1;

            int curr = minOrAfterOperations(nums, k - 1);
            min = Math.min(min, curr);

            nums[i] = num1;
            nums[index] = num2;
        }

        return min;
    }

    @Test
    public void test1() {
        assertEquals(3, minOrAfterOperations(new int[] { 3, 5, 3, 2, 7 }, 2));
    }

    @Test
    public void test2() {
        assertEquals(2, minOrAfterOperations(new int[] { 7, 3, 15, 14, 2, 8 }, 4));
    }

    @Test
    public void test3() {
        assertEquals(15, minOrAfterOperations(new int[] { 10, 7, 10, 3, 9, 14, 9, 4 }, 1));
    }

    @Test
    public void test4() {
        assertEquals(0, minOrAfterOperations(new int[] { 21, 52, 50, 20, 22, 7, 23, 16, 15, 62 }, 9));
    }
}
