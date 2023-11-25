package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ContinuousSubarrays {
    public long continuousSubarrays(int[] nums) {
        long count = 0;

        for (int i = 0; i < nums.length; i++) {
            int max = nums[i];
            int min = nums[i];
            int j = i;

            while (j < nums.length) {

                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);

                if (max - min > 2)
                    break;

                count++;
                j++;

            }
        }

        return count;
    }

    @Test
    public void test1() {
        assertEquals(8, continuousSubarrays(new int[] { 5, 4, 2, 4 }));
        assertEquals(6, continuousSubarrays(new int[] { 1, 2, 3 }));
    }
}
