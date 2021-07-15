package com.algorithm.dp;

public class Largest1BorderedSquare {

    public static void main(String[] args) {
        int[][] grid = new int[][] {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}} ;
        System.out.println(largest1BorderedSquare(grid));
    }

    public static int largest1BorderedSquare(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int rLen = grid.length, cLen = grid[0].length;
        int[][][] dp = new int[rLen + 1][cLen + 1][2];

        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                if (grid[i][j] == 1) {
                    dp[i + 1][j + 1][0] = 1 + dp[i + 1][j][0];
                    dp[i + 1][j + 1][1] = 1 + dp[i][j + 1][1];
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= rLen; i++) {
            for (int j = 1; j <= cLen; j++) {
                for (int side = Math.min(dp[i][j][0], dp[i][j][1]); side >= 1; side--) {
                    if (dp[i][j - side + 1][1] >= side && dp[i - side + 1][j][0] >= side) {
                        res = Math.max(res, side);
                        break;
                    }
                }
            }
        }
        return res * res;
    }
}
