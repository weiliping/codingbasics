package com.algorithm.contest.biweeklycontest50;

public class CountPoints {
    public int[] countPoints(int[][] points, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int v = queries[i][2] * queries[i][2];
            for (int[] p : points) {
                if (distance(p, queries[i]) <= v) {
                    res[i]++;
                }
            }
        }
        return res;
    }

    public int distance(int[] point1, int[] point2) {
        return dt(point1[0], point2[0]) + dt(point1[1], point2[1]);
    }

    public int dt(int x, int y) {
        int v = Math.abs(x - y);
        return v * v;
    }
}
