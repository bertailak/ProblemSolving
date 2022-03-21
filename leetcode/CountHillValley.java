package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CountHillValley {

    // https://leetcode.com/problems/count-hills-and-valleys-in-an-array/

    public int countHillValley(int[] nums) {
        int count = 0;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (list.get(list.size() - 1) != nums[i])
                list.add(nums[i]);
        }

        for (int i = 1; i < list.size() - 1; i++) {
            if ((list.get(i - 1) < list.get(i) && list.get(i) > list.get(i + 1))
                    || (list.get(i - 1) > list.get(i) && list.get(i) < list.get(i + 1)))
                count++;
        }

        return count;
    }

    @Test
    public void test1() {
        int[] nums = new int[] { 2, 4, 1, 1, 6, 5 };
        int expected = 3;
        int actual = countHillValley(nums);
        assertEquals(expected, actual);

    }

    @Test
    public void test2() {
        int[] nums = new int[] { 6, 6, 5, 5, 4, 1 };
        int expected = 0;
        int actual = countHillValley(nums);
        assertEquals(expected, actual);

    }
}
