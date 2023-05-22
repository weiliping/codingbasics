package com.algorithm.contest.weeklycontest149;

import java.util.Arrays;

public class NumRollsToTarget {

    public static void main(String[] args) {
//        System.out.println(numRollsToTarget(1, 6, 3));
//        System.out.println(numRollsToTarget(2, 6, 7));
//        System.out.println(numRollsToTarget(2, 5, 10));
//        System.out.println(numRollsToTarget(1, 2, 3));
        System.out.println(numRollsToTarget(30, 30, 500));
    }
    public static final int MOD = (int) 1e9 + 7;
    public static int numRollsToTarget(int d, int f, int target) {
        if (target > d * f) {
            return 0;
        }
        int len = d * f + 1;
        int[] dp = new int[len];
        for (int i = 1; i <= f; i++) {
            dp[i] = 1;
        }
        int[] dp2;
        for (int i = 1; i < d; i++) {
            dp2 = new int[len];
            for (int j = 1; j <= f; j++) {
                for (int k = 1; k < len; k++) {
                    if (dp[k] != 0) {
                        int q = k + j;
                        dp2[q] = ((dp2[q] + dp[k]) % MOD);
                        continue;
                    }
                }
            }
            dp = Arrays.copyOf(dp2, len);
        }
        return dp[target];
    }
}
