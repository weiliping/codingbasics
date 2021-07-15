package com.algorithm.hashing;

import java.util.Arrays;
import java.util.HashSet;

public class ValidSudoku {
    /**
     * #36
     * https://leetcode-cn.com/problems/valid-sudoku
     *
     * @param args
     */
    public static void main(String[] args) {
        char[][] board = new char[][] {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        System.out.println(new ValidSudoku().isValidSudokuII(board));
    }

    public boolean isValidSudokuII(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        boolean[] visited = new boolean[9];
        int m = 9, n = 9;

        for (int i = 0; i < m; i++) {
            Arrays.fill(visited, false);
            for (int j = 0; j < n; j++) {
                if (!precess(visited, board[i][j])) {
                    return false;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(visited, false);
            for (int j = 0; j < m; j++) {
                if (!precess(visited, board[j][i])) {
                    return false;
                }
            }
        }

        for (int i = 0; i < m; i += 3) {
            for (int j = 0; j < n; j += 3) {
                Arrays.fill(visited, false);
                for (int k = 0; k < 9; k++) {
                    if (!precess(visited, board[i + k / 3][j + k % 3])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean precess(boolean[] visited, char c) {
        if (c == '.') {
            return true;
        }
        int num = c - '0';
        if (num > 9 || num < 1 || visited[num - 1]) {
            return false;
        }
        visited[num - 1] = true;
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (invalidRow(board[i]) || invalidColumn(board, j, n) || invalidArea(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean invalidRow(char[] chars) {
        HashSet<Character> s = new HashSet<>();
        for (char c : chars) {
            if (!isUniqueChar(c, s)) {
                System.out.println("invalidRow " + c);
                return true;
            }
        }
        return false;
    }

    static boolean invalidColumn(char[][] borard, int col, int n) {
        HashSet<Character> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!isUniqueChar(borard[i][col], s)) {
                System.out.println("invalidColumn " + borard[i][col]);
                return true;
            }
        }
        return false;
    }

    static boolean invalidArea(char[][] borard, int i, int j) {
        HashSet<Character> s = new HashSet<>();
        int k = (i / 3) * 3, l = (j / 3) * 3;
        for (int x = k; x < k + 3; x++) {
            for (int y = l; y < l + 3; y++) {
                if (!isUniqueChar(borard[x][y], s)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isUniqueChar(char ch, HashSet<Character> s) {
        if (ch != '.') {
            return s.add(ch);
        }
        return true;
    }
}
