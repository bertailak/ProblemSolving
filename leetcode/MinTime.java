package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinTime {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int step = 0;

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(list, visited, hasApple);
        

        return step;
    }

    public boolean dfs(List<List<Integer>> list, boolean[] visited, List<Boolean> hasApple) {
        return false;
    }
}
