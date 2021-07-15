package com.algorithm.contest.weeklycontest229;

public class MultiplicationOperations {

    static final int MOD = (int) 1e9 + 7;
    public static void main(String[] args) {
        int nums1[] = new int[] { -5, -3, -3, -2, 7, 1 }, mul1[] = new int[] { -10, -5, 3, 4, 6 };
        System.out.println(maximumScore(nums1, mul1));
        int nums2[] = new int[] { 1, 2, 3 }, mul2[] = new int[] { 3, 2, 1 };
        System.out.println(maximumScore(nums2, mul2));
    }

    public static int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length, m = multipliers.length;
        int l = 0, r = n - 1, k = 0;
        Integer dp[][] = new Integer[m][m];
        return dfs(nums, multipliers, l, r, k, m, dp);
    }

    static Integer dfs(int[] nums, int[] multipliers, int l, int r, int k, int len, Integer dp[][]) {
        if (len == 0) {
            return 0;
        }
        if (dp[l][k] == null) {
            Integer lSum = nums[l] * multipliers[k] + dfs(nums, multipliers, l + 1, r, k + 1, len - 1, dp);
            Integer rSum = nums[r] * multipliers[k] + dfs(nums, multipliers, l, r - 1, k + 1, len - 1, dp);
            dp[l][k] = Math.max(lSum, rSum);
        }
        return dp[l][k];
    }
}
