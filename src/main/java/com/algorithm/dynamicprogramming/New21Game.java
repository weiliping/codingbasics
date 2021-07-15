package com.algorithm.dynamicprogramming;

public class New21Game {

    /**
     * #837
     * https://leetcode-cn.com/problems/new-21-game
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new21Game(21, 17, 10));
    }

    public static double new21Game(int N, int K, int W) {
        if (K == 0) {
            return 1.0;
        }
        double[] dp = new double[K + W];
        for (int i = K; i <= N && i < K + W; i++) {
            dp[i] = 1.0;
        }
        dp[K - 1] = 1.0 * Math.min(N - K + 1, W) / W;
        for (int i = K - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] - (dp[i + W + 1] - dp[i + 1]) / W;
        }
        return dp[0];
    }
}
