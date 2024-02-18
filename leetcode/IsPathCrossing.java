package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class IsPathCrossing {

    // https://leetcode.com/problems/path-crossing/?envType=daily-question&envId=2023-12-23

    public boolean isPathCrossing(String path) {
        Set<List<Integer>> set = new HashSet<>();

        int x = 0;
        int y = 0;
        set.add(List.of(x, y));

        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'N') {
                y++;
            }
            if (path.charAt(i) == 'S') {
                y--;
            }
            if (path.charAt(i) == 'E') {
                x++;
            }
            if (path.charAt(i) == 'W') {
                x--;
            }

            if (set.contains(List.of(x, y)))
                return true;

            set.add(List.of(x, y));
        }

        return false;
    }

    @Test
    public void test1() {
        assertEquals(false, isPathCrossing("NES"));
    }

    @Test
    public void test2() {
        assertEquals(true, isPathCrossing("NESWW"));
    }
}
