package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

public class PacificAtlantic {

    // https://leetcode.com/problems/pacific-atlantic-water-flow/

    int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        int[][] flows = new int[heights.length][heights[0].length];
        for (int i = 0; i < flows.length; i++) {
            Arrays.fill(flows[i], 1);
        }

        Stack<int[]> st = new Stack<>();
        for (int i = 0; i < flows.length; i++) {
            st.push(new int[] { i, 0 });
            flows[i][0] *= 2;
        }
        for (int i = 1; i < flows[0].length; i++) {
            st.push(new int[] { 0, i });
            flows[0][i] *= 2;
        }

        while (!st.isEmpty()) {
            int[] top = st.pop();
            for (int i = 0; i < dirs.length; i++) {
                if (top[0] + dirs[i][0] >= 0
                        && top[0] + dirs[i][0] < flows.length
                        && top[1] + dirs[i][1] >= 0
                        && top[1] + dirs[i][1] < flows[0].length
                        && heights[top[0] + dirs[i][0]][top[1] + dirs[i][1]] >= heights[top[0]][top[1]]
                        && flows[top[0] + dirs[i][0]][top[1] + dirs[i][1]] % 2 != 0) {
                    st.push(new int[] { top[0] + dirs[i][0], top[1] + dirs[i][1] });
                    flows[top[0] + dirs[i][0]][top[1] + dirs[i][1]] *= 2;
                }
            }
        }

        for (int i = 0; i < flows.length; i++) {
            st.push(new int[] { i, flows[0].length - 1 });
            flows[i][flows[0].length - 1] *= 3;
        }
        for (int i = 0; i < flows[0].length - 1; i++) {
            st.push(new int[] { flows.length - 1, i });
            flows[flows.length - 1][i] *= 3;
        }

        while (!st.isEmpty()) {
            int[] top = st.pop();
            for (int i = 0; i < dirs.length; i++) {
                if (top[0] + dirs[i][0] >= 0
                        && top[0] + dirs[i][0] < flows.length
                        && top[1] + dirs[i][1] >= 0
                        && top[1] + dirs[i][1] < flows[0].length
                        && heights[top[0] + dirs[i][0]][top[1] + dirs[i][1]] >= heights[top[0]][top[1]]
                        && flows[top[0] + dirs[i][0]][top[1] + dirs[i][1]] % 3 != 0) {
                    st.push(new int[] { top[0] + dirs[i][0], top[1] + dirs[i][1] });
                    flows[top[0] + dirs[i][0]][top[1] + dirs[i][1]] *= 3;
                }
            }
        }

        for (int i = 0; i < flows.length; i++) {
            for (int j = 0; j < flows[0].length; j++) {
                if (flows[i][j] == 6) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }

    @Test
    public void test1() {
        List<List<Integer>> actual = pacificAtlantic(new int[][] { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 },
                { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 }, { 5, 1, 1, 2, 4 } });
    }

}