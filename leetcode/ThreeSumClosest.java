package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class ThreeSumClosest {

    // https://leetcode.com/problems/3sum-closest/

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target)
                    return sum;
                if (Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                }
                if (sum > target) {
                    --k;
                } else {
                    ++j;
                }
            }
        }

        return closest;
    }

    @Test
    public void test1() {
        assertEquals(2, threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));
    }

    @Test
    public void test2() {
        assertEquals(0, threeSumClosest(new int[] { 0, 0, 0 }, 1));
    }
}
