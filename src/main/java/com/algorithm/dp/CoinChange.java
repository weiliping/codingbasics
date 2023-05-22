package com.algorithm.dp;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
//        int[] coins = new int[] { 186, 419, 83, 408 };
//        int amount = 6249;
//        System.out.println(coinChange(coins, amount));
        int coins1[] = {1, 2, 5}, amount1 = 11;
        System.out.println(coinChange(coins1, amount1));

    }

    static int coinChange(int coins[], int amount) {
        if (coins == null || amount == 0) {
            return 0;
        }

        int dp[] = new int[amount + 1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
