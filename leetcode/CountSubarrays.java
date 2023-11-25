package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountSubarrays {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (minK <= nums[i] && nums[i] <= maxK) {
                count++;
                for (int j = i + 1; j < nums.length; j++) {
                    if (minK <= nums[j] && nums[j] <= maxK) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }

        return count;
    }

    @Test
    public void test1() {
        assertEquals(2, countSubarrays(new int[] { 1, 3, 5, 2, 7, 5 }, 1, 5));
    }
}
