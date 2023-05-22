package com.algorithm.contest.weeklycontest162;

public class OddCells {

    public int oddCells(int m, int n, int[][] indices) {
        int[][] dp = new int[m][n];
        for (int[] ind : indices) {
            int r = ind[0], c = ind[1];
            for (int j = 0; j < n; j++) {
                dp[r][j] ^= 1;
            }
            for (int i = 0; i < m; i++) {
                dp[i][c] ^= 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans += dp[i][j];
            }
        }
        return ans;
    }
}
