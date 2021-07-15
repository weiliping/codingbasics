package com.algorithm.contest.weeklycontest246;

import java.util.Arrays;

public class MinDifference {

    public static void main(String[] args) {
        MinDifference m = new MinDifference();
        int[] nums = new int[] {1,3,4,8};
        int[][] queries = new int[][] {{0,1},{1,2},{2,3},{0,3}};
        System.out.println(Arrays.toString(m.minDifference(nums, queries)));

        int[] nums1 = new int[] {4,5,2,2,7,10};
        int[][] queries1 = new int[][] {{2,3},{0,2},{0,5},{3,5}};
        System.out.println(Arrays.toString(m.minDifference(nums1, queries1)));
    }

    public int[] minDifference(int[] nums, int[][] queries) {
        int n = nums.length, m = queries.length;
        int[][] dp = new int[n + 1][101];

        for (int i = 1; i <= n; i++) {
            dp[i] = Arrays.copyOf(dp[i - 1], 101);
            dp[i][nums[i - 1]]++;
        }

        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int[] q = queries[i];
            int min = -1, pre = 0;
            for (int j = 1; j < 101; j++) {
                int cur = dp[q[1] + 1][j] - dp[q[0]][j];
                if (cur != 0) {
                    if (pre == 0) {
                        pre = j;
                        continue;
                    }
                    int subMin = Math.abs(pre - j);
                    if (min == -1 || min > subMin) {
                        min = subMin;
                    }
                    pre = j;
                }
            }
            res[i] = min;
        }
        return res;
    }
}
