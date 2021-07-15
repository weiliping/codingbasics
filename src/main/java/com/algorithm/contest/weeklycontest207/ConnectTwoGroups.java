package com.algorithm.contest.weeklycontest207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConnectTwoGroups {
    public static void main(String[] args) {
        List<List<Integer>> cost = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(15);
        l1.add(96);
        cost.add(l1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(36);
        l2.add(2);
        cost.add(l2);
        System.out.println(connectTwoGroups(cost));
    }

    public static int connectTwoGroups(List<List<Integer>> cost) {
        int n = cost.size(), m = cost.get(0).size(), len = 1 << m;
        int[][] costMatrix = new int[n][len];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < len; j++) {
                int sum = 0;
                for (int k = 0; k < m; k++) {
                    if ((j & (1 << k)) > 0) {
                        sum += cost.get(i).get(k);
                    }
                }
                costMatrix[i][j] = sum;
            }
        }

        int[][] dp = new int[n][len];
        dp[0] = costMatrix[0];
        for (int i = 1; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < len; j++) {
                for (int k = 1; k < len; k++) {
                    dp[i][j | k] = Math.min(dp[i][j | k], dp[i - 1][k] + costMatrix[i][j]);
                }
            }
        }
        return dp[n - 1][len - 1];
    }
}