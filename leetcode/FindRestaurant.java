package leetcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class FindRestaurant {

    // https://leetcode.com/problems/minimum-index-sum-of-two-lists/

    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> list = new ArrayList<>();
        int min = list1.length + list2.length;

        HashMap<String, int[]> map = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], new int[] { 0, i });
        }

        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int[] value = map.get(list2[i]);
                value[0] = 1;
                value[1] += i;
                min = Math.min(min, value[1]);
                map.put(list2[i], value);
            }
        }

        for (String restaurant : map.keySet()) {
            int[] value = map.get(restaurant);
            if (value[0] == 1 && value[1] == min) {
                list.add(restaurant);
            }
        }

        return list.toArray(new String[0]);
    }

    @Test
    public void test1() {
        String[] list1 = new String[] { "Shogun", "Tapioca Express", "Burger King", "KFC" };
        String[] list2 = new String[] { "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun" };
        String[] expecteds = new String[] { "Shogun" };
        String[] actuals = findRestaurant(list1, list2);
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void test2() {
        String[] list1 = new String[] { "Shogun", "Tapioca Express", "Burger King", "KFC" };
        String[] list2 = new String[] { "KFC", "Shogun", "Burger King" };
        String[] expecteds = new String[] { "Shogun" };
        String[] actuals = findRestaurant(list1, list2);
        assertArrayEquals(expecteds, actuals);
    }
}
