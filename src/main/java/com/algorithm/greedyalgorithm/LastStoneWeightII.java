package com.algorithm.greedyalgorithm;

public class LastStoneWeightII {

    public static void main(String[] args) {
        LastStoneWeightII l = new LastStoneWeightII();
        System.out.println(l.lastStoneWeightII(new int[] { 2, 7, 4, 1, 8, 1 }));
//        System.out.println(l.lastStoneWeightI(new int[] { 2, 7, 4, 1, 8, 1 }));
//        System.out.println(l.lastStoneWeightII(new int[] { 2, 7, 4, 1, 8, 1 }));
//        System.out.println(l.lastStoneWeightII(new int[] { 31, 26, 33, 21, 40 }));
//        System.out.println(l.lastStoneWeightII(new int[] { 1, 2 }));
    }
    public int lastStoneWeightI(int[] stones) {
        int sum = 0;
        for (int weight : stones) {
            sum += weight;
        }
        int m = sum / 2;
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int weight : stones) {
            for (int j = m; j >= weight; --j) {
                dp[j] = dp[j] || dp[j - weight];
            }
        }
        for (int j = m;; --j) {
            if (dp[j]) {
                return sum - 2 * j;
            }
        }
    }
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int s : stones) {
            sum += s;
        }
        int m = sum / 2;
        int[] dp = new int[m + 1];
        for (int j = 0; j < n; j++) {
            for (int i = m; i >= stones[j]; i--) {
                dp[i] = Math.max(dp[i], dp[i - stones[j]] + stones[j]);
            }
        }
        return sum - 2 * dp[m];
    }
}
