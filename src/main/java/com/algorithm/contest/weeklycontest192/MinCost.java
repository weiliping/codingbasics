package com.algorithm.contest.weeklycontest192;

import java.util.Arrays;

public class MinCost {
    public static void main(String[] args) {

    }
    private static final int INFINITY = Integer.MAX_VALUE / 2;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {

        for (int i = 0; i < m; i++) {
            houses[i]--;
        }

        int[][][] dp = new int[m][n][target];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], INFINITY);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (houses[i] != -1 && houses[i] != j) {
                    continue;
                }

                for (int k = 0; k < target; k++) {
                    for (int j0 = 0; j0 < n; j0++) {
                        if (j0 == j) {
                            if (i == 0) {
                                if (k == 0) {
                                    dp[i][j][k] = 0;
                                }
                            } else {
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k]);
                            }
                        } else if (i > 0 && k > 0) {
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j0][k - 1]);
                        }
                    }
                    if (dp[i][j][k] != INFINITY && houses[i] == -1) {
                        dp[i][j][k] += cost[i][j];
                    }
                }

            }
        }

        int res = INFINITY;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp[m - 1][j][target - 1]);
        }
        return res == INFINITY ? -1 : res;
    }
}
