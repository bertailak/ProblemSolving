package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Exist {

    // https://leetcode.com/problems/word-search/

    int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != word.charAt(0))
                    continue;
                visited[i][j] = true;
                if (dfs(board, word, new int[] { i, j }, visited, 1))
                    return true;
                visited[i][j] = false;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int[] position, boolean[][] visited, int index) {

        for (int i = 0; i < directions.length; i++) {
            int dx = position[0] + directions[i][0];
            int dy = position[1] + directions[i][1];
            if (dx < 0 || dx >= board.length || dy < 0 || dy >= board[0].length)
                continue;
            if (board[dx][dy] == word.charAt(index) && !visited[dx][dy]) {
                if (index + 1 == word.length())
                    return true;
                visited[dx][dy] = true;
                if (dfs(board, word, new int[] { dx, dy }, visited, index + 1))
                    return true;
                visited[dx][dy] = false;
            }
        }

        return false;
    }

    @Test
    public void test1() {
        assertEquals(true,
                exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "SEE"));
    }
}
