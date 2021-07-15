package com.datastructure.day2;

public class Knapsack {

    public static void main(String args[]) {
        int w = 10;
        int n = 4;
        int[] val = {10, 40, 30, 50};
        int[] wt = {5, 4, 6, 3};
        System.out.println(knapsackDpSimple(w, wt, val, n));
    }

    static int knapsack(int w, int wt[], int val[], int n) {
        if (w == 0 || n == 0) {
            return 0;
        }
        if (wt[n - 1] > w) {
            return knapsack(w, wt, val, n - 1);
        }
        int preVal = knapsack(w, wt, val, n - 1);
        return Math.max(knapsack(w - wt[n - 1], wt, val, n - 1) + val[n - 1], preVal);
    }

    static int knapsackDp(int w, int wt[], int val[], int n) {
        if (w == 0 || n == 0) {
            return 0;
        }

        int dp[][] = new int[n + 1][w + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0 || j == 0) {
                    continue;
                }
                if (j > wt[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][w];
    }


    static int knapsackDpSimple(int w, int wt[], int val[], int n) {
        if (w == 0 || n == 0) {
            return 0;
        }

        int dp[] = new int[w + 1];
        for (int i = 0; i < n; i++) {
            for (int j = w; j >= wt[i]; j--) {
                dp[j] = Math.max(dp[j - 1], dp[j - wt[i]] + val[i]);
            }
        }
        return dp[w];
    }
}
