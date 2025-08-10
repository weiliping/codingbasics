package com.algorithm.contest.weeklycontest441;

import java.util.Arrays;

public class MinZeroArray {

    public static void main(String[] args) {
        
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }
        boolean[][][] dp = new boolean[m + 1][n][max + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= max; j++) {
                dp[i][j][0] = true;    
            }
        }
        
        for (int k = 1; k <= m; k++) {
            int i = k - 1;
            int l = queries[i][0];
            int r = queries[i][1];
            int v = queries[i][2];
            boolean isValid = true;
            for (int s = 0; s < n; s++) {
                for (int j = 1; j <= nums[s]; j++) {
                    if (s < l || s > r) {
                        dp[s][k][j] = dp[s][k - 1][j];
                        continue;
                    }
                    if (j >= v) {
                        dp[k][s][j] = dp[k - 1][s][j] || dp[k - 1][s][j - v];
                    } else {
                        dp[k][s][j] = dp[k - 1][s][j];     
                    }
                }
                if (!dp[k][s][nums[i]]) {
                    isValid = false;
                }
            }
            if (isValid) {
                return k;
            }
        }
        return -1;
    }
}
