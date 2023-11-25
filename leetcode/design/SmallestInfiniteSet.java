package leetcode.design;

import static org.junit.Assert.assertEquals;

import java.util.PriorityQueue;

import org.junit.Test;

public class SmallestInfiniteSet {

    boolean[] nums;
    PriorityQueue<Integer> pq;
    int index;

    public SmallestInfiniteSet() {
        nums = new boolean[1001];
        pq = new PriorityQueue<>();
        index = 1;
    }

    public int popSmallest() {
        if (pq.isEmpty())
            return index++;

        int top = pq.peek();
        if (top < index) {
            nums[top] = false;
            return pq.poll();
        }
        return index++;
    }

    public void addBack(int num) {
        if (num < index && !nums[num]) {
            pq.add(num);
            nums[num] = true;
        }
    }

    @Test
    public void test1() {
        SmallestInfiniteSet smallSet = new SmallestInfiniteSet();
        smallSet.addBack(2);
        assertEquals(1, smallSet.popSmallest());
        assertEquals(2, smallSet.popSmallest());
        assertEquals(3, smallSet.popSmallest());
        smallSet.addBack(2);
        smallSet.addBack(2);
        assertEquals(2, smallSet.popSmallest());
        assertEquals(4, smallSet.popSmallest());
        assertEquals(5, smallSet.popSmallest());
    }
}
