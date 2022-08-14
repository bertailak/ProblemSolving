package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

public class EdgeScore {
    public int edgeScore(int[] edges) {

        HashMap<Integer, Long> map = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            map.put(edges[i], map.getOrDefault(edges[i], 0L) + i);
        }

        long max = map.getOrDefault(0, 0L);
        int key1 = 0;

        for (int key : map.keySet()) {
            if (max < map.get(key) || (max == map.get(key) && key < key1)) {
                max = map.get(key);
                key1 = key;
            }
        }

        return key1;
    }

    @Test
    public void test1() {
        int[] edges = { 1, 0, 0, 0, 0, 7, 7, 5 };
        int expected = 7;
        int actual = edgeScore(edges);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] edges = { 2, 0, 0, 2 };
        int expected = 0;
        int actual = edgeScore(edges);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] edges = { 1, 3, 1, 2 };
        int expected = 2;
        int actual = edgeScore(edges);
        assertEquals(expected, actual);
    }
}
