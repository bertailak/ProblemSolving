package task;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Scanner;

import org.junit.Test;

public class IdealSubmatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] nums = line.split(" ");
        int[][] matrix = new int[Integer.parseInt(nums[0])][Integer.parseInt(nums[1])];

        for (int i = 0; i < matrix.length; i++) {
            line = sc.nextLine();
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(idealSubmatrix(matrix));

        sc.close();
    }

    public static int idealSubmatrix(int[][] matrix) {
        int count = 0;

        int line = matrix.length;
        int column = matrix[0].length;
        int[][] sum = new int[line][column];

        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[0].length; j++) {
                int top = i > 0 ? sum[i - 1][j] : 0;
                int left = j > 0 ? sum[i][j - 1] : 0;
                int top_left = (i > 0 && j > 0) ? sum[i - 1][j - 1] : 0;
                sum[i][j] = matrix[i][j] + top + left - top_left;
            }
        }

        for (int i = 0; i < sum.length; i++) {
            for (int i2 = i; i2 < sum.length; i2++) {
                for (int j = 0; j < sum[0].length; j++) {

                    int isRowEven = (i2 - i) % 2;

                    for (int j2 = j + 1 - isRowEven; j2 < sum[0].length; j2 += (1 + 1 - isRowEven)) {

                        if ((i2 - i) % 2 == 0 && (j2 - j) % 2 == 0)
                            continue;

                        int target = ((i2 - i + 1) * (j2 - j + 1)) / 2;

                        int top = i > 0 ? sum[i - 1][j2] : 0;
                        int left = j > 0 ? sum[i2][j - 1] : 0;
                        int top_left = (i > 0 && j > 0) ? sum[i - 1][j - 1] : 0;
                        int s = sum[i2][j2] - top - left + top_left;
                        if (s == target)
                            count++;
                    }
                }
            }
        }

        return count;
    }

    @Test
    public void test1() {
        assertEquals(9, idealSubmatrix(new int[][] { { 0, 0, 0, 0 }, { 0, 0, 1, 1 }, { 0, 0, 1, 1 } }));
    }
}
