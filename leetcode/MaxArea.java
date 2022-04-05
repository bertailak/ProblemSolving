package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxArea {

    // https://leetcode.com/problems/container-with-most-water/

    public int maxArea(int[] height) {
        int area = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {

            area = Math.max(area, Math.min(height[left], height[right]) * (right - left));

            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return area;
    }

    @Test
    public void test1() {
        int[] height = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int expected = 49;
        int actual = maxArea(height);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] height = new int[] { 1, 1 };
        int expected = 1;
        int actual = maxArea(height);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] height = new int[] { 2, 3, 4, 5, 18, 17, 6 };
        int expected = 17;
        int actual = maxArea(height);
        assertEquals(expected, actual);
    }
}
