package leetcode.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FoodRatings {

    HashMap<String, Integer> foodRating;
    HashMap<String, List<String>> cuisinesFoods;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRating = new HashMap<>();
        cuisinesFoods = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            foodRating.put(foods[i], ratings[i]);

            if (!cuisinesFoods.containsKey(cuisines[i]))
                cuisinesFoods.put(cuisines[i], new ArrayList<>());
            List<String> cFoods = cuisinesFoods.get(cuisines[i]);
            cFoods.add(foods[i]);
        }

    }

    public void changeRating(String food, int newRating) {
        foodRating.put(food, newRating);
    }

    public String highestRated(String cuisine) {
        String cFood = cuisinesFoods.get(cuisine).get(0);
        int cRating = foodRating.get(cFood);

        for (String iFood : cuisinesFoods.get(cuisine)) {
            if (cRating < foodRating.get(iFood) || (cRating == foodRating.get(iFood) && iFood.compareTo(cFood) < 0)) {
                cFood = iFood;
                cRating = foodRating.get(iFood);
            }
        }
        return cFood;
    }

}
