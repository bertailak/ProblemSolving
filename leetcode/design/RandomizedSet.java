package leetcode.design;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;

import org.junit.Test;

public class RandomizedSet {

    HashSet<Integer> set;

    public RandomizedSet() {
        set = new HashSet<>();
    }

    public boolean insert(int val) {
        if (set.contains(val))
            return false;
        set.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!set.contains(val))
            return false;
        set.remove(val);
        return true;
    }

    public int getRandom() {
        Object[] arr = set.toArray();
        int r  = (int)(Math.random()*arr.length);
        return (int) arr[r];
    }

    @Test
    public void test1() {
        RandomizedSet r = new RandomizedSet();
        assertEquals(true, r.insert(1));
        assertEquals(false, r.remove(2));
        assertEquals(true, r.insert(2));
        assertEquals(1, r.getRandom());
        assertEquals(true, r.remove(1));
        assertEquals(false, r.insert(2));
        assertEquals(2, r.getRandom());
    }
}