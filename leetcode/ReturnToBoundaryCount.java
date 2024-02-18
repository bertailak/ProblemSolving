package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReturnToBoundaryCount {
    public int returnToBoundaryCount(int[] nums) {
        int count = 0;
        int pos = 0;

        for (int i : nums) {
            pos += i;
            if (pos == 0)
                count++;
        }

        return count;
    }

    @Test
    public void test1() {
        assertEquals(1, returnToBoundaryCount(new int[] { 2, 3, -5 }));
        assertEquals(0, returnToBoundaryCount(new int[] { 3, 2, -3, -4 }));
    }
}
