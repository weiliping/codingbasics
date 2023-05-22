package com.algorithm.contest.biweeklycontest87;

import java.util.Arrays;

public class SmallestSubarrays {
    public static void main(String[] args) {
//        System.out.println(Integer.parseInt("1111111110", 2));
        int[] nums = new int[] {512, 431, 1022};
        System.out.println(nums[0] | nums[1]);
        System.out.println(nums[0] | nums[1] | nums[2]);
        System.out.println(Arrays.toString(smallestSubarrays(nums)));
    }

    public static int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] dp = new int[32];
        Arrays.fill(dp, -1);
        int[] ans = new int[n];
        for (int i = n-1; i >= 0; i--) {
            int max = 1;
            for (int j = 0; j < 32; j++) {
                if (((nums[i] >> j) & 1) == 1) {
                    dp[j] = i;
                }
                if (dp[j] != -1) {
                    max = Math.max(max, dp[j]-i+1);
                }
            }
            ans[i] = max;
        }
        return ans;
    }
}
