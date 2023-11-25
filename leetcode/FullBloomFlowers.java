package leetcode;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class FullBloomFlowers {

    // https://leetcode.com/problems/number-of-flowers-in-full-bloom/

    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int[] answer = new int[persons.length];

        for (int i = 0; i < persons.length; i++) {
            for (int j = 0; j < flowers.length; j++) {
                if (flowers[j][0] <= persons[i] && persons[i] <= flowers[j][1])
                    answer[i]++;
            }
        }

        return answer;
    }

    @Test
    public void test1() {
        int[][] flowers = new int[][] { { 1, 6 }, { 3, 7 }, { 9, 12 }, { 4, 13 } };
        int[] persons = new int[] { 2, 3, 7, 11 };
        int[] expecteds = new int[] { 1, 2, 2, 2 };
        int[] actuals = fullBloomFlowers(flowers, persons);
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void test2() {
        int[][] flowers = new int[][] { { 1, 10 }, { 3, 3 } };
        int[] persons = new int[] { 3, 3, 2 };
        int[] expecteds = new int[] { 2, 2, 1 };
        int[] actuals = fullBloomFlowers(flowers, persons);
        assertArrayEquals(expecteds, actuals);
    }
}
