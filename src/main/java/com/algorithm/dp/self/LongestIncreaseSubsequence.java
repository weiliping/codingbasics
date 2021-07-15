package com.algorithm.dp.self;

import java.util.Arrays;

public class LongestIncreaseSubsequence {

    public static void main(String[] args) {
        int a[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(longestSubsequence(a));
    }

    static int longestSubsequence(int a[]) {
        if (a == null) {
            return 0;
        }
        int n = a.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }
}
