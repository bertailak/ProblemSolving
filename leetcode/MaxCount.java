package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxCount {

    public int maxCount(int[] banned, int n, int maxSum) {
        int max = 0;

        boolean[] nums = new boolean[10001];
        for (int ban : banned) {
            nums[ban] = true;
        }

        int i = 1;
        while (maxSum > 0 && i <= n) {
            if (!nums[i] && maxSum - i >= 0) {
                maxSum -= i;
                max++;
            }
            i++;
        }

        return max;
    }

    @Test
    public void test1() {
        assertEquals(2, maxCount(new int[] { 1, 6, 5 }, 5, 6));
    }

    @Test
    public void test2() {
        assertEquals(0, maxCount(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 8, 1));
    }

    @Test
    public void test3() {
        assertEquals(7, maxCount(new int[] { 11 }, 7, 50));
    }
}
