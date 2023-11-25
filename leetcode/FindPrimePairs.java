package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FindPrimePairs {

    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> result = new ArrayList<>();

        boolean[] notPrime = new boolean[n + 1];

        for (int i = 2; i <= notPrime.length / 2; i++) {

            int mult = i * 2;
            while (mult < notPrime.length) {
                notPrime[mult] = true;
                mult += i;
            }

        }
        for (int i = 2; i <= notPrime.length / 2; i++) {
            if (notPrime[i] || notPrime[n - i] || i > n - i)
                continue;

            result.add(List.of(i, n - i));
        }

        return result;
    }

    @Test
    public void test1() {
        assertEquals(List.of(List.of(3, 7), List.of(5, 5)), findPrimePairs(10));
        assertEquals(List.of(), findPrimePairs(2));
    }

    @Test
    public void test2() {
        assertEquals(List.of(), findPrimePairs(3));
    }
}
