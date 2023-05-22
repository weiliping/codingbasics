package com.datastructure.day5;

import java.util.Arrays;

public class ValidSudoku {

    public static void main(String[] args) {
        int[][] nums = new int[9][9];
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                nums[i - 1][j - 1] = j;
            }
        }
//        for (int i = 0; i < 9; i++) {
//            System.out.println(Arrays.toString(nums[i]));
//        }
//
//        for (int j = 0; j < 9; j++) {
//            int[] col = new int[9];
//            for (int i = 0; i < 9; i++) {
//                col[i] = nums[i][j];
//            }
//            System.out.println(Arrays.toString(col));
//        }

        for (int i = 0; i < 9; i+=3 ) {
            for (int j = 0; j < 9; j+=3) {
                int[] area = new int[9];
                for (int k = 0; k < 9; k++) {
                    area[k] = nums[i + k /3][j + k % 3];
                }

            }

        }
    }
    public static boolean isValidSudoku(char[][] board) {
        if (board == null || board[0] == null) {
            return false;
        }
        boolean[] visited = new boolean[9];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(visited, false);
            for (int j = 0; j < 9; j++) {
                if(!isValid(visited, board[i][j])) {
                    return false;
                }
            }
        }

        for (int j = 0; j < 9; j++) {
            Arrays.fill(visited, false);
            for (int i = 0; i < 9; i++) {
                if (!isValid(visited, board[i][j])) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Arrays.fill(visited, false);
                for (int k = 0; k < 9; k++) {
                    if (!isValid(visited, board[i + k / 3][j + k % 3])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean isValid(boolean[] visited, char c) {
        if (c == '.') {
            return true;
        }
        int ind = c - '1';
        if (ind > 8 || ind < 0 || visited[ind]) {
            return false;
        }
        visited[ind] = true;
        return true;
    }
}
