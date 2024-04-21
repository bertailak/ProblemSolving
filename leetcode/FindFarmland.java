package leetcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

public class FindFarmland {

    public int[][] findFarmland(int[][] land) {
        boolean[][] visited = new boolean[land.length][land[0].length];
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (visited[i][j] || land[i][j] == 0)
                    continue;

                int maxi = i;
                int maxj = j;
                Queue<int[]> pq = new LinkedList<>();
                pq.add(new int[] { maxi, maxj });

                visited[maxi][maxj] = true;
                while (!pq.isEmpty()) {
                    int[] top = pq.poll();
                    if (top[0] < land.length - 1
                            && !visited[top[0] + 1][top[1]]
                            && land[top[0] + 1][top[1]] == 1) {
                        pq.add(new int[] { top[0] + 1, top[1] });
                        visited[top[0] + 1][top[1]] = true;
                    }
                    if (top[1] < land[0].length - 1
                            && !visited[top[0]][top[1] + 1]
                            && land[top[0]][top[1] + 1] == 1) {
                        pq.add(new int[] { top[0], top[1] + 1 });
                        visited[top[0]][top[1] + 1] = true;
                    }
                    maxi = Math.max(maxi, top[0]);
                    maxj = Math.max(maxj, top[1]);
                }

                list.add(new int[] { i, j, maxi, maxj });
            }
        }

        int[][] result = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    @Test
    public void test1() {
        assertArrayEquals(new int[][] { { 0, 0, 0, 0 }, { 1, 1, 2, 2 } },
                findFarmland(new int[][] { { 1, 0, 0 }, { 0, 1, 1 }, { 0, 1, 1 } }));
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[][] {}, findFarmland(new int[][] { { 0 } }));
    }

}
