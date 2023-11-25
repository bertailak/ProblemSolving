package leetcode.design;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class CountIntervals {

    private PriorityQueue<int[]> pq;
    private int count;

    public CountIntervals() {
        pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        count = 0;
    }

    public void add(int left, int right) {
        if (pq.isEmpty() || pq.size() == 0) {
            pq.add(new int[] { left, right });
            count = right + 1 - left;
        } else {
            Queue<int[]> q = new LinkedList<>();
            pq.add(new int[] { left, right });
            count += right + 1 - left;
            while (pq.size() > 1) {
                int[] top = pq.poll();
                count -= top[1] + 1 - top[0];
                if (top[1] < pq.peek()[0]) {
                    q.add(top);
                } else {
                    int[] peek = pq.poll();
                    count -= peek[1] + 1 - peek[0];
                    int min = Math.min(top[0], peek[0]);
                    int max = Math.max(top[1], peek[1]);
                    pq.add(new int[] { min, max });
                    count += max + 1 - min;
                    break;
                }
            }

            while (!q.isEmpty()) {
                int[] top = q.poll();
                pq.add(top);
                count += top[1] + 1 - top[0];
            }

        }
    }

    public int count() {
        return count;
    }

}
