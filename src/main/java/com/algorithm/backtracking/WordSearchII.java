package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

    public static void main(String[] args) {
        char[][] board = new char[][] {
                { 'o', 'a', 'a', 'n' },
                { 'e', 't', 'a', 'e' },
                { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' }
        };
        String[] words = new String[] { "oath", "pea", "eat", "rain" };
        System.out.println(Arrays.toString(findWords(board, words).toArray()));
        System.out.println(Arrays.toString(findWordsII(board, words).toArray()));

        char[][] board1 = new char[][] { { 'a' } };
        String[] words1 = new String[] { "a" };
        System.out.println(Arrays.toString(findWords(board1, words1).toArray()));
        System.out.println(Arrays.toString(findWordsII(board1, words1).toArray()));

        char[][] board2 = new char[][] {
                { 'o', 'a', 'b', 'n' },
                { 'o', 't', 'a', 'e' },
                { 'a', 'h', 'k', 'r' },
                { 'a', 'f', 'l', 'v' }
        };
        String[] words2 = new String[] { "oa","oaa" };
        System.out.println(Arrays.toString(findWords(board2, words2).toArray()));
        System.out.println(Arrays.toString(findWordsII(board2, words2).toArray()));

        char[][] board3 = new char[][] {
                { 'a', 'b', 'c', 'e' }, { 'x', 'x', 'c', 'd' }, { 'x', 'x', 'b', 'a' }
        };
        String[] words3 = new String[] { "abc", "abcd" };
        System.out.println(Arrays.toString(findWords(board3, words3).toArray()));
        System.out.println(Arrays.toString(findWordsII(board3, words3).toArray()));

        char[][] board4 = new char[][] {
                {'o', 'a', 'a', 'n' },
                { 'e', 't', 'a', 'e' },
                { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' }
        };
        String[] words4 = new String[] { "oath","pea","eat","rain","hklf", "hf"};
        System.out.println(Arrays.toString(findWords(board4, words4).toArray()));
        System.out.println(Arrays.toString(findWordsII(board4, words4).toArray()));
    }

    public static List<String> findWordsII(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        for (String word : words) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (dfsHelperII(board, i, j, word.toCharArray(), 0)) {
                        res.add(word);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    static boolean dfsHelperII(char[][] board, int i, int j, char[] word, int ind) {
        if (ind == word.length) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[ind]) {
            return false;
        }

        char tmp = board[i][j];
        board[i][j] = '#';

        int nextInd = ind + 1;
        if (dfsHelperII(board, i - 1, j, word, nextInd) ||
            dfsHelperII(board, i + 1, j, word, nextInd) ||
            dfsHelperII(board, i, j - 1, word, nextInd) ||
            dfsHelperII(board, i, j + 1, word, nextInd)) {
            board[i][j] = tmp;
            return true;
        }

        board[i][j] = tmp;
        return false;
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        int m = board.length, n = board[0].length;
        TrieNode p = buildTrie(words);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, p, res);
            }
        }
        return res;
    }

    static void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.childs[c - 'a'] == null) {
            return;
        }

        p = p.childs[c - 'a'];

        if (p.word != null) {
            res.add(p.word);
            p.word = null;
        }
        board[i][j] = '#';
        if (i > 0) {
            dfs(board, i - 1, j, p, res);
        }
        if (i < board.length - 1) {
            dfs(board, i + 1, j, p, res);
        }
        if (j > 0) {
            dfs(board, i, j - 1, p, res);
        }
        if (j < board[0].length - 1) {
            dfs(board, i, j + 1, p, res);
        }
        board[i][j] = c;
    }

    static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode p = root;
            for (Character c : word.toCharArray()) {
                int ind = c - 'a';
                if (p.childs[ind] == null) {
                    p.childs[ind] = new TrieNode();
                }
                p = p.childs[ind];
            }
            p.word = word;
        }
        return root;
    }
}

class TrieNode {
    String word;
    TrieNode[] childs = new TrieNode[26];
}