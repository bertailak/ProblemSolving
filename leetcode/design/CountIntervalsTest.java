package leetcode.design;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountIntervalsTest {

    @Test
    public void test1() {
        CountIntervals c = new CountIntervals();
        c.add(2, 3);
        c.add(7, 10);
        assertEquals(6, c.count());
        c.add(5, 8);
        assertEquals(8, c.count());
    }
}
