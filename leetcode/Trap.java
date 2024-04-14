package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Trap {
    public int trap(int[] height) {
        int sum = 0;
        int left = 0;
        int right = 0;

        while (right < height.length) {

            while (right < height.length && height[left] > height[right]) {
                right++;
            }

            if (right < height.length) {

                int min = Math.min(height[left], height[right]);

                for (int i = left; i < right; i++) {
                    if (height[i] < min) {
                        sum += min - height[i];
                    }
                }
            }

            left = right;

            right++;
        }

        return sum;
    }

    @Test
    public void test1() {
        assertEquals(6, trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
    }

    @Test
    public void test2() {
        assertEquals(9, trap(new int[] { 4, 2, 0, 3, 2, 5 }));
    }
}
