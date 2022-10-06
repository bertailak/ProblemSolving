package leetcode.design;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class TimeMap {

    HashMap<String, List<MapTime>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        List<MapTime> list = map.get(key);
        list.add(new MapTime(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<MapTime> list = map.getOrDefault(key, new ArrayList<>());

        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).time <= timestamp) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (right == 0)
            return "";

        return list.get(right - 1).value;
    }

    @Test
    public void test1() {
        TimeMap t = new TimeMap();
        t.set("foo", "bar", 1);
        assertEquals("bar", t.get("foo", 1));
        assertEquals("bar", t.get("foo", 3));
        t.set("foo", "bar2", 4);
        assertEquals("bar2", t.get("foo", 4));
        assertEquals("bar2", t.get("foo", 5));
    }
}

class MapTime {

    public int time;
    public String value;

    MapTime(int t, String v) {
        time = t;
        value = v;
    }
}
