package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class CanFinish {

    // https://leetcode.com/problems/course-schedule/

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] G = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        ArrayList<Integer> bfs = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i)
            G[i] = new ArrayList<Integer>();
        for (int[] e : prerequisites) {
            G[e[1]].add(e[0]);
            degree[e[0]]++;
        }
        for (int i = 0; i < numCourses; ++i)
            if (degree[i] == 0)
                bfs.add(i);
        for (int i = 0; i < bfs.size(); ++i)
            for (int j : G[bfs.get(i)])
                if (--degree[j] == 0)
                    bfs.add(j);
        return bfs.size() == numCourses;
    }

    public static void name(String[] args) {

    }

    @Test
    public void test1() {
        int numCourses = 2;
        int[][] prerequisites = new int[][] { { 1, 0 } };
        boolean expected = true;
        boolean actual = canFinish(numCourses, prerequisites);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int numCourses = 2;
        int[][] prerequisites = new int[][] { { 1, 0 }, { 0, 1 } };
        boolean expected = false;
        boolean actual = canFinish(numCourses, prerequisites);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int numCourses = 20;
        int[][] prerequisites = new int[][] { { 0, 10 }, { 3, 18 }, { 5, 5 }, { 6, 11 }, { 11, 14 }, { 13, 1 },
                { 15, 1 }, { 17, 4 } };
        boolean expected = false;
        boolean actual = canFinish(numCourses, prerequisites);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int numCourses = 5;
        int[][] prerequisites = new int[][] { { 1, 4 }, { 2, 4 }, { 3, 1 }, { 3, 2 } };
        boolean expected = true;
        boolean actual = canFinish(numCourses, prerequisites);
        assertEquals(expected, actual);
    }
}
