package com.algorithm.dynamicprogramming;

import java.util.Arrays;

public class LengthOfLIS {

    /**
     * #300
     * https://leetcode-cn.com/problems/longest-increasing-subsequence/
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[] { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}