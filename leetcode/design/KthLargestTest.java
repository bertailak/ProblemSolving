package leetcode.design;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KthLargestTest {

    @Test
    public void test1() {
        int k = 3;
        int[] nums = new int[] { 4, 5, 8, 2 };
        KthLargest cl = new KthLargest(k, nums);
        int actual = cl.add(3);
        assertEquals(4, actual);
    }
}
