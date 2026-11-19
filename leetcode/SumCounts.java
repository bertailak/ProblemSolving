package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class SumCounts {

    public int sumCounts(List<Integer> nums) {
        int count = 0;

        Collections.sort(nums);

        int distinct = 1;

        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) == nums.get(i + 1)) {
                continue;
            }
            distinct++;
        }

        count = (distinct * distinct);

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) != nums.get(i)) {
                distinct--;
            }
            count += distinct * distinct;
        }

        return count;
    }

    @Test
    public void test1() {
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(2);
        nums.add(1);
        assertEquals(15, sumCounts(nums));
    }
}
