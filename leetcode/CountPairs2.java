package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountPairs2 {

    // https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/

    int[] nodes;

    public long countPairs(int n, int[][] edges) {
        long count = 0;
        nodes = new int[n];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = i;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        for (int i = 0; i < nodes.length; i++) {
            System.out.print(nodes[i] + " ");
        }

        return count;
    }

    private int get(int num) {
        if (num != nodes[num])
            nodes[num] = get(nodes[num]);
        return nodes[num];
    }

    private void union(int a, int b) {
        int x = get(a);
        int y = get(b);
        nodes[x] = y;
    }

    @Test
    public void test1() {
        assertEquals(0, countPairs(3, new int[][] { { 0, 1 }, { 0, 2 }, { 1, 2 } }));
    }

}
