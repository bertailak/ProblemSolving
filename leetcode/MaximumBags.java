package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class MaximumBags {

    // https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int count = 0;

        int[] remind = new int[capacity.length];

        for (int i = 0; i < remind.length; i++) {
            remind[i] = capacity[i] - rocks[i];

            if (capacity[i] == rocks[i]) {
                count++;
            }
        }

        Arrays.sort(remind);

        int index = 0;
        while (additionalRocks > 0 && index < remind.length) {
            if (remind[index] == 0) {
                index++;
                continue;
            }
            if (additionalRocks >= remind[index]) {
                additionalRocks -= remind[index];
                count++;
                index++;
            } else {
                additionalRocks = 0;
            }
        }

        return count;
    }

    @Test
    public void test1() {
        int[] capacity = new int[] { 2, 3, 4, 5 };
        int[] rocks = new int[] { 1, 2, 4, 4 };
        int additionalRocks = 2;
        int expected = 3;
        int actual = maximumBags(capacity, rocks, additionalRocks);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] capacity = new int[] { 10, 2, 2 };
        int[] rocks = new int[] { 2, 2, 0 };
        int additionalRocks = 100;
        int expected = 3;
        int actual = maximumBags(capacity, rocks, additionalRocks);
        assertEquals(expected, actual);
    }
}
