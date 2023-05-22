package com.algorithm.dynamicprogramming;

import java.util.Arrays;

public class UniquePath {

    /**
     * #62
     * https://leetcode-cn.com/problems/unique-paths
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(uniqueSingle(7, 3));
        System.out.println(new UniquePath().uniquePaths(7, 3));
    }

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 1);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int uniqueSingle(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
