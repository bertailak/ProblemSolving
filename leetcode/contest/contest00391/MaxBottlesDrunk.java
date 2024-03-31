package leetcode.contest.contest00391;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxBottlesDrunk {

    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int total = 0;
        int emptyBottles = 0;

        while (numBottles > 0 || emptyBottles > 0) {
            if (numBottles == 0 || emptyBottles >= numExchange) {
                if (emptyBottles >= numExchange)
                    numBottles++;
                emptyBottles -= numExchange;
                numExchange++;
            } else {
                total += numBottles;
                emptyBottles += numBottles;
                numBottles = 0;
            }
        }

        return total;
    }

    @Test
    public void test1() {
        assertEquals(15, maxBottlesDrunk(13, 6));
    }

    @Test
    public void test2() {
        assertEquals(13, maxBottlesDrunk(10, 3));
    }
}
