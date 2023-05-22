package com.algorithm.selfpractice.round3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        int n = coins.length;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
//        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
//        System.out.println(coinChange(new int[]{2}, 3));
        System.out.println(Arrays.toString(generateParenthesis(3).toArray()));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, n, n, "");
        return res;
    }

    static void dfs(List<String> strs, int l, int r, String str) {
        if (r == 0 && l == 0) {
            strs.add(str);
            return;
        }

        if (l > 0) {
            dfs(strs, l - 1, r, str + "(");
        }

        if (l < r) {
            dfs(strs, l, r - 1, str + ")");
        }
    }
}
