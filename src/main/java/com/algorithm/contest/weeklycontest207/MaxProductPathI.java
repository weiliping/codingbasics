package com.algorithm.contest.weeklycontest207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxProductPathI {

    public static void main(String[] args) {
        MaxProductPathI m = new MaxProductPathI();
        int[][] grid = new int[][] { { 1, -2, 1 }, { 1, -2, 1 }, { 3, -4, 1 } };
        System.out.println(m.maxProductPath(grid));
        int[][] grid2 = new int[][] {
                { 1, -1, 2, 1, -1, 0, 0, 4, 3, 2, 0, -2, -2 },
                { -2, 3, 3, -1, -1, 0, 0, -2, 4, -3, 3, 0, 0 },
                { -4, -1, -1, -2, 2, -1, -2, -2, 0, 3, -1, -4, 1 },
                { -3, 4, -3, 0, -3, 1, -3, 1, 4, 4, -4, -4, -2 },
                { 3, -3, 1, 0, -1, -4, -4, -4, 3, 2, 2, 3, 3 },
                { 2, -1, -1, -4, -3, -3, 4, 2, 3, 4, 4, -4, 0 },
                { 4, -1, 2, -3, -1, -1, -3, -4, 4, 4, 4, -3, -1 },
                { -3, -4, 4, -2, -1, 2, 3, -1, 2, 3, 4, 4, -4 },
                { -3, -1, -2, 1, 1, -1, -3, -4, -3, 1, -3, 3, -4 },
                { 2, 4, 4, 4, -3, -3, 1, -1, 3, 4, -1, 1, 4 },
                { 2, -2, 0, 4, -1, 0, -2, 4, -4, 0, 0, 2, -3 },
                { 1, 1, -3, 0, -4, -4, -4, -4, 0, -1, -4, -1, 0 },
                { 3, -1, -3, -3, -3, -2, -1, 4, -1, -2, 4, 2, 3 } };
        System.out.println(m.maxProductPathI(grid2));
    }

    static final int MOD = (int) 1e9 + 7;

    public int maxProductPath(int[][] grid) {
        long[] res = new long[1];
        int n = grid.length, m = grid[0].length;
        List<int[]> paths = new ArrayList<>();
        paths.add(new int[] { 0, 0 });
        dfs(0, 0, n, m, grid, res, 1l, paths);
        if (res[0] < 0) {
            return -1;
        }
        return (int) (res[0] % MOD);
    }

    void dfs(int i, int j, int n, int m, int[][] grid, long[] res, long subRes, List<int[]> paths) {
        if (i == n - 1 && j == m - 1) {
            if (res[0] < subRes) {
                res[0] = subRes;
            }
            return;
        }
        if (subRes == 0) {
            return;
        }
        if (i < n - 1) {
            paths.add(new int[] { i + 1, j });
            dfs(i + 1, j, n, m, grid, res, subRes * grid[i + 1][j], paths);
            paths.remove(paths.size() - 1);
        }
        if (j < m - 1) {
            paths.add(new int[] { i, j + 1 });
            dfs(i, j + 1, n, m, grid, res, subRes * grid[i][j + 1], paths);
            paths.remove(paths.size() - 1);
        }
    }

    public int maxProductPathI(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        long[][][] dp = new long[n][m][2];
        dp[0][0] = new long[] { grid[0][0], grid[0][0] };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                dfs(dp, i, j, grid);
            }
        }
        if (dp[n - 1][m - 1][0] < 0) {
            return -1;
        }
        return (int) (dp[n - 1][m - 1][0] % MOD);
    }

    void dfs(long[][][] dp, int i, int j, int[][] grid) {
        long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
        if (i > 0) {
            min = Math.min(dp[i - 1][j][1], min);
            max = Math.max(dp[i - 1][j][0], max);
        }

        if (j > 0) {
            min = Math.min(dp[i][j - 1][1], min);
            max = Math.max(dp[i][j - 1][0], max);
        }
        long minVal = min * grid[i][j], maxVal = max * grid[i][j];
        dp[i][j] = new long[] { Math.max(minVal, maxVal), Math.min(minVal, maxVal) };
    }
}
