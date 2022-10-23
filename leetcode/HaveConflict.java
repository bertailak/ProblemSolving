package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HaveConflict {

    // https://leetcode.com/problems/determine-if-two-events-have-conflict/

    public boolean haveConflict(String[] event1, String[] event2) {

        String[] ev11 = event1[0].split(":");
        String[] ev12 = event1[1].split(":");
        String[] ev21 = event2[0].split(":");
        String[] ev22 = event2[1].split(":");

        int firstStart = Integer.parseInt(ev11[0]) * 60 + Integer.parseInt(ev11[1]);
        int firstEnd = Integer.parseInt(ev12[0]) * 60 + Integer.parseInt(ev12[1]);
        int secondStart = Integer.parseInt(ev21[0]) * 60 + Integer.parseInt(ev21[1]);
        int secondEnd = Integer.parseInt(ev22[0]) * 60 + Integer.parseInt(ev22[1]);

        if ((firstStart <= secondStart && secondStart <= firstEnd)
                || (secondStart <= firstEnd && firstEnd <= secondEnd)
                || (secondStart <= firstStart && firstStart <= secondEnd)
                || (firstStart <= secondEnd && secondEnd <= firstEnd))
            return true;

        return false;
    }

    @Test
    public void test1() {
        assertEquals(true, haveConflict(new String[] { "01:15", "02:00" }, new String[] { "02:00", "03:00" }));
    }

    @Test
    public void test2() {
        assertEquals(true, haveConflict(new String[] { "01:00", "02:00" }, new String[] { "01:20", "03:00" }));
    }

    @Test
    public void test3() {
        assertEquals(false, haveConflict(new String[] { "10:00", "11:00" }, new String[] { "14:00", "15:00" }));
    }

    @Test
    public void test4() {
        assertEquals(false, haveConflict(new String[] { "14:13", "22:08" }, new String[] { "02:40", "08:08" }));
    }

    @Test
    public void test5() {
        assertEquals(true, haveConflict(new String[] { "16:53", "19:00" }, new String[] { "10:33", "18:15" }));
    }
}
