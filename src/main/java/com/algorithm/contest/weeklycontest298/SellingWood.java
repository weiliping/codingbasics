package com.algorithm.contest.weeklycontest298;

import java.util.Arrays;

public class SellingWood {

    public static void main(String[] args) {
        int m = 3, n = 5, prices[][] = new int[][] { { 1, 4, 2 }, { 2, 2, 7 }, { 2, 1, 3 } };
//        int m1 = 4, n1 = 6, prices1[][] = new int[][] { { 3, 2, 10 }, { 1, 4, 2 }, { 4, 1, 3 } };
        System.out.println(sellingWood(m, n, prices));
        System.out.println(sellingWoodI(m, n, prices));
//        System.out.println(sellingWood(m1, n1, prices1));
        System.out.println(5 >> 1);
    }

    public static long sellingWood(int m, int n, int[][] prices) {
        long[][] cnts = new long[m + 1][n + 1];
        for (long[] cnt : cnts) {
            Arrays.fill(cnt, -1);
        }
        int[][] values = new int[m + 1][n + 1];
        for (int[] price : prices) {
            values[price[0]][price[1]] = price[2];
        }
        dfs(m, n, cnts, values);
        return cnts[m][n];
    }

    static long dfs(int x, int y, long[][] cnts, int[][] values) {
        if (cnts[x][y] != -1) {
            return cnts[x][y];
        }
        long r = values[x][y];
        if (x > 1) {
            for (int i = 1; i < x; i++) {
                r = Math.max(r, dfs(i, y, cnts, values) + dfs(x - i, y, cnts, values));
            }
        }
        if (y > 1) {
            for (int j = 1; j < y; j++) {
                r = Math.max(r, dfs(x, j, cnts, values) + dfs(x, y - j, cnts, values));
            }
        }
        cnts[x][y] = r;
        return cnts[x][y];
    }

    public static long sellingWoodI(int m, int n, int[][] prices) {
        long[][] dp = new long[m + 1][n + 1];
        long tmp;
        for (int[] i : prices) {
            dp[i[0]][i[1]] = i[2];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                tmp = 0;
                for (int ii = 1; ii <= i >> 1; ii++) {
                    tmp = Math.max(tmp, dp[ii][j] + dp[i - ii][j]);
                }
                for (int jj = 1; jj <= j >> 1; jj++) {
                    tmp = Math.max(tmp, dp[i][jj] + dp[i][j - jj]);
                }
                dp[i][j] = Math.max(dp[i][j], tmp);
            }
        }
        return dp[m][n];
    }
}
