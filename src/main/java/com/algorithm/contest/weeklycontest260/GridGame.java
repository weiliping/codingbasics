package com.algorithm.contest.weeklycontest260;

public class GridGame {
    public static void main(String[] args) {
        // System.out.println(gridGame(new int[][] { { 3, 3, 1 }, { 8, 5, 2 } }));
        // System.out.println(gridGame(new int[][] { { 1, 3, 1, 15 }, { 1, 3, 3, 1 }
        // }));
        System.out.println(gridGame(
                new int[][] { { 20, 3, 20, 17, 2, 12, 15, 17, 4, 15 }, { 20, 10, 13, 14, 15,
                        5, 2, 3, 14, 3 } }));

        // System.out.println(gridGameI(new int[][] { { 3, 3, 1 }, { 8, 5, 2 } }));
        // System.out.println(gridGameI(new int[][] { { 1, 3, 1, 15 }, { 1, 3, 3, 1 }
        // }));
        System.out.println(gridGameI(
                new int[][] { { 20, 3, 20, 17, 2, 12, 15, 17, 4, 15 }, { 20, 10, 13, 14, 15, 5, 2, 3, 14, 3 } }));
    }

    public static long dfs(int i, int j, int[][] grid, long[][] max) {
        if (i < 0 || j < 0) {
            return -1;
        }

        if (max[i][j] != 0) {
            return max[i][j];
        }
        long c = -1;
        if (i > 0) {
            c = Math.max(c, dfs(i - 1, j, grid, max));
        }
        if (j > 0) {
            c = Math.max(c, dfs(i, j - 1, grid, max));
        }
        max[i][j] = c > 0 ? grid[i][j] + c : grid[i][j];
        return max[i][j];
    }

    public static long gridGameI(int[][] grid) {
        int n = grid[0].length;
        long[][] sum = new long[2][n];
        long s = 0l;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                s += grid[i][j];
            }
        }
        long sumA = dfs(1, n - 1, grid, sum);
        return s - sumA;
    }

    public static long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[][] sum = new long[2][n + 1];
        for (int j = 0; j < 2; j++) {
            for (int i = 1; i <= n; i++) {
                sum[j][i] = sum[j][i - 1] + grid[j][i - 1];
            }
        }

        long res = Long.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            long right = sum[0][n] - sum[0][i];
            long left = sum[1][i - 1];

            res = Math.min(res, Math.max(left, right));
            System.out.println(" i = " + i + " res = " + res + " r " + right + " l " + left);
        }
        return res;
    }
}
