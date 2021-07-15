package com.algorithm.dynamicprogramming;

public class StoneGameII {

    /**
     * #1140
     * https://leetcode-cn.com/problems/stone-game-ii/
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(stoneGameII(new int[] { 2, 7, 9, 4, 4 }));
    }

    public static int stoneGameII(int[] piles) {
        if (piles == null || piles.length == 0) {
            return 0;
        }
        int n = piles.length;
        int[][] dp = new int[n + 1][n + 1];
        int sum = 0;
        for (int i = n - 1; i > -1; i--) {
            sum += piles[i];

            for (int m = 1; m <= n; m++) {
                if (i + 2 * m >= n) {
                    dp[i][m] = sum;
                    continue;
                }
                for (int x = 1; i + x <= n && x <= 2 * m; x++) {
                    dp[i][m] = Math.max(dp[i][m], sum - dp[i + x][Math.max(m, x)]);
                }
            }
        }
        return dp[0][1];
    }
}
