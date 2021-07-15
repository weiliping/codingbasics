package com.algorithm.selfpractice;

import java.util.Arrays;

public class Knapsack {
    public static void main(String args[]) {
//        int w = 10, n = 4, wt[] = { 5, 4, 6, 3 }, val[] = { 10, 40, 30, 50 };
//        System.out.println(knapsackSimpleDp(w, wt, val, n));
//
//        System.out.println(coinChange(11, new int[] {1, 2, 5}));
//        int grid[][] = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
//        System.out.println(minPathSum(grid));
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("aasdfasdf", "aasdf.*asdf"));
        System.out.println(isMatch("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s"));
    }

    public static boolean isMatchSelf(String s, String p) {
        if (s.isEmpty() || p.isEmpty()) {
            return s.isEmpty() ? p.isEmpty() : s.isEmpty();
        }

        boolean isFirstMatch = s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';

        if (p.length() > 1 && p.charAt(1) == '*') {
            if (isFirstMatch) {
                return isMatchSelf(s.substring(1), p) || isMatchSelf(s.substring(1), p.substring(2));
            }
            return isMatchSelf(s, p.substring(2));
        }
        return isFirstMatch && isMatchSelf(s.substring(1), p.substring(1));
    }

//    public static boolean isMatchDpSelf(String s, String p) {
//
//    }

    static int knapsack(int w, int wt[], int val[], int n) {
        if (w == 0 || n == 0) {
            return 0;
        }

        if (wt[n - 1] > w) {
            return knapsack(w, wt, val, n - 1);
        }

        int preWeight = knapsack(w, wt, val, n - 1);

        return Math.max(knapsack(w - wt[n - 1], wt, val, n - 1) + val[n - 1], preWeight);
    }

    static int knapsackDp(int w, int wt[], int val[], int n) {
        if (w == 0 || n == 0) {
            return 0;
        }

        int dp[][] = new int[n + 1][w + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (j > wt[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][w];
    }

    static int knapsackSimpleDp(int w, int wt[], int val[], int n) {
        if (w == 0 || n == 0) {
            return 0;
        }
        int dp[] = new int[w + 1];
        for (int i = 0; i < n; i++) {
            for (int j = w; j > wt[i]; j--) {
                dp[j] = Math.max(dp[j - 1], dp[j - wt[i]] + val[i]);
            }
        }
        return dp[w];
    }

//    static int coinChange(int amount, int coins[]) {
//        if (coins == null || amount == 0) {
//            return 0;
//        }
//
//        int dp[] = new int[amount + 1];
//        Arrays.fill(dp,amount + 1);
//        dp[0] = 0;
//        for (int i = 0; i < coins.length; i++) {
//            for (int j = 0; j <= amount; j++) {
//                if (j >= coins[i]) {
//                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
//                }
//            }
//        }
//        return dp[amount];
//    }

    static int minPathSum(int grid[][]) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int r = grid.length, c = grid[0].length;

        int dp[][] = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < r; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[r - 1][c - 1];
    }

    static int maxProduct(int nums[]) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length, minP[] = new int[n], maxP[] = new int[n];

        int res = Integer.MIN_VALUE;
        minP[0] = nums[0];
        maxP[0] = nums[0];
        for (int i = 1; i < n; i++) {
            maxP[i] = Math.max(Math.max(maxP[i - 1] * nums[i], nums[i]), minP[i - 1] * nums[i]);
            minP[i] = Math.min(Math.min(maxP[i - 1] * nums[i], nums[i]), minP[i - 1] * nums[i]);
            res = Math.max(res, maxP[i]);
        }
        return res;
    }

    static boolean isMatch(String s, String p) {
        if (s == null || "".equals(s)) {
            return s == null ? p == null : s.equals(p);
        }

        if (p == null || "".equals(p)) {
            return p == null ? s == null : p.equals(s);
        }

        boolean isFirstMatch = s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';

        if (p.length() > 1 && p.charAt(1) == '*') {
            if (isFirstMatch) {
                return isMatch(s.substring(1), p) || isMatch(s.substring(1), p.substring(2)) || isMatch(s, p.substring(2));
            }
            return isMatch(s, p.substring(2));
        }

        return isFirstMatch && isMatch(s.substring(1), p.substring(1));
    }

    static boolean isMatchDp(String s, String p) {
        if (s == null || "".equals(s)) {
            return s == null ? p == null : s.equals(p);
        }
        if (p == null || "".equals(p)) {
            return p == null ? s == null : p.equals(s);
        }

        int m = s.length(), n = p.length();
        boolean dp[][] = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int j = 0; j < n; j++) {
            if (p.charAt(j) == '*') {
                dp[0][j + 1] = dp[0][j - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }

                if (p.charAt(j) == '*') {
                    if (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                        dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j] || dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    static int coinChange(int amount, int coins[]) {
        if (coins == null || amount == 0) {
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
