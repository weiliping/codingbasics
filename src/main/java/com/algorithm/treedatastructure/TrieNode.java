package com.algorithm.treedatastructure;

public class TrieNode {
    // Initialize your data structure here.
    TrieNode[] children = new TrieNode[26];
    int count = 0;
    public TrieNode() {

    }

    TrieNode safe(int i){
        if(children[i] == null){
            children[i] = new TrieNode();
        }
        return children[i];
    }

    int index(char c){
        return (int)(c - 'a');
    }

    void insert(char[] word, int st, int len){
        if(len == 0){
            this.count++;
            return;
        }
        TrieNode t = safe(index(word[st]));
        t.insert(word, st + 1, len - 1);
    }

    boolean search(char[] word, int st, int len){
        if(len == 0){
            return this.count > 0;
        }
        TrieNode t = children[index(word[st])];
        if(t == null){
            return false;
        }
        return t.search(word, st + 1, len - 1);
    }

    boolean startsWith(char[] prefix, int st, int len) {
        if(len == 0){
            return true;
        }
        TrieNode t = children[index(prefix[st])];
        if(t == null){
            return false;
        }
        return t.startsWith(prefix, st + 1, len - 1);
    }
}
