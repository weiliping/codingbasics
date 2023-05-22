package com.algorithm.dynamicprogramming;

public class MinPathSum {

    /**
     * #64
     * https://leetcode-cn.com/problems/minimum-path-sum/
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] grid = new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return 0;
        }

        int r = grid.length, c = grid[0].length;
        int[][] dp = new int[r][c];

        dp[0][0] = grid[0][0];

        for (int i = 1; i < r; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        for (int j = 1; j < c; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[r - 1][c - 1];
    }
}
