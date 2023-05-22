package com.algorithm.selfpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
    /**
     * #212
     * https://leetcode-cn.com/problems/word-search-ii/
     *
     * @param args
     */
    public static void main(String[] args) {
        //        char[][] board = new char[][] {
        //                { 'o', 'a', 'a', 'n' },
        //                { 'e', 't', 'a', 'e' },
        //                { 'i', 'h', 'k', 'r' },
        //                { 'i', 'f', 'l', 'v' }
        //        };
        //        String[] words = new String[] { "oath", "pea", "eat", "rain" };

        //        char[][] board = new char[][] { { 'a' } };
        //        String[] words = new String[] { "a" };

//        char[][] board = new char[][] {
//                { 'o', 'a', 'b', 'n' },
//                { 'o', 't', 'a', 'e' },
//                { 'a', 'h', 'k', 'r' },
//                { 'a', 'f', 'l', 'v' }
//        };
//        String[] words = new String[] { "oa","oaa" };
//        char[][] board = new char[][] {
//                { 'a', 'b', 'c', 'e' }, { 'x', 'x', 'c', 'd' }, { 'x', 'x', 'b', 'a' }
//        };
//        String[] words = new String[] { "abc", "abcd" };

        char[][] board = new char[][] {
                {'o', 'a', 'a', 'n' },
                { 'e', 't', 'a', 'e' },
                { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' }
        };
        String[] words = new String[] { "oath","pea","eat","rain","hklf", "hf"};
        WordSearchII ws = new WordSearchII();
        List<String> res = ws.findWords(board, words);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length, n = board[0].length;
        Set<String> res = new HashSet<>();
        boolean[][] visited = new boolean[m][n];
        Trie trie = new Trie('/');
        for (String word : words) {
            trie.put(word);
        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
                List<Character> subRes = new ArrayList<>();
                for (boolean[] v : visited) {
                    Arrays.fill(v, false);
                }
                dfsHelper(board, 2, 1, visited, subRes, res, trie.childs);
//            }
//        }
        return new ArrayList<>(res);
    }

    void dfsHelper(char[][] board, int i, int j, boolean[][] visited, List<Character> subRes, Set<String> res, Trie[] childs) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }
        char c = board[i][j];
        visited[i][j] = true;
        for (Trie t : childs) {
            if (t != null && c == t.ch) {
                subRes.add(c);
                if (t.isEndingChar) {
                    StringBuilder sb = new StringBuilder();
                    for (Character r : subRes) {
                        sb.append(r);
                    }
                    res.add(sb.toString());
//                    subRes.remove(c);
                }
                dfsHelper(board, i - 1, j, visited, subRes, res, t.childs);
                dfsHelper(board, i + 1, j, visited, subRes, res, t.childs);
                dfsHelper(board, i, j - 1, visited, subRes, res, t.childs);
                dfsHelper(board, i, j + 1, visited, subRes, res, t.childs);
            }
        }
        visited[i][j] = false;
    }
}

class Trie {
    char ch;
    Trie[] childs = new Trie[26];
    boolean isEndingChar = false;

    public Trie(char ch) {
        this.ch = ch;
    }

    public Trie(char ch, boolean isEnding) {
        this.ch = ch;
        this.isEndingChar = isEnding;
    }

    public void put(String words) {
        char[] chars = words.toCharArray();
        int i = 0;
        Trie child = null;
        while (i < chars.length) {
            int ind = chars[i] - 'a';
            if (i == 0) {
                if (this.childs[ind] == null) {
                    childs[ind] = new Trie(chars[i], i == chars.length - 1);
                }
                child = this.childs[ind];
                i++;
                continue;
            }
            if (child.childs[ind] == null) {
                child.childs[ind] = new Trie(chars[i], i == chars.length - 1);
            }
            child = child.childs[ind];
            i++;
        }
    }
}
