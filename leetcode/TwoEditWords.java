package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TwoEditWords {

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();

        for (String query : queries) {
            for (String word : dictionary) {
                int count = 0;
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) != query.charAt(i))
                        count++;
                }
                if (count <= 2) {
                    result.add(query);
                    break;
                }
            }
        }

        return result;
    }

    @Test
    public void test1() {
        assertEquals(List.of("word", "note", "wood"),
                twoEditWords(new String[] { "word", "note", "ants", "wood" }, new String[] { "wood", "joke", "moat" }));
    }
}
