package com.datastructure.day2;

import java.util.Arrays;

public class CoinChange {

    public static void main(String args[]) {
        int coins1[] = {1, 2, 5}, amount1 = 11;
        System.out.println(coinChange(coins1, amount1));
    }

    public static int coinChange(int coins[], int amount) {
        if (amount == 0 || coins == null) {
            return 0;
        }

        int n = coins.length;

        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j >= coins[i]) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount];
    }
}
