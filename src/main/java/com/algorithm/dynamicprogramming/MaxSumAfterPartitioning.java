package com.algorithm.dynamicprogramming;

public class MaxSumAfterPartitioning {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 15, 7, 9, 2, 5, 10 };
        // int k = 3;
        System.out.println(maxSumAfterPartitioning(arr, 1));
    }

    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int j = i - 1;
            int mx = Integer.MIN_VALUE;
            while (i - j <= k && j >= 0) {
                mx = Math.max(mx, arr[j]);
                dp[i] = Math.max(dp[i], dp[j] + mx * (i - j));
                j--;
            }
        }
        return dp[n];
    }
}
