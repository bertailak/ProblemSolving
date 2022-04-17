package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

public class MinimumRounds {

    // https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/

    public int minimumRounds(int[] tasks) {

        int round = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) == 1)
                return -1;
            round += map.get(key) / 3 + (map.get(key) % 3 > 0 ? 1 : 0);
        }

        return round;
    }

    @Test
    public void test1() {
        int[] tasks = new int[] { 2, 2, 3, 3, 2, 4, 4, 4, 4, 4 };
        int expected = 4;
        int actual = minimumRounds(tasks);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] tasks = new int[] { 2, 3, 3 };
        int expected = -1;
        int actual = minimumRounds(tasks);
        assertEquals(expected, actual);
    }
}
