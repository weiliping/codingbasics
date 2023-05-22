package com.algorithm.dp;

public class Knapsack {

    public static void main(String args[]) {
        int w = 10;
        int n = 4;
        int[] val = {10, 40, 30, 50};
        int[] wt = {5, 4, 6, 3};

//        System.out.println(knapsack(w, wt, val, n));
//        System.out.println(knapsackDp(w, wt, val, n));
        System.out.println(knapsackDpSimple(w, wt, val, n));
    }

    static int knapsack(int w, int wt[], int val[], int n) {
        if (n == 0 || w == 0) {
            return 0;
        }

        if (wt[n - 1] > w) {
            return knapsack(w, wt, val, n - 1);
        }
        int preWeight = knapsack(w, wt, val, n -1);
        return Math.max(val[n - 1] + knapsack(w - wt[n - 1], wt, val, n - 1), preWeight);
    }

    static int knapsackDp(int w, int wt[], int val[], int n) {
        int k[][] = new int[n + 1][w + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0 || j == 0) {
                    k[i][j] = 0;
                } else if (wt[i - 1] <= j) {
                    k[i][j] = Math.max(k[i - 1][j], k[i - 1][j - wt[i - 1]] + val[i - 1]);
                } else {
                    k[i][j] = k[i - 1][j];
                }
            }
        }
        return k[n][w];
    }

    static int knapsackDpSimple(int w, int wt[], int val[], int n) {
        int k[] = new int[w + 1];
        for (int i = 0; i < n; i++) {
            for (int j = w; j >= wt[i]; --j) {
                k[j] = Math.max(k[j], k[j - wt[i]] + val[i]);
            }
        }
        return k[w];
    }
}
