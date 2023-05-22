package com.algorithm.contest.weeklycontest325;

public class CountPartitions {

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4 };
        int k = 4;
        System.out.println(countPartitions(nums, k));
    }

    public static final int MOD = (int) 1e9 + 7;

    public static int countPartitions(int[] nums, int k) {
        long sum = 0l;
        for (int num : nums) {
            sum += num;
        }
        if (sum < (k << 1)) {
            return 0;
        }

        int ans = 1;
        int[] dp = new int[k];
        dp[0] = 1;
        for (int num : nums) {
            ans = (ans << 1) % MOD;
            for (int j = k - 1; j >= num; j--) {
                dp[j] = (dp[j] + dp[j - num]) % MOD;
            }
        }
        for (int d : dp) {
            ans = (ans - (d << 1) % MOD + MOD) % MOD;
        }
        return ans;
    }
}
