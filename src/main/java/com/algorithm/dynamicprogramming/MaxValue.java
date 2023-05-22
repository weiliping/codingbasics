package com.algorithm.dynamicprogramming;

public class MaxValue {

    /**
     * #
     * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
     * @param args
     */
    public static void main(String[] args) {
        int[][] grid = new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        System.out.println(maxValue(grid));
    }

    public static int maxValue(int[][] grid) {
        if (grid == null || grid[0] == null) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int r = i + 1 < m ? dp[i + 1][j] : 0;
                int d = j + 1 < n ? dp[i][j + 1] : 0;
                dp[i][j] = grid[i][j] + Math.max(r, d);
            }
        }

        return dp[0][0];
    }
}
