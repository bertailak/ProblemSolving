package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FindMaxLength {

    public int findMaxLength(int[] nums) {
        int max = 0;

        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int diff = prefix[right] - (left == 0 ? 0 : prefix[left - 1]);
            int len = right - left + 1;
            if (len / 2 == diff) {
                max = diff * 2;
                break;
            } else if (len / 2 < diff) {
                if (nums[left] == 1) {
                    left++;
                } else if (nums[right] == 1) {
                    right--;
                }
            } else {
                if (nums[left] == 0) {
                    left++;
                } else if (nums[right] == 0) {
                    right--;
                }
            }

        }

        return max;
    }

    @Test
    public void test1() {
        assertEquals(2, findMaxLength(new int[] { 0, 1 }));
    }

    @Test
    public void test2() {
        assertEquals(2, findMaxLength(new int[] { 0, 1, 0 }));
    }

    @Test
    public void test3() {
        assertEquals(2, findMaxLength(new int[] { 0, 1, 1 }));
    }

    @Test
    public void test4() {
        assertEquals(0, findMaxLength(new int[] { 1, 1, 1, 1, 1, 1, 1, 1 }));
    }

    @Test
    public void test5() {
        assertEquals(0, findMaxLength(new int[] { 1, 1 }));
    }

    @Test
    public void test6() {
        assertEquals(4, findMaxLength(new int[] { 0, 1, 1, 0, 1, 1, 1, 0 }));
    }
}
