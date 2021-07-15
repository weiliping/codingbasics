package com.algorithm.dp;

public class SubsetSum {

    public static void main(String[] args) {
        System.out.println(canPartition(new int[] {1, 2, 3, 7}, 6));
        System.out.println(canPartition(new int[] {1, 3, 4, 8}, 6));
    }

    public static boolean canPartition(int[] nums, int sum) {
        boolean dp[] = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                dp[j] |= dp[j - nums[i]];
            }
        }
        return dp[sum];
    }
}
