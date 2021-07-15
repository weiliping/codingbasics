package com.algorithm.dp;

public class Rob {

    /**
     * #198
     * https://leetcode-cn.com/problems/house-robber/
     *
     * @param args
     */
    public static void main(String[] args) {
        //        System.out.println(rob(new int[] {1, 2, 3, 1}));
        System.out.println(rob(new int[] { 2, 7, 9, 3, 1 }));
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[len];
    }
}
