package com.algorithm.dp;

import java.util.Arrays;

public class MinSubsetSumDifference {

    public static void main(String[] args) {
        System.out.println(minSumDiff(new int[] {1, 3, 5, 7, 9, 10}));
    }

    public static int minSumDiff(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int[][] dp = new int[nums.length][sum + 1];
        for (int[] r : dp) {
            Arrays.fill(r,-1);
        }
        return sumHelper(nums, 0, 0, 0, dp);
    }

    public static int sumHelper(int[] nums, int ind, int sum1, int sum2, int[][] dp) {
        if (ind == nums.length) {
            return Math.abs(sum1 - sum2);
        }

        if (dp[ind][sum1] == -1) {
            int diff1 = sumHelper(nums, ind + 1, sum1 + nums[ind], sum2, dp);
            int diff2 = sumHelper(nums, ind + 1, sum1, sum2 + nums[ind], dp);
            dp[ind][sum1] = Math.min(diff1, diff2);
        }
        return dp[ind][sum1];
    }
}
