package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountQuadruplets {
    public long countQuadruplets(int[] nums) {
        long count = 0;

        for (int i = 0; i < nums.length - 3; i++) {

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (nums[i] > nums[j])
                    continue;

                for (int k = j + 1; k < nums.length - 1; k++) {
                    if (nums[k] > nums[j] || nums[i] > nums[k])
                        continue;

                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[k] > nums[l] || nums[j] > nums[l])
                            continue;
                        count++;
                    }

                }

            }
        }

        return count;
    }

    @Test
    public void test1() {
        assertEquals(2, countQuadruplets(new int[] { 1, 3, 2, 4, 5 }));
    }

    @Test
    public void test2() {
        assertEquals(0, countQuadruplets(new int[] { 1, 2, 3, 4 }));
    }
}
