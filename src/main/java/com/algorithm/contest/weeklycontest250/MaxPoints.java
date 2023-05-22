package com.algorithm.contest.weeklycontest250;

import java.util.Arrays;

public class MaxPoints {

    public static void main(String[] args) {
        MaxPoints m = new MaxPoints();
        int points[][] = new int[][] {{1,2,3},{1,5,1},{3,1,1}};
        System.out.println(m.maxPoints(points));
        System.out.println(m.maxPointsI(points));

        int points2[][] = new int[][] {{1,5},{2,3},{4,2}};
        System.out.println(m.maxPoints(points2));
        System.out.println(m.maxPointsI(points2));
    }

    public long maxPointsI(int[][] points) {
        int m = points.length, n = points[0].length;
        long[] dp = new long[n];
        for (int i = 0; i < m; i++) {
            long[] g = new long[n];
            long max = Long.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dp[j] + j);
                g[j] = Math.max(g[j], max + points[i][j] - j);
            }

            max = Long.MIN_VALUE;
            for (int j = n - 1; j >= 0; j--) {
                max = Math.max(max, dp[j] - j);
                g[j] = Math.max(g[j], max + points[i][j] + j);
            }
            dp = Arrays.copyOfRange(g, 0, n);
        }
        return max(dp, 0, n - 1);
    }

    long max(long[] row, int s, int e) {
        if (s > e) {
            return Integer.MIN_VALUE;
        }
        if (s == e) {
            return row[s];
        }

        if (s + 1 == e) {
            long v1 = row[s];
            long v2 = row[e];
            return Math.max(v1, v2);
        }

        int mid = s + ((e - s) >> 1);
        return Math.max(max(row, s, mid), max(row, mid + 1, e));
    }

    public long maxPoints(int[][] points) {
        int n = points.length, m = points[0].length;
        long[][] dp = new long[n][m];
        for (int j = 0; j < m; j++) {
            dp[0][j] = points[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = points[i][j] + max(j, dp[i - 1], 0, dp[i - 1].length - 1);
            }
        }
        return max(dp[n - 1], 0, dp[n - 1].length - 1);
    }



    long max(int j, long[] row, int s, int e) {
        if (s > e) {
            return Integer.MIN_VALUE;
        }
        if (s == e) {
            return row[s] - Math.abs(s - j);
        }

        if (s + 1 == e) {
            long v1 = row[s] - Math.abs(s - j);
            long v2 = row[e] - Math.abs(e - j);
            return Math.max(v1, v2);
        }

        int mid = s + ((e - s) >> 1);
        return Math.max(max(j, row, s, mid), max(j, row, mid + 1, e));
    }
}
