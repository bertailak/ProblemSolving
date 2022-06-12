package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculateTax {

    // https://leetcode.com/problems/calculate-amount-paid-in-taxes/

    public double calculateTax(int[][] brackets, int income) {
        double earn = 0;

        if (brackets[0][0] < income) {
            earn = brackets[0][0] * (brackets[0][1] * 1.0 / 100);

            for (int i = 1; i < brackets.length; i++) {
                if (brackets[i][0] < income) {
                    earn += (brackets[i][0] - brackets[i - 1][0]) * (brackets[i][1] * 1.0 / 100);
                } else {
                    earn += (income - brackets[i - 1][0]) * (brackets[i][1] * 1.0 / 100);
                    break;
                }
            }
        } else {
            earn = income * (brackets[0][1] * 1.0 / 100);
        }

        return earn;
    }

    @Test
    public void test1() {
        int[][] brackets = new int[][] { { 3, 50 }, { 7, 10 }, { 12, 25 } };
        int income = 10;
        double expected = 2.65;
        double actual = calculateTax(brackets, income);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void test2() {
        int[][] brackets = new int[][] { { 1, 0 }, { 4, 25 }, { 5, 50 } };
        int income = 2;
        double expected = 0.25;
        double actual = calculateTax(brackets, income);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void test3() {
        int[][] brackets = new int[][] { { 2, 50 } };
        int income = 0;
        double expected = 0;
        double actual = calculateTax(brackets, income);
        assertEquals(expected, actual, 0.00001);
    }
}
