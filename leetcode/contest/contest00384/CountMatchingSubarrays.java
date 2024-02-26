package leetcode.contest.contest00384;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountMatchingSubarrays {

    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int count = 0;

        for (int i = 0; i < nums.length - pattern.length; i++) {

            int index = 0;

while (index < pattern.length &&
        ((nums[i + index] < nums[i + index + 1]
                && pattern[index] == 1)
                || (nums[i + index] > nums[i + index + 1]
                        && pattern[index] == -1)
                || (nums[i + index] == nums[i + index + 1]
                        && pattern[index] == 0))) {

    index++;

    if (index == pattern.length)
        count++;
}

        }

        return count;
    }

    @Test
    public void test1() {
        assertEquals(4, countMatchingSubarrays(new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 1, 1 }));
    }

    @Test
    public void test2() {
        assertEquals(2, countMatchingSubarrays(new int[] { 1, 4, 4, 1, 3, 5, 5, 3 }, new int[] { 1, 0, -1 }));
    }

}
