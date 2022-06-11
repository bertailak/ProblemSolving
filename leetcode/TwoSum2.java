package leetcode;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class TwoSum2 {

    // https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                break;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] { left + 1, right + 1 };
    }

    @Test
    public void test1() {
        int[] numbers = new int[] { 2, 7, 11, 15 };
        int target = 9;
        int[] expected = new int[] { 1, 2 };
        int[] actual = twoSum(numbers, target);
        assertArrayEquals(expected, actual);
    }
}
