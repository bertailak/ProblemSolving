package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ConvertTime {

    // https://leetcode.com/problems/minimum-number-of-operations-to-convert-time/

    public int convertTime(String current, String correct) {
        int count = 0;

        int currentTime = Integer.parseInt(current.split(":")[0]) * 60 + Integer.parseInt(current.split(":")[1]);
        int correctTime = Integer.parseInt(correct.split(":")[0]) * 60 + Integer.parseInt(correct.split(":")[1]);

        while (currentTime < correctTime) {
            if (currentTime + 60 <= correctTime) {
                currentTime += 60;
            } else if (currentTime + 15 <= correctTime) {
                currentTime += 15;
            } else if (currentTime + 5 <= correctTime) {
                currentTime += 5;
            } else if (currentTime + 1 <= correctTime) {
                currentTime += 1;
            }
            count++;
        }

        return count;
    }

    @Test
    public void test1() {
        String current = "02:30";
        String correct = "04:35";
        int expected = 3;
        int actual = convertTime(current, correct);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String current = "11:00";
        String correct = "11:01";
        int expected = 1;
        int actual = convertTime(current, correct);
        assertEquals(expected, actual);
    }
}
