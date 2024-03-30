package leetcode.contest.contest00390;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import leetcode.model.TrieNode;

public class StringIndices {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int[] result = new int[wordsQuery.length];

        TrieNode trie = new TrieNode();
        int minLengthIndex = 0;

        for (int i = 0; i < wordsContainer.length; i++) {
            if (wordsContainer[minLengthIndex].length() > wordsContainer[i].length())
                minLengthIndex = i;

            TrieNode curr = trie;
            for (int j = wordsContainer[i].length() - 1; j >= 0; j--) {
                int trieIndex = wordsContainer[i].charAt(j) - 'a';
                if (curr.children[trieIndex] == null) {
                    curr.children[trieIndex] = new TrieNode();
                    curr.children[trieIndex].value = i;
                }

                if (wordsContainer[i].length() < wordsContainer[curr.children[trieIndex].value].length())
                    curr.children[trieIndex].value = i;
                curr = curr.children[trieIndex];
            }
        }

        for (int i = 0; i < wordsQuery.length; i++) {

            if (trie.children[wordsQuery[i].charAt(wordsQuery[i].length() - 1) - 'a'] == null) {
                result[i] = minLengthIndex;
                continue;
            }

            TrieNode curr = trie;

            for (int j = wordsQuery[i].length() - 1; j >= 0; j--) {
                int trieIndex = wordsQuery[i].charAt(j) - 'a';
                if (curr.children[trieIndex] == null)
                    break;

                result[i] = curr.children[trieIndex].value;
                curr = curr.children[trieIndex];
            }

        }

        return result;
    }

    @Test
    public void test1() {
        assertArrayEquals(new int[] { 1, 1, 1 },
                stringIndices(new String[] { "abcd", "bcd", "xbcd" },
                        new String[] { "cd", "bcd", "xyz" }));
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[] { 2, 0, 2 },
                stringIndices(new String[] { "abcdefgh", "poiuygh", "ghghgh" },
                        new String[] { "gh", "acbfgh", "acbfegh" }));
    }

    @Test
    public void test3() {
        assertArrayEquals(new int[] { 0, 0, 0, 0, 0 },
                stringIndices(new String[] { "abcde", "abcde" },
                        new String[] { "abcde", "bcde", "cde", "de", "e" }));
    }
}
