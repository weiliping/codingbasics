package com.algorithm.dp;

public class DeleteAndEarn {
    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[] { 3, 4, 2 }));
        System.out.println(deleteAndEarn(new int[] { 2, 2, 3, 3, 3, 4 }));
        System.out.println(deleteAndEarn(new int[] { 1, 1, 1, 2, 4, 5, 5, 5, 6 }));
        System.out.println(deleteAndEarn(new int[] { 3, 7, 10, 5, 2, 4, 8, 9, 9, 4, 9, 2, 6, 4, 6, 5, 4, 7, 6, 10 }));
    }

    public static int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            max = Math.max(i, max);
        }
        int[] all = new int[max + 1], dp = new int[max + 1];

        for(int i = 0; i < n; i++) {
            all[nums[i]]++;
        }

        dp[1] = all[1];
        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + all[i] * i);
        }
        return dp[max];
    }
}
