package com.algorithm.contest.weeklycontest213;

public class KthSmallestPath {
    public static void main(String[] args) {
        KthSmallestPath k = new KthSmallestPath();
        System.out.println(k.kthSmallestPath(new int[]{4, 5}, 66));
    }
    public String kthSmallestPath(int[] destination, int k) {
        int m = destination[1], n = destination[0];
        int[][] dp = new int[m][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            int sum = 0;
            for (int j = 0; j <= n; j++) {
                sum += dp[i - 1][j];
                dp[i][j] = sum;
            }
        }

        StringBuilder ret = new StringBuilder(m + n);
        for (int x = m - 1, y = n; 0 <= x && 0 <= y; ) {
            if (dp[x][y] < k) {
                k -= dp[x][y--];
                ret.append('V');
            } else {
                --x;
                ret.append('H');
            }
        }
        for (int i = ret.length(); i < m + n; ++i) {
            ret.append('V');
        }
        return ret.toString();
    }
}
