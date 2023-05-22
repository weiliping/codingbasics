package com.algorithm.dynamicprogramming;

public class CanPartition {

    /**
     * #416
     * https://leetcode-cn.com/problems/partition-equal-subset-sum/
     * @param args
     */
    public static void main(String[] args) {
//        System.out.println(canPartition(new int[] {1, 5, 11, 5}));
        System.out.println(canPartition(new int[]{1, 3, 4, 5, 7, 9, 11}));
//        System.out.println(canPartition(new int[] {1, 2, 3, 5}));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];

        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] |= dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
