package com.algorithm.selfpractice.round2;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));
    }

    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return false;
        }

        int m = board.length, n = board[0].length;

        boolean[][] dp = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(board, word, 0, i, j, dp)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean search(char[][] board, String word, int idx, int i, int j, boolean[][] dp) {
        if (idx == word.length()) {
            return true;
        }

        int m = board.length, n = board[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || dp[i][j] || board[i][j] != word.charAt(idx)) {
            return false;
        }

        dp[i][j] = true;

        boolean res = search(board, word, idx + 1, i - 1, j, dp) ||
                search(board, word, idx + 1, i + 1, j, dp) ||
                search(board, word, idx + 1, i, j - 1, dp) ||
                search(board, word, idx + 1, i, j + 1, dp);
        dp[i][j] = false;
        return res;
    }
}
