package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;

public class MaximumSetSize {

    // https://leetcode.com/problems/maximum-size-of-a-set-after-removals/

    public int maximumSetSize(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }

        HashMap<Integer, Integer> mapMin = map1;
        HashMap<Integer, Integer> mapMax = map2;

        if (map1.size() > map2.size()) {
            mapMin = map2;
            mapMax = map1;
        }

        int maxSize = mapMin.size();

        int[][] arr = new int[mapMax.size()][2];

        int i = 0;
        for (int key : mapMax.keySet()) {
            arr[i] = new int[] { key, mapMax.get(key) };
            i++;
        }

        Arrays.sort(arr, (a, b) -> {
            return a[1] - b[1];
        });

        int deleted = 0;
        int used = 0;

        for (int j = 0; j < arr.length; j++) {
            if (deleted >= nums2.length / 2) {
                maxSize += arr.length - j;
                break;
            }
            if (used >= nums2.length / 2) {
                break;
            }
            if (mapMin.containsKey(arr[j][0])) {
                deleted += arr[j][1];
            } else {
                maxSize++;
                used++;
            }
        }

        return maxSize;
    }

    @Test
    public void test1() {
        assertEquals(2, maximumSetSize(new int[] { 1, 2, 1, 2 }, new int[] { 1, 1, 1, 1 }));
    }

    @Test
    public void test2() {
        assertEquals(5, maximumSetSize(new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 2, 3, 2, 3, 2, 3 }));
    }

    @Test
    public void test3() {
        assertEquals(6, maximumSetSize(new int[] { 1, 1, 2, 2, 3, 3 }, new int[] { 4, 4, 5, 5, 6, 6 }));
    }

    @Test
    public void test4() {
        assertEquals(2, maximumSetSize(new int[] { 8, 9 }, new int[] { 4, 3 }));
    }
}
