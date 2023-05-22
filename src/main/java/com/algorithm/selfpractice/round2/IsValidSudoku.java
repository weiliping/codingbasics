package com.algorithm.selfpractice.round2;

public class IsValidSudoku {
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

        System.out.println(new IsValidSudoku().isValid(board));
    }

    public boolean isValid(char[][] board) {
        if (board == null || board.length != 9 || board[0] == null || board[0].length != 9) {
            return false;
        }

        for (int r = 0; r < 9; r++) {
            if (!isValidRow(board, r)) {
                return false;
            }
        }

        for (int c = 0; c < 9; c++) {
            if (!isValidColumn(board, c)) {
                return false;
            }
        }

        for (int r = 0; r < 9; r = r + 3) {
            for (int c = 0; c < 9; c = c + 3) {
                if (!isValidSection(board, r, c)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isValidRow(char[][] board, int r) {
        boolean[] unqiues = new boolean[9];
        for (int c = 0; c < 9; c++) {
            if (!isValid(board, r, c, unqiues)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidColumn(char[][] board, int c) {
        boolean[] unqiues = new boolean[9];
        for (int r = 0; r < 9; r++) {
            if (!isValid(board, r, c, unqiues)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidSection(char[][] board, int r, int c) {
        int rs = r/3*3, re = rs + 3;
        int cs = c/3*3, ce = cs + 3;
        boolean[] unqiues = new boolean[9];
        for (int i = rs; i < re; i++) {
            for (int j = cs; j < ce; j++) {
                if (!isValid(board, i, j, unqiues)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(char[][] board, int r, int c, boolean[] uniques) {
        char ch = board[r][c];
        if (ch == '.') {
            return true;
        }
        int idx = ch - '1';
        if (idx < 9 && idx >= 0 && !uniques[idx]) {
            uniques[idx] = true;
            return true;
        }
        return false;
    }
}
