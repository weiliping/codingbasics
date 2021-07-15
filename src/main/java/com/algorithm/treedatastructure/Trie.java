package com.algorithm.treedatastructure;

public class Trie {

    /**
     * #208
     * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
     *
     */
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        root.insert(word.toCharArray(), 0, word.length());
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return root.search(word.toCharArray(), 0, word.length());
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return root.startsWith(prefix.toCharArray(), 0, prefix.length());
    }
}
