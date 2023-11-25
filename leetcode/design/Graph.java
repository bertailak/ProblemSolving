package leetcode.design;

import static org.junit.Assert.assertEquals;

import java.util.PriorityQueue;

import org.junit.Test;

public class Graph {

    private int[][] grid;

    public Graph() {
    }

    public void constructor(int n, int[][] edges) {
        grid = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            grid[edges[i][0]][edges[i][1]] = edges[i][2];
        }
    }

    public void addEdge(int[] edge) {
        grid[edge[0]][edge[1]] = edge[2];
    }

    public int shortestPath(int node1, int node2) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.add(new int[] { node1, 0 });

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            if (top[0] == node2)
                return top[1];

            for (int i = 0; i < grid[top[0]].length; i++) {
                if (grid[top[0]][i] == 0)
                    continue;
                pq.add(new int[] { i, top[1] + grid[top[0]][i] });
            }
        }

        return -1;
    }

    @Test
    public void test1() {
        Graph g = new Graph();
        g.constructor(4, new int[][] { { 0, 2, 5 }, { 0, 1, 2 }, { 1, 2, 1 }, { 3, 0, 3 } });
        assertEquals(6, g.shortestPath(3, 2));
        assertEquals(-1, g.shortestPath(0, 3));
        g.addEdge(new int[] { 1, 3, 4 });
        assertEquals(6, g.shortestPath(0, 3));
    }
}
