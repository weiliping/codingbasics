package com.algorithm.contest.weeklycontest219;

import java.util.Arrays;

public class StoneGameVII {
    public static void main(String[] args) {
        StoneGameVII s = new StoneGameVII();
//        int stones[] = new int[] { 5, 3, 1, 4, 2 };
//        System.out.println(s.stoneGameVII(stones));
//
//        int stones1[] = new int[] { 7, 90, 5, 1, 100, 10, 10, 2 };
//        System.out.println(s.stoneGameVII(stones1));

//        int stones2[] = new int[] { 481, 905, 202, 250, 371, 628, 92, 604, 836, 338, 676, 734 };
//        System.out.println(s.stoneGameVII(stones2)); //3459

        int stones3[] =
                new int[] { 721, 979, 690, 84, 742, 873, 31, 323, 819, 22, 928, 866, 118, 843, 169, 818, 908, 832, 852,
                        480, 763, 715, 875, 629 };
//        System.out.println(s.stoneGameVII(stones3)); //7948
        System.out.println(s.stoneGameVIII(stones3));
    }
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int dp[][] = new int[n][n];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (i + 1 == j) {
                    dp[i][j] = Math.max(stones[i], stones[j]);
                } else {
                    int l = Math.min(stones[i + 1] + dp[i + 2][j], stones[j] + dp[i + 1][j - 1]);
                    int r = Math.min(stones[i] + dp[i + 1][j - 1], stones[j - 1] + dp[i][j - 2]);
                    dp[i][j] = Math.max(l, r);
                }
            }
        }
        return dp[0][n - 1];
    }
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        Integer[][] dp = new Integer[n][n];
        return dfs(stones, 0, n - 1, 0, dp);
    }

    int dfs(int[] stones, int l, int r, int k, Integer[][] dp) {
        if (l == r) {
            return (k & 1) == 0 ? 0 : stones[l];
        }
        if (dp[l][k] == null) {
            if ((k & 1) == 0) {
                int lMin = Math.min(stones[r], stones[l + 1]);
                int rMin = Math.min(stones[l], stones[r - 1]);
                if (lMin > rMin || (lMin == rMin && stones[l] < stones[r])) {
                    System.out.println("A l= " + stones[l] + " k=" + k);
                    return dfs(stones, l + 1, r, k + 1, dp);
                }
                System.out.println("A r= " + stones[r] + " k=" + k);
                return dfs(stones, l, r - 1, k + 1, dp);
            }
            int lSum = stones[l] + dfs(stones, l + 1, r, k + 1, dp);
            int rSum = stones[r] + dfs(stones, l, r - 1, k + 1, dp);
            if (lSum < rSum) {
                System.out.println("B l= " +  stones[l] + " k=" + k);
                dp[l][k] = lSum;
            } else {
                System.out.println("B r= " +  stones[r] + " k=" + k);
                dp[l][k] = rSum;
            }
        }
//        for (Integer[] arr : dp) {
//            System.out.println(Arrays.toString(arr));
//        }
        return dp[l][k];
    }
}
