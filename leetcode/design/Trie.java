package leetcode.design;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Trie {

    // https://leetcode.com/problems/implement-trie-prefix-tree/

    public Trie[] alphabet;
    public boolean isEnd;

    public Trie() {
        alphabet = new Trie[26];
        isEnd = false;

    }

    public void insert(String word) {
        Trie[] head = alphabet;
        for (int i = 0; i < word.length(); i++) {
            if (head[word.charAt(i) - 'a'] == null)
                head[word.charAt(i) - 'a'] = new Trie();
            if (i == word.length() - 1)
                head[word.charAt(i) - 'a'].isEnd = true;
            head = head[word.charAt(i) - 'a'].alphabet;
        }
    }

    public boolean search(String word) {
        Trie[] head = alphabet;
        for (int i = 0; i < word.length() - 1; i++) {
            if (head[word.charAt(i) - 'a'] == null)
                return false;
            head = head[word.charAt(i) - 'a'].alphabet;
        }
        return head[word.charAt(word.length() - 1) - 'a'] != null
                && head[word.charAt(word.length() - 1) - 'a'].isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie[] head = alphabet;
        for (int i = 0; i < prefix.length(); i++) {
            if (head[prefix.charAt(i) - 'a'] == null)
                return false;
            head = head[prefix.charAt(i) - 'a'].alphabet;
        }
        return true;
    }

    @Test
    public void tes1() {
        Trie t = new Trie();
        assertEquals(false, t.search("a"));
        t.insert("apple");
        assertEquals(true, t.search("apple"));
        assertEquals(false, t.search("app"));
        assertEquals(true, t.startsWith("app"));
        t.insert("app");
        assertEquals(true, t.search("app"));
    }
}