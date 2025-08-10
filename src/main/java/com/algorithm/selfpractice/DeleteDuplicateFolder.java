package com.algorithm.selfpractice;

import java.util.List;

public class DeleteDuplicateFolder {

    public static void main(String[] args) {
        // Example usage
        DeleteDuplicateFolder ddf = new DeleteDuplicateFolder();
        List<List<String>> paths = List.of(
            List.of("a", "b", "c"),
            List.of("a", "b", "c"),
            List.of("a", "d")
        );
        System.out.println(ddf.deleteDuplicateFolder(paths));
        // Expected output: [["a","b","c"],["a","d"]]
    }
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        
        return null;    
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        this.children = new TrieNode[26]; // Assuming lowercase letters a-z
        this.isEndOfWord = false;
    }
}
