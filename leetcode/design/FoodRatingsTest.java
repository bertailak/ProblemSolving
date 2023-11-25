package leetcode.design;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FoodRatingsTest {

    @Test
    public void test1() {
        String[] foods = { "kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi" };
        String[] cuisines = { "korean", "japanese", "japanese", "greek", "japanese", "korean" };
        int[] ratings = { 9, 12, 8, 15, 14, 7 };

        FoodRatings foodRatings = new FoodRatings(foods, cuisines, ratings);
        assertEquals("kimchi", foodRatings.highestRated("korean"));
        assertEquals("ramen", foodRatings.highestRated("japanese"));
        foodRatings.changeRating("sushi", 16);
        assertEquals("sushi", foodRatings.highestRated("japanese"));
        foodRatings.changeRating("ramen", 16);
        assertEquals("ramen", foodRatings.highestRated("japanese"));
    }

}
