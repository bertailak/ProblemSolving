package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BeautifulIndices {

    public List<Integer> beautifulIndices(String s, String a, String b, int k) {

        List<Integer> result = new ArrayList<>();
        List<Integer> result1 = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {

            int i1 = 0;
            while (i1 < a.length() && i + i1 < s.length() && s.charAt(i + i1) == a.charAt(i1)) {
                i1++;
                if (i1 == a.length())
                    result1.add(i);
            }

            int i2 = 0;
            while (i2 < b.length() && i + i2 < s.length() && s.charAt(i + i2) == b.charAt(i2)) {
                i2++;
                if (i2 == b.length())
                    result2.add(i);
            }
        }

        if (result2.size() == 0)
            return result;

        for (int i = 0; i < result1.size(); i++) {

            int j = lowerBound(result2, result1.get(i) - k);

            while (j < result2.size() && result2.get(j++) - k <= result1.get(i)) {
                result.add(result1.get(i));
                break;
            }

        }

        return result;
    }

    private int lowerBound(List<Integer> list, int target) {
        int l = 0;
        int r = list.size() - 1;

        if (list.get(r) < target) {
            return r + 1;
        }

        while (l < r) {
            int m = l + (r - l) / 2;
            if (target <= list.get(m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    @Test
    public void test1() {
        assertEquals(List.of(16, 33),
                beautifulIndices("isawsquirrelnearmysquirrelhouseohmy", "my", "squirrel", 15));
    }

    @Test
    public void test2() {
        assertEquals(List.of(0),
                beautifulIndices("abcd", "a", "a", 4));
    }

    @Test
    public void test3() {
        assertEquals(List.of(0),
                beautifulIndices("bavgoc", "ba", "c", 6));
    }

    @Test
    public void test4() {
        assertEquals(List.of(2, 3),
                beautifulIndices("ocmm", "m", "oc", 3));
    }

    @Test
    public void test5() {
        assertEquals(List.of(),
                beautifulIndices("lahhnlwx", "hhnlw", "ty", 6));
    }

    @Test
    public void test6() {
        assertEquals(List.of(),
                beautifulIndices("klxtee", "e", "klx", 2));
    }
}
