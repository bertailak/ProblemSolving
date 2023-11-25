package leetcode;

import java.util.List;

public class MaxValueOfCoins {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[][] dp = new int[piles.size()][piles.get(0).size()];

        for (int i = 0; i < piles.size(); i++) {
            for (int j = 0; j < piles.get(0).size(); j++) {
                for (int l = 0; l < i + 1; l++) {
                    // dp[i][]
                }
            }
        }

        return 0;
    }
}