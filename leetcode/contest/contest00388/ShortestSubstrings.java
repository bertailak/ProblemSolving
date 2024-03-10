package leetcode.contest.contest00388;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class ShortestSubstrings {

    public String[] shortestSubstrings(String[] arr) {
        String[] answer = new String[arr.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = "";
        }

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[i].length(); j++) {
                for (int k = j + 1; k <= arr[i].length(); k++) {
                    String sub = arr[i].substring(j, k);

                    boolean found = false;

                    for (int l = 0; l < arr.length; l++) {

                        if (l == i || !arr[l].contains(sub))
                            continue;
                        found = true;
                        break;
                    }
                    if (!found) {
                        if (answer[i].length() == 0 || answer[i].length() > sub.length()
                                || answer[i].length() == sub.length() && answer[i].compareTo(sub) > 0) {
                            answer[i] = sub;
                        }
                    }
                }
            }

        }

        return answer;
    }

    @Test
    public void test1() {
        assertArrayEquals(new String[] { "ab", "", "ba", "" },
                shortestSubstrings(new String[] { "cab", "ad", "bad", "c" }));
    }

    @Test
    public void test2() {
        assertArrayEquals(new String[] { "", "", "abcd" },
                shortestSubstrings(new String[] { "abc", "bcd", "abcd" }));
    }

    @Test
    public void test3() {
        assertArrayEquals(new String[] { "b", "g", "n", "k", "a" },
                shortestSubstrings(new String[] { "vbb", "grg", "lexn", "oklqe", "yxav" }));
    }
}
