package com.algorithm.contest.weeklycontest190;

public class MaxDotProduct {
    public static void main(String[] args) {
        MaxDotProduct m = new MaxDotProduct();

        int nums11[] = new int[] { 2, 1, -2, 5 }, nums12[] = new int[] { 3, 0, -6 };
        System.out.println(m.maxDotProduct(nums11, nums12));
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int xy = nums1[i] * nums2[j];
                dp[i][j] = xy;
                if (i > 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i][j]);
                }
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + xy);
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
