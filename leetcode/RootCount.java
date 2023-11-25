package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

public class RootCount {

    // https://leetcode.com/contest/biweekly-contest-99/problems/count-number-of-possible-root-nodes/

    private boolean isRoot(List<List<Integer>> graph, List<List<Integer>> guess, int k, int index) {
        if (k == 0)
            return true;
        boolean[] visited = new boolean[graph.size()];
        visited[index] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(index);

        while (!q.isEmpty()) {
            int top = q.poll();
            for (int g : graph.get(top)) {
                if (!visited[g]) {
                    if (guess.get(top).size() > 0 && guess.get(top).contains(g)) {
                        k--;
                        if (k == 0)
                            return true;
                    }
                    visited[g] = true;
                    q.add(g);
                }
            }

        }

        return false;
    }

    public int rootCount(int[][] edges, int[][] guesses, int k) {
        int count = 0;

        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> guess = new ArrayList<>();
        for (int i = 0; i <= edges.length; i++) {
            graph.add(new ArrayList<>());
            guess.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        for (int i = 0; i < guesses.length; i++) {
            guess.get(guesses[i][0]).add(guesses[i][1]);
        }

        for (int i = 0; i <= edges.length; i++) {

            if (isRoot(graph, guess, k, i)) {
                count++;
            }
        }

        return count;
    }

    @Test
    public void test1() {
        assertEquals(3, rootCount(new int[][] { { 0, 1 }, { 1, 2 }, { 1, 3 }, { 4, 2 } },
                new int[][] { { 1, 3 }, { 0, 1 }, { 1, 0 }, { 2, 4 } }, 3));
    }

    @Test
    public void test2() {
        assertEquals(5, rootCount(new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 } },
                new int[][] { { 1, 0 }, { 3, 4 }, { 2, 1 }, { 3, 2 } }, 1));
    }
}
