package com.algorithm.contest.weeklycontest215;

import java.util.Arrays;

public class MinOperations {

    public static void main(String[] args) {
        MinOperations m = new MinOperations();
//        System.out.println(m.minOperations(new int[] { 1, 1, 4, 2, 3 }, 5));
//        System.out.println(m.minOperations(new int[] { 5, 6, 7, 8, 9 }, 4));
//        System.out.println(m.minOperations(new int[] { 3, 2, 20, 1, 1, 3 }, 10));
        System.out.println(m.minOperations(new int[] { 8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309 }, 134365));
    }

    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum - x;
        if (target < 0) {
            return -1;
        }
        int left = 0, right = 0, n = nums.length, subSum = 0, maxLen = -1;
        while (right < n) {
            subSum += nums[right];

            while (subSum > target) {
                subSum -= nums[left];
                left++;
            }

            if (subSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
        }

        if (maxLen == -1) {
            return -1;
        }
        return n - maxLen;
    }

    public int minOperationsSelf(int[] nums, int x) {
        int n = nums.length;
        int[][] dp = new int[n][x + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        int m = dfs(nums, 0, nums.length - 1, 0, x, dp);
        if (m == Integer.MAX_VALUE) {
            return -1;
        }
        return m;
    }

    int dfs(int[] nums, int l, int r, int level, int sum, int[][] dp) {
        if (sum == 0) {
            return level;
        }
        if (sum < 0 || l > r) {
            return Integer.MAX_VALUE;
        }
        if (dp[level][sum] != -1) {
            return dp[level][sum];
        }
        int left = dfs(nums, l + 1, r, level + 1, sum - nums[l], dp);
        int right = dfs(nums, l, r - 1, level + 1, sum - nums[r], dp);
        dp[level][sum] = Math.min(left, right);
        return dp[level][sum];
    }
}
