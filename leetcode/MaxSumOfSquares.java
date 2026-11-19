package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxSumOfSquares {

    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb = new StringBuilder();
        return backtracking(num, sum, sb);
    }

    private String backtracking(int num, int sum, StringBuilder sb) {
        if (sb.length() == num && sum == 0)
            return sb.toString();
        if (sb.length() >= num)
            return "";

        int start = Math.min(9, sum);
        sb.append(start);
        return backtracking(num, sum - start, sb);
    }

    @Test
    public void Test1() {
        assertEquals("30", maxSumOfSquares(2, 3));
    }

    @Test
    public void Tes2() {
        assertEquals("98", maxSumOfSquares(2, 17));
    }

    @Test
    public void Tes3() {
        assertEquals("", maxSumOfSquares(1, 10));
    }

    @Test
    public void Tes4() {
        assertEquals("1", maxSumOfSquares(1, 1));
    }

    @Test
    public void Test5() {
        assertEquals("", maxSumOfSquares(2, 19));
    }

    @Test
    public void Test6() {
        assertEquals("100", maxSumOfSquares(3, 1));
    }

    @Test
    public void Test7() {
        assertEquals("", maxSumOfSquares(8, 73));
    }

    @Test
    public void Test8() {
        assertEquals("", maxSumOfSquares(9, 82));
    }
}