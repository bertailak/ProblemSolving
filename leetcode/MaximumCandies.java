package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaximumCandies {

    // https://leetcode.com/problems/maximum-candies-allocated-to-k-children/

    public int maximumCandies(int[] candies, long k) {
        int left = 0;

        int right = candies[0];
        for (int i = 1; i < candies.length; i++) {
            right = Math.max(right, candies[i]);
        }

        while (left < right) {
            int mid = left + 1 + (right - left) / 2;
            if (mid == 0) {
                left = mid;
                break;
            }
            int childs = 0;
            for (int i = 0; i < candies.length; i++) {
                childs += candies[i] / mid;
            }
            if (childs == k) {
                left = mid;
                break;
            } else if (childs < k) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return right;
    }

    @Test
    public void test1() {
        int[] candies = new int[] { 5, 8, 6 };
        long k = 3;
        int expected = 5;
        int actual = maximumCandies(candies, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] candies = new int[] { 2, 5 };
        long k = 11;
        int expected = 0;
        int actual = maximumCandies(candies, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] candies = new int[] { 4, 5, 7 };
        long k = 4;
        int expected = 3;
        int actual = maximumCandies(candies, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[] candies = new int[] { 1, 2, 3, 4, 10 };
        long k = 5;
        int expected = 3;
        int actual = maximumCandies(candies, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        int[] candies = new int[] { 5, 6, 4, 10, 10, 1, 1, 2, 2, 2 };
        long k = 9;
        int expected = 3;
        int actual = maximumCandies(candies, k);
        assertEquals(expected, actual);
    }

}
