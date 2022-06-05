package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class MinMaxGame {

    // https://leetcode.com/problems/min-max-game/

    public int minMaxGame(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length / 4 + 1; i++) {
            if (4 * i + 1 < nums.length) {
                queue.add(Math.min(nums[4 * i], nums[4 * i + 1]));
            }
            if (4 * i + 3 < nums.length) {
                queue.add(Math.max(nums[4 * i + 2], nums[4 * i + 3]));
            }
        }

        while (queue.size() > 1) {
            if (queue.size() >= 4) {
                int min1 = queue.poll();
                int min2 = queue.poll();
                queue.add(Math.min(min1, min2));
                int max1 = queue.poll();
                int max2 = queue.poll();
                queue.add(Math.max(max1, max2));
            } else {
                int min1 = queue.poll();
                int min2 = queue.poll();
                queue.add(Math.min(min1, min2));
            }
        }

        return queue.poll();
    }

    @Test
    public void test1() {
        int[] nums = new int[] { 1, 3, 5, 2, 4, 8, 2, 2 };
        int expected = 1;
        int actual = minMaxGame(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = new int[] { 3 };
        int expected = 3;
        int actual = minMaxGame(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] nums = new int[] { 93, 40 };
        int expected = 40;
        int actual = minMaxGame(nums);
        assertEquals(expected, actual);
    }
}
