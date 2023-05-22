package com.algorithm.dynamicprogramming;

public class UniquePathsII {

    /**
     * #63
     * https://leetcode-cn.com/problems/unique-paths-ii/
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] grid = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        System.out.println(uniquePathsWithObstacles(grid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int r = obstacleGrid.length, c = obstacleGrid[0].length;

        int[][] dp = new int[r + 1][c + 1];
        dp[0][1] = 1;

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (obstacleGrid[i - 1][j - 1] != 0) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[r][c];
    }
}
