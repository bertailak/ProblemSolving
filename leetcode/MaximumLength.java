package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

public class MaximumLength {

    public int maximumLength(int[] nums) {
        int max = 1;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {

            if (map.get(key) < 2 || key == 1)
                continue;

            int curr = 2;

            while (map.containsKey(key * key)) {
                if (map.get(key * key) > 1) {
                    key = key * key;
                    curr += 2;
                } else {
                    curr++;
                    break;
                }
            }

            if (curr % 2 == 0)
                curr--;

            max = Math.max(curr, max);

        }

        if (map.containsKey(1)) {
            int ones = map.get(1);
            if (ones % 2 == 0)
                ones--;
            max = Math.max(max, ones);
        }

        return max;
    }

    @Test
    public void test1() {
        assertEquals(3, maximumLength(new int[] { 5, 4, 1, 2, 2 }));
    }

    @Test
    public void test2() {
        assertEquals(1, maximumLength(new int[] { 1, 3, 2, 4 }));
    }

    @Test
    public void test3() {
        assertEquals(1, maximumLength(new int[] { 1, 1 }));
    }

    @Test
    public void test4() {
        assertEquals(3, maximumLength(new int[] { 1, 1, 1 }));
    }

    @Test
    public void test5() {
        assertEquals(3, maximumLength(new int[] { 1, 1, 1, 1 }));
    }

    @Test
    public void test6() {
        assertEquals(1, maximumLength(new int[] { 1, 16, 49, 16, 121 }));
    }
}
