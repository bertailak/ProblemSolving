package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IsReachable {

    // https://leetcode.com/contest/biweekly-contest-96/problems/check-if-point-is-reachable/

    public boolean isReachable(int targetX, int targetY) {
        while (targetX > 0 && targetY > 0) {
            if (targetX == 1 && targetY == 1)
                return true;
            if (targetX >= targetY && targetX % 2 == 0) {
                targetX /= 2;
            } else if (targetY >= targetX && targetY % 2 == 0) {
                targetY /= 2;
            } else if (targetX >= targetY) {
                targetX -= targetY;
            } else if (targetY >= targetX) {
                targetY -= targetX;
            }
        }

        return false;
    }

    @Test
    public void test1() {
        assertEquals(false, isReachable(6, 9));
    }

    @Test
    public void test2() {
        assertEquals(true, isReachable(4, 7));
    }
}
