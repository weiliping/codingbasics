package com.algorithm.dynamicprogramming;

public class ClimbingStair {

    /**
     * #70
     * https://leetcode-cn.com/problems/climbing-stairs/
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(climbingStair(2));
        System.out.println(climbingStair(3));
    }

    public static int climbingStair(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}

