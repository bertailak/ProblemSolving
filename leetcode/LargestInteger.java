package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LargestInteger {

    // https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/

    public int largestInteger(int num) {
        int[] nums = new int[10];
        List<Boolean> positions = new ArrayList<>();

        int num2 = num;
        while (num2 > 0) {
            int reminder = num2 % 10;
            positions.add(reminder % 2 == 0);
            nums[reminder]++;
            num2 /= 10;
        }

        int result = 0;
        for (int j = positions.size() - 1; j >= 0; j--) {
            int index = positions.get(j) ? 8 : 9;
            for (int i = index; i >= 0; i -= 2) {
                if (nums[i] > 0) {
                    nums[i]--;
                    result += i;
                    if (j > 0)
                        result *= 10;
                    break;
                }
            }
        }

        return result;
    }

    @Test
    public void test1() {
        int num = 1234;
        int expected = 3412;
        int actual = largestInteger(num);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int num = 65875;
        int expected = 87655;
        int actual = largestInteger(num);
        assertEquals(expected, actual);
    }
}
