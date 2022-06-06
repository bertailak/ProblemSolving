package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DiscountPrices {

    // https://leetcode.com/problems/apply-discount-to-prices/

    public String discountPrices(String sentence, int discount) {
        StringBuilder sb = new StringBuilder();

        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (words[i].charAt(0) == '$' && words[i].substring(1).matches("[0-9]+")) {
                double number = Double.parseDouble(words[i].substring(1));
                number -= (number * discount / 100);
                sb.append(" $" + String.format("%.2f", number));
            } else {
                sb.append(" " + words[i]);
            }
        }

        sb.deleteCharAt(0);
        return sb.toString();
    }

    @Test
    public void test1() {
        String sentence = "there are $1 $2 and 5$ candies in the shop";
        int discount = 50;
        String expected = "there are $0.50 $1.00 and 5$ candies in the shop";
        String actual = discountPrices(sentence, discount);
        assertEquals(expected, actual);
    }
}
