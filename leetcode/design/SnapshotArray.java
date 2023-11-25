package leetcode.design;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class SnapshotArray {

    // https://leetcode.com/problems/snapshot-array/

    HashMap<Integer, List<int[]>> map;
    int snap_id;

    public SnapshotArray() {
        map = new HashMap<>();
        snap_id = 0;
    }

    // public SnapshotArray(int length) {
    // map = new HashMap<>();
    // snap_id = 0;
    // }

    public void set(int index, int val) {
        List<int[]> list = map.getOrDefault(index, new ArrayList<>());
        list.add(new int[] { snap_id, val });
        map.put(index, list);
    }

    public int snap() {
        return ++snap_id;
    }

    public int get(int index, int snap_id) {
        List<int[]> list = map.getOrDefault(index, new ArrayList<>());
        if (list.size() == 0)
            return 0;

        if (list.get(list.size() - 1)[0] <= index)
            return list.get(list.size() - 1)[1];

        int l = 0;
        int r = list.size() - 1;
        int ans = 0;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (list.get(mid)[0] <= snap_id) {
                l = mid + 1;
                ans = mid;
            } else {
                r = mid - 1;
            }
        }

        return list.get(ans)[1];
    }

    @Test
    public void test1() {
        SnapshotArray ss = new SnapshotArray();
        ss.set(0, 4);
        ss.set(0, 5);
        ss.snap();
        ss.set(0, 6);
        assertEquals(5, ss.get(0, 0));
    }
}
