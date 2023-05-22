package com.algorithm.contest.weeklycontest158;

import java.util.Arrays;

public class DieSimulator {
    public static void main(String[] args) {
//        System.out.println(dieSimulator(2, new int[]{1, 1, 2, 2, 2, 3}));
//        System.out.println(dieSimulator(2, new int[]{1, 1, 1, 1, 1, 1}));
//        System.out.println(dieSimulator(3, new int[]{1, 1, 1, 2, 2, 3}));
//        System.out.println(dieSimulator(4, new int[]{2, 1, 1, 3, 3, 2}));
        System.out.println(dieSimulator(30, new int[]{2,3,1,2,1,2})); //753152086
    }
    static final int MOD = (int) 1e9 + 7;
    public static int dieSimulator(int n, int[] rollMax) {
        int[][] dp = new int[n][6];
        Arrays.fill(dp[0], 1);
        int preSum = 6;
        for (int i = 1; i < n; i++) {
            int currSum = 0;
            for (int j = 0; j < 6; j++) {
                dp[i][j] = preSum;
                if (i == rollMax[j]) {
                    dp[i][j]--;
                } else if (i > rollMax[j]){
                    for (int k = 0; k < 6; k++) {
                        if (j != k) {
                            dp[i][j] = (dp[i][j] - dp[i - rollMax[j] - 1][k] + MOD) % MOD;
                        }
                    }
                }
                currSum = (currSum + dp[i][j]) % MOD;
            }
            preSum = currSum;
        }
        return preSum;
    }
}
