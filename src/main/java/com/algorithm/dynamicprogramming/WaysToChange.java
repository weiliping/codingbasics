package com.algorithm.dynamicprogramming;

public class WaysToChange {

    final static int mod = 1000000007;
    final static int[] coins = new int[] { 25, 10, 5, 1 };

    /**
     * https://leetcode-cn.com/problems/coin-lcci/
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(waysToChange(5));
        System.out.println(waysToChange(10));
        System.out.println(waysToChange(25));
        System.out.println(waysToChangeII(25));
    }

    public static int waysToChangeII(int n) {
        int ans = 0;
        for (int i = 0; i * 25 <= n; i++) {
            int rest = n - i * 25;
            int a = rest / 10;
            int b = rest % 10 / 5;
            long pre = ((long)(a + 1) * (long)(a + b + 1)) % mod;
            ans = (int) ((ans + pre) % mod);
        }
        return ans;
    }

    public static int waysToChange(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < 4; i++) {
            int coin = coins[i];
            for (int j = coin; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - coin]) % mod;
            }
        }
        return dp[n];
    }
}
