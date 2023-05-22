package com.algorithm.selfpractice.round2;

import java.util.Arrays;

public class SurroundedRegions {

    public static void main(String[] args) {
        char[][] board = new char[][] {{'X', 'X', 'O', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solve(board);
        for (char[] b : board) {
            System.out.println(Arrays.toString(b));
        }
    }

    public static void solve(char[][] board) {
        if (board == null || board[0] == null) {
            return;
        }

        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    dfs(board, i, j, m, n);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '$') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    static void dfs(char[][] board, int i, int j, int m, int n) {
        if (board[i][j] == 'O') {
            board[i][j] = '$';
            if (i > 0 && board[i - 1][j] == 'O') {
                dfs(board, i - 1, j, m, n);
            }

            if (i < m - 1 && board[i + 1][j] == 'O') {
                dfs(board, i + 1, j, m, n);
            }

            if (j > 0 && board[i][j - 1] == 'O') {
                dfs(board, i, j - 1, m, n);
            }

            if (j < n - 1 && board[i][j + 1] == 'O') {
                dfs(board, i, j + 1, m, n);
            }
        }
    }
}
