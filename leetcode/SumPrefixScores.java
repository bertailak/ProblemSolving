package leetcode;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import leetcode.model.TrieNode;

public class SumPrefixScores {
    public int[] sumPrefixScores(String[] words) {
        int[] result = new int[words.length];
        TrieNode trie = new TrieNode();
        for (int i = 0; i < trie.children.length; i++) {
            trie.children[i] = new TrieNode();
        }

        for (int i = 0; i < words.length; i++) {

            TrieNode subTrie = trie.children[words[i].charAt(0) - 'a'];
            subTrie.value++;
            if (subTrie.children[0] == null) {
                for (int j = 0; j < subTrie.children.length; j++) {
                    subTrie.children[j] = new TrieNode();
                }
            }

            for (int j = 1; j < words[i].length(); j++) {
                subTrie = subTrie.children[words[i].charAt(0) - 'a'];
                subTrie.value++;
                for (int k = 0; k < subTrie.children.length; k++) {
                    subTrie.children[k] = new TrieNode();
                }
            }
        }

        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();

            int sum = 0;

            for (char letter : words[i].toCharArray()) {
                sb.append(letter);
            }

            result[i] = sum;
        }

        return result;
    }

    @Test
    public void test1() {
        String[] words = new String[] { "abc", "ab", "bc", "b" };
        int[] expecteds = new int[] { 5, 4, 3, 2 };
        assertArrayEquals(expecteds, sumPrefixScores(words));
    }

    @Test
    public void test2() {
        String[] words = new String[] { "abcd" };
        int[] expecteds = new int[] { 4 };
        assertArrayEquals(expecteds, sumPrefixScores(words));
    }
}