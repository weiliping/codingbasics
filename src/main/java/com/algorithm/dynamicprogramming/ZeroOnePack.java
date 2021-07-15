package com.algorithm.dynamicprogramming;

public class ZeroOnePack {

    public static void main(String[] args) {
        System.out.println(zeroOnePack(10, new int[]{2, 3, 5, 7}, new int[] {2, 5, 2, 5}));
    }

    public static int zeroOnePack(int v, int[] c, int[] w) {
        if (v <= 0 || c.length != w.length) {
            return 0;
        }
        int n = c.length;

        int[][] dp = new int[n + 1][v + 1];

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= v; j++) {
                dp[i][j] = dp[i - 1][j];
                int subV = c[i - 1];
                if (j >= subV) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - subV] + w[i - 1]);
                }
            }
        }
        return dp[n][v];
    }
}
