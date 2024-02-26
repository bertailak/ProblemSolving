package leetcode.contest.contest00385;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LongestCommonPrefix {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int max = 0;
        Trie t1 = new Trie();

        for (int i = 0; i < arr1.length; i++) {
            String v1 = String.valueOf(arr1[i]);

            Trie t = t1;
            for (int c : v1.toCharArray()) {
                int index = c - '0';
                if (t.numbers[index] == null)
                    t.numbers[index] = new Trie();
                t.numbers[index].val = true;
                t = t.numbers[index];
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            String v1 = String.valueOf(arr2[i]);
            int curr = 0;
            Trie t = t1;
            for (int c : v1.toCharArray()) {
                int index = c - '0';
                if (t.numbers[index] == null)
                    break;
                if (!t.numbers[index].val)
                    break;
                t = t.numbers[index];
                curr++;
            }
            max = Math.max(max, curr);
        }
        return max;
    }

    public class Trie {
        Trie[] numbers = new Trie[10];
        boolean val;

        public Trie() {
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = null;
            }
        }
    }

    public int longestCommonPrefix2(int[] arr1, int[] arr2) {
        int max = 0;

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                int current = max + 1;
                String v1 = String.valueOf(arr1[i]);
                String v2 = String.valueOf(arr2[j]);

                if (v1.length() < current || v2.length() < current)
                    continue;

                if (!v1.substring(0, current).equals(v2.substring(0, current)))
                    continue;

                while (current < v1.length() && current < v2.length()
                        && v1.charAt(current) == v2.charAt(current)) {
                    current++;
                }
                max = current;
            }
        }

        return max;
    }

    @Test
    public void test1() {
        assertEquals(3, longestCommonPrefix(new int[] { 1, 10, 100 }, new int[] { 1000 }));
    }

    @Test
    public void test2() {
        assertEquals(0, longestCommonPrefix(new int[] { 1, 2, 3 }, new int[] { 4, 4, 4 }));
    }

    @Test
    public void test3() {
        assertEquals(1, longestCommonPrefix(new int[] { 1, 3 }, new int[] { 32, 22 }));
    }

    @Test
    public void test4() {
        assertEquals(0, longestCommonPrefix(new int[] { 8 }, new int[] { 48 }));
    }
}
