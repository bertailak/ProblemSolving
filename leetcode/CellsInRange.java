package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CellsInRange {

    // https://leetcode.com/problems/cells-in-a-range-on-an-excel-sheet/

    public List<String> cellsInRange(String s) {
        List<String> list = new ArrayList<>();

        int x1 = s.charAt(0);
        int y1 = Integer.parseInt(s.charAt(1) + "");
        int x2 = s.charAt(3);
        int y2 = Integer.parseInt(s.charAt(4) + "");

        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                String cell = (char) i + "" + j;
                list.add(cell);
            }
        }

        return list;
    }

    @Test
    public void test1() {
        String s = "K1:L2";
        List<String> expected = List.of(new String[] { "K1", "K2", "L1", "L2" });
        List<String> actual = cellsInRange(s);
        assertEquals(expected, actual);
    }

}