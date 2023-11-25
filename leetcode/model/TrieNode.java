package leetcode.model;

public class TrieNode {

    final int size = 26;
    public TrieNode[] children = new TrieNode[size];
    public boolean isEndOfWord;
    public int value;

    public TrieNode() {
        isEndOfWord = false;
        value = 0;
        for (int i = 0; i < size; i++)
            children[i] = null;
    }
}
