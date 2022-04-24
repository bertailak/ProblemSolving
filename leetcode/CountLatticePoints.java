package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.List;

import org.junit.Test;

public class CountLatticePoints {

    // https://leetcode.com/problems/count-lattice-points-inside-a-circle/

    public int countLatticePoints(int[][] circles) {
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < circles.length; i++) {

            for (int j = circles[i][0] - circles[i][2]; j <= circles[i][0] + circles[i][2]; j++) {
                for (int k = circles[i][1] - circles[i][2]; k <= circles[i][1] + circles[i][2]; k++) {
                    double radius = Math.sqrt(Math.pow(circles[i][0] - j, 2) + Math.pow(circles[i][1] - k, 2));
                    if (radius <= circles[i][2])
                        set.add(List.of(j, k));
                }
            }

        }

        return set.size();
    }

    @Test
    public void test1() {
        int[][] circles = new int[][] { { 2, 2, 1 } };
        int expected = 5;
        int actual = countLatticePoints(circles);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[][] circles = new int[][] { { 2, 2, 2 }, { 3, 4, 1 } };
        int expected = 16;
        int actual = countLatticePoints(circles);
        assertEquals(expected, actual);
    }

}
