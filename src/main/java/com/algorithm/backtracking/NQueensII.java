package com.algorithm.backtracking;

public class NQueensII {

    /**
     * #52
     * https://leetcode-cn.com/problems/n-queens-ii
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solveQueens(4));
    }

    public static int solveQueens(int n) {
        if (n < 1) {
            return 0;
        }
        int[] res = new int[1];
        int[] c = new int[n];
        queens(c, 0, n, res);
        return res[0];
    }

    static boolean isOK(int[] c, int row, int col) {
        for (int r = row - 1; r >= 0; r--) {
            if (c[r] == col || Math.abs(r - row) == Math.abs(c[r] - col)) {
                return false;
            }
        }
        return true;
    }

    static void queens(int[] c, int row, int n, int[] res) {
        if (row == n) {
            res[0]++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isOK(c, row, col)) {
                c[row] = col;
                queens(c, row + 1, n, res);
            }
        }
    }
}
