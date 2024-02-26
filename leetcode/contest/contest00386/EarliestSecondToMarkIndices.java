package leetcode.contest.contest00386;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

public class EarliestSecondToMarkIndices {

    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int left = 0;
        int right = changeIndices.length + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (binarySearch(nums, changeIndices, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right == changeIndices.length + 1 ? -1 : right;

    }

    private boolean binarySearch(int[] nums, int[] changeIndices, int mid) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mid; i++) {
            map.put(changeIndices[i], i);
        }

        if (map.size() < nums.length)
            return false;

        int count = 0;

        for (int i = 0; i < mid; i++) {
            if (map.get(changeIndices[i]) == i) {
                count -= nums[changeIndices[i] - 1];
                if (count < 0)
                    return false;
            } else {
                count++;
            }
        }

        return true;
    }

    @Test
    public void test1() {
        assertEquals(8, earliestSecondToMarkIndices(new int[] { 2, 2, 0 }, new int[] { 2, 2, 2, 2, 3, 2, 2, 1 }));
    }

    @Test
    public void test2() {
        assertEquals(6, earliestSecondToMarkIndices(new int[] { 1, 3 }, new int[] { 1, 1, 1, 2, 1, 1, 1 }));
    }

    @Test
    public void test3() {
        assertEquals(-1, earliestSecondToMarkIndices(new int[] { 0, 1 }, new int[] { 2, 2, 2 }));
    }

    @Test
    public void test4() {
        assertEquals(-1, earliestSecondToMarkIndices(new int[] { 0, 1 }, new int[] { 2, 2, 2 }));
    }
}
