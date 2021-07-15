package com.algorithm.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

    /**
     * #130
     * https://leetcode-cn.com/problems/surrounded-regions
     * @param args
     */
    public static void main(String[] args) {
        char[][] board = new char[][] {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solve(board);
        for (char[] b : board) {
            System.out.println(Arrays.toString(b));
        }

        char[][] boardBfs = new char[][] {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solveBfs(boardBfs);
        for (char[] b : boardBfs) {
            System.out.println(Arrays.toString(b));
        }
    }

    public static void solveBfs(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int rLen = board.length, cLen = board[0].length;
        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                if (i != 0 && j != 0 && i != rLen - 1 && j != cLen - 1) {
                    continue;
                }
                if (board[i][j] != 'O') {
                    continue;
                }
                board[i][j] = '$';
                Queue<Integer> q = new LinkedList<>();
                q.offer(i * cLen + j);

                while (!q.isEmpty()) {
                    int t = q.poll();
                    int x = t / cLen, y = t % cLen;
                    if (x > 0 && board[x - 1][y] == 'O') {
                        board[x - 1][y] = '$';
                        q.offer(t - cLen);
                    }
                    if (y > 0 && board[x][y - 1] == 'O') {
                        board[x - 1][y] = '$';
                        q.offer(t - 1);
                    }
                    if (x < rLen - 1 && board[x + 1][y] == 'O') {
                        board[x + 1][y] = '$';
                        q.offer(t + cLen);
                    }
                    if (y < cLen - 1 && board[x][y + 1] == 'O') {
                        board[x][y + 1] = '$';
                        q.offer(t + 1);
                    }
                }
            }
        }
        replaseO(board, rLen, cLen);
    }

    public static void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int rLen = board.length, cLen = board[0].length;
        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                if (i == 0 || j == 0 || i == rLen - 1 || j == cLen - 1) {
                    dfs(board, i, j, rLen, cLen);
                }
            }
        }
        replaseO(board, rLen, cLen);
    }

    static void replaseO(char[][] board, int rLen, int cLen) {
        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '$') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    static void dfs(char[][] board, int i, int j, int rLen, int cLen) {
        if (board[i][j] == 'O') {
            board[i][j] = '$';
            if (i > 0 && board[i - 1][j] == 'O') {
                dfs(board, i - 1, j, rLen, cLen);
            }
            if (i < rLen - 1 && board[i + 1][j] == 'O') {
                dfs(board, i + 1, j, rLen, cLen);
            }
            if (j > 0 && board[i][j - 1] == 'O') {
                dfs(board, i, j - 1, rLen, cLen);
            }
            if (j < cLen - 1 && board[i][j + 1] == 'O') {
                dfs(board, i, j + 1, rLen, cLen);
            }
        }
    }
}
