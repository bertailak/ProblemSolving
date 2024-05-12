package leetcode.contest.contest00395;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class MinimumAddedInteger {

    public int minimumAddedInteger(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums1.length - 1; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                boolean isSame = true;
                int diff = nums2[0] - nums1[0];
                if (i == 0)
                    diff = nums2[0] - nums1[1];
                if (i == 0 && j == 1)
                    diff = nums2[0] - nums1[2];
                int index = 0;
                for (int k = 0; k < nums2.length; k++) {
                    if (index == i)
                        index++;
                    if (index == j)
                        index++;
                    if (nums1[index] + diff != nums2[k]) {
                        isSame = false;
                        break;
                    }
                    index++;
                }
                if (isSame) {
                    min = Math.min(diff, min);
                }
            }
        }

        return min;
    }

    @Test
    public void test1() {
        assertEquals(-2, minimumAddedInteger(new int[] { 4, 20, 16, 12, 8 }, new int[] { 14, 18, 10 }));
    }

    @Test
    public void test2() {
        assertEquals(2, minimumAddedInteger(new int[] { 3, 5, 5, 3 }, new int[] { 7, 7 }));
    }

    @Test
    public void test3() {
        assertEquals(-2, minimumAddedInteger(new int[] { 4, 7, 5 }, new int[] { 5 }));
    }

    @Test
    public void test4() {
        assertEquals(0,
                minimumAddedInteger(
                        new int[] { 4, 6, 3, 1, 4, 2, 10, 9, 5 },
                        new int[] { 5, 10, 3, 2, 6, 1, 9 }));
    }
}
