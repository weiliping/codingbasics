package com.datastructure.day1;

import java.util.Arrays;

public class LongestSubsequence {

    public static void main(String args[]) {
        int a[] = { 0, 1, 0, 3, 2, 3 };
        System.out.println(longestSubsequence(a));
    }

    public static int longestSubsequence(int a[]) {
        if (a == null || a.length == 0) {
            return 0;
        }

        int n = a.length, dp[] = new int[n], res = 1;
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (a[j] < a[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
