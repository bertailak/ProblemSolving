package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DigArtifacts {

    // https://leetcode.com/problems/count-artifacts-that-can-be-extracted/

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][] grid = new boolean[n][n];
        int found = 0;
        for (int i = 0; i < dig.length; i++) {
            grid[dig[i][0]][dig[i][1]] = true;
        }

        for (int i = 0; i < artifacts.length; i++) {

            int count = 0;
            for (int j = artifacts[i][0]; j <= artifacts[i][2]; j++) {
                for (int k = artifacts[i][1]; k <= artifacts[i][3]; k++) {
                    if (grid[j][k])
                        count++;
                    else
                        break;
                }
            }
            if ((artifacts[i][2] - artifacts[i][0] + 1) * (artifacts[i][3] - artifacts[i][1] + 1) == count)
                found++;
        }

        return found;
    }

    @Test
    public void test1() {
        int n = 2;
        int[][] artifacts = new int[][] { { 0, 0, 0, 0 }, { 0, 1, 1, 1 } };
        int[][] dig = new int[][] { { 0, 0 }, { 0, 1 } };
        int expected = 1;
        int actual = digArtifacts(n, artifacts, dig);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int n = 2;
        int[][] artifacts = new int[][] { { 0, 0, 0, 0 }, { 0, 1, 1, 1 } };
        int[][] dig = new int[][] { { 0, 0 }, { 0, 1 }, { 1, 1 } };
        int expected = 2;
        int actual = digArtifacts(n, artifacts, dig);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int n = 5;
        int[][] artifacts = new int[][] { { 3, 1, 4, 1 }, { 1, 1, 2, 2 }, { 1, 0, 2, 0 }, { 4, 3, 4, 4 },
                { 0, 3, 1, 4 }, { 2, 3, 3, 4 } };
        int[][] dig = new int[][] { { 0, 0 }, { 2, 1 }, { 2, 0 }, { 2, 3 }, { 4, 3 }, { 2, 4 }, { 4, 1 }, { 0, 2 },
                { 4, 0 }, { 3, 1 }, { 1, 2 }, { 1, 3 }, { 3, 2 } };
        int expected = 1;
        int actual = digArtifacts(n, artifacts, dig);
        assertEquals(expected, actual);
    }

}
