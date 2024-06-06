package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class BeautifulSubsets {

    public int beautifulSubsets(int[] nums, int k) {
        int count = 0;

        Arrays.sort(nums);

        int l = 0;
        int r = 0;

        while (r < nums.length) {

            while (l < r && nums[r] - k > nums[l]) {
                l++;
            }

            count += (r - l) + 1;

            r++;
        }

        return count;
    }

    @Test
    public void test1() {
        assertEquals(4, beautifulSubsets(new int[] { 2, 4, 6 }, 2));
    }
}
