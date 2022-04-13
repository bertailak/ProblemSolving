package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinimizeResult {

    // https://leetcode.com/problems/minimize-result-by-adding-parentheses-to-expression/

    public String minimizeResult(String expression) {
        String[] numsstr = expression.split("\\+");

        int resultNum = Integer.parseInt(numsstr[0]) + Integer.parseInt(numsstr[1]);
        String resultVal = "(" + expression + ")";

        StringBuilder sb1 = new StringBuilder(numsstr[0]);
        StringBuilder sb2 = new StringBuilder(numsstr[1]);

        for (int i = 0; i < sb1.length(); i++) {
            for (int j = 1; j <= sb2.length(); j++) {

                int num1 = Integer.parseInt(sb1.substring(i));
                int num2 = Integer.parseInt(sb2.substring(0, j));

                int res = num1 + num2;
                String val = "";
                if (i > 0) {
                    int num0 = Integer.parseInt(sb1.substring(0, i));
                    res *= num0;
                    val = sb1.substring(0, i);
                }
                val = val + "(" + num1 + "+" + num2 + ")";
                if (j < sb2.length()) {
                    int num3 = Integer.parseInt(sb2.substring(j));
                    res *= num3;
                    val = val + sb2.substring(j);
                }
                if (res < resultNum) {
                    resultNum = res;
                    resultVal = val;
                }
            }
        }

        return resultVal;
    }

    @Test
    public void test1() {
        String expression = "12+34";
        String expected = "1(2+3)4";
        String actual = minimizeResult(expression);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String expression = "1+3";
        String expected = "(1+3)";
        String actual = minimizeResult(expression);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String expression = "999+999";
        String expected = "(999+999)";
        String actual = minimizeResult(expression);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        String expression = "16+88";
        String expected = "1(6+88)";
        String actual = minimizeResult(expression);
        assertEquals(expected, actual);
    }
}
