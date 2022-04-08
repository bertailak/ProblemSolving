package leetcode.design;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargest {

    private int k;
    private PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {

        this.k = k;
        pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }

    }

    public int add(int val) {
        pq.offer(val);
        Integer[] arr = pq.toArray(new Integer[pq.size()]);
        return arr[k];
    }

}
