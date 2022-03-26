package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class NumRescueBoats {

    // https://leetcode.com/problems/boats-to-save-people/

    public int numRescueBoats(int[] people, int limit) {
        int count = 0;

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (people[left] + people[right] <= limit && left != right) {
                left++;
                right--;
            } else {
                right--;
            }
            count++;
        }

        return count;
    }

    @Test
    public void test1() {
        int[] people = new int[] { 1, 2 };
        int limit = 3;
        int expected = 1;
        int actual = numRescueBoats(people, limit);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] people = new int[] { 3, 2, 2, 1 };
        int limit = 3;
        int expected = 3;
        int actual = numRescueBoats(people, limit);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] people = new int[] { 3, 5, 3, 4 };
        int limit = 5;
        int expected = 4;
        int actual = numRescueBoats(people, limit);
        assertEquals(expected, actual);
    }
}
