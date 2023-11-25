package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinMaxDifference {

    public int minMaxDifference(int num) {
        char[] mins = String.valueOf(num).toCharArray();
        char[] maxes = String.valueOf(num).toCharArray();

        char min = mins[0];
        char max = mins[0];
        int k = 1;
        while (k < maxes.length && max == '9') {
            max = mins[k];
            k++;
        }

        for (int i = 0; i < maxes.length; i++) {
            if (mins[i] == min)
                mins[i] = '0';
            if (maxes[i] == max)
                maxes[i] = '9';
        }

        return Integer.parseInt(String.valueOf(maxes)) - Integer.parseInt(String.valueOf(mins));
    }

    @Test
    public void test1() {
        assertEquals(99009, minMaxDifference(11891));
        assertEquals(99, minMaxDifference(90));
    }
}
