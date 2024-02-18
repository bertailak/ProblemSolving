package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CountBeautifulPairs {
    public int countBeautifulPairs(int[] nums) {
        int count = 0;

        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            end.add(nums[i] % 10);
            while (nums[i] > 9) {
                nums[i] /= 10;
            }
            start.add(nums[i]);
        }

        for (int i = 0; i < start.size() - 1; i++) {
            for (int j = i + 1; j < end.size(); j++) {
                if (gcd(start.get(i), end.get(j)) == 1)
                    count++;
            }
        }

        return count;
    }

    private int gcd(int a, int b) {
        if (b > a)
            return gcd(b, a);
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    @Test
    public void test1() {
        assertEquals(5, countBeautifulPairs(new int[] { 2, 5, 1, 4 }));
        assertEquals(2, countBeautifulPairs(new int[] { 11, 21, 12 }));
    }

    @Test
    public void test2() {
        assertEquals(7, countBeautifulPairs(new int[] { 31, 25, 72, 79, 74 }));
    }
}
