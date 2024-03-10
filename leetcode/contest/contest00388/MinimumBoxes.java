package leetcode.contest.contest00388;

import java.util.Arrays;

public class MinimumBoxes {

    public int minimumBoxes(int[] apple, int[] capacity) {
        int count = 0;

        int sum = 0;
        for (int a : apple) {
            sum += a;
        }

        Arrays.sort(capacity);

        for (int i = capacity.length - 1; i >= 0; i--) {
            sum -= capacity[i];
            count++;
            if (sum <= 0)
                break;
        }

        return count;
    }
}
