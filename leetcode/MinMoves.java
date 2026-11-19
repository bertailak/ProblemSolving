package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinMoves {

    int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    int maxEnergy;

    public int minMoves(String[] classroom, int energy) {
        int countL = 0;
        int x = 0;
        int y = 0;
        maxEnergy = energy;

        for (int i = 0; i < classroom.length; i++) {
            for (int j = 0; j < classroom[i].length(); j++) {
                if (classroom[i].charAt(j) == 'L') {
                    countL++;
                } else if (classroom[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                }
            }
        }
        if (countL == 0)
            return 0;

        boolean[][] visited = new boolean[classroom.length][classroom[0].length()];
        visited[x][y] = true;
        int res = bfs(x, y, classroom, 1, countL, visited, 0);
        if (res == Integer.MAX_VALUE)
            return -1;
        return res;
    }

    private int bfs(int x, int y, String[] classroom, int energy, int count, boolean[][] visited, int step) {
        int min = Integer.MAX_VALUE;

        if (classroom[x].charAt(y) == 'R')
            energy = 0;
        if (classroom[x].charAt(y) == 'L')
            count--;
        if (count == 0)
            return step;

        for (int i = 0; i < dirs.length; i++) {
            int dx = x + dirs[i][0];
            int dy = y + dirs[i][1];
            if (dx < 0 || dx >= classroom.length
                    || dy < 0 || dy >= classroom[0].length()
                    || visited[dx][dy] == true
                    || classroom[dx].charAt(dy) == 'X'
                    || energy >= maxEnergy)
                continue;
            visited[dx][dy] = true;
            min = Math.min(min, bfs(dx, dy, classroom, energy + 1, count, visited, step + 1));
            visited[dx][dy] = false;
        }
        return min;
    }

    @Test
    public void test1() {
        assertEquals(minMoves(new String[] { "S.", "XL" }, 2), 2);
    }

    @Test
    public void test2() {
        assertEquals(minMoves(new String[] { "LS", "RL" }, 4), 3);
    }

    @Test
    public void test3() {
        assertEquals(minMoves(new String[] { "L.S", "RXL" }, 3), -1);
    }

    @Test
    public void test4() {
        assertEquals(minMoves(new String[] { "SR" }, 1), 0);
    }

    @Test
    public void test5() {
        assertEquals(minMoves(new String[] { ".S", "LL" }, 3), 2);
    }

    @Test
    public void test6() {
        assertEquals(minMoves(new String[] { "SLL." }, 1), -1);
    }

    @Test
    public void test7() {
        assertEquals(minMoves(new String[] { "RL", "S." }, 1), 2);
    }

    @Test
    public void test8() {
        assertEquals(minMoves(new String[] { "LSX", "..R" }, 1), 1);
    }

    @Test
    public void test9() {
        assertEquals(minMoves(new String[] { "SLRX", "L.LR" }, 3), 5);
    }

    @Test
    public void test10() {
        assertEquals(minMoves(new String[] { "S..", "RXL", "LL." }, 3), -1);
    }
}