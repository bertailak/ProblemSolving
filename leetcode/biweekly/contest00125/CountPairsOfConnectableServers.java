package leetcode.biweekly.contest00125;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CountPairsOfConnectableServers {

    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int[] result = new int[edges.length + 1];
        boolean[] isVisited = new boolean[edges.length + 1];

        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            list.get(edges[i][0]).add(new int[] { edges[i][1], edges[i][2] });
            list.get(edges[i][1]).add(new int[] { edges[i][0], edges[i][2] });
        }

        for (int i = 0; i < list.size(); i++) {

            List<long[]> path = new ArrayList<>();
            path.add(new long[] { i, 0 });
            isVisited[i] = true;
            dfs(list, isVisited, result, path, 0, signalSpeed, i);
            isVisited[i] = false;

        }

        for (int i = 0; i < result.length; i++) {
            result[i] /= 2;
        }

        return result;
    }

    private void dfs(List<List<int[]>> list, boolean[] isVisited, int[] result, List<long[]> path, int sum,
            int signalSpeed,
            int start) {

        if (path.size() > 2 && sum % signalSpeed == 0) {
            for (int i = 1; i < path.size() - 1; i++) {
                if (path.get(i)[1] % signalSpeed == 0)
                    result[(int) path.get(i)[0]]++;
            }
        }

        for (int i = 0; i < list.get(start).size(); i++) {
            int target = list.get(start).get(i)[0];
            int weight = list.get(start).get(i)[1];

            if (isVisited[target])
                continue;

            isVisited[target] = true;

            path.add(new long[] { target, sum + weight });

            dfs(list, isVisited, result, path, sum + weight, signalSpeed, target);

            isVisited[target] = false;
            path.remove(path.size() - 1);

        }
    }

    @Test
    public void test1() {
        assertArrayEquals(new int[] { 2, 0, 0, 0, 0, 0, 2 }, countPairsOfConnectableServers(
                new int[][] { { 0, 6, 3 }, { 6, 5, 3 }, { 0, 3, 1 }, { 3, 2, 7 }, { 3, 1, 6 }, { 3, 4, 2 } }, 3));
    }
}
