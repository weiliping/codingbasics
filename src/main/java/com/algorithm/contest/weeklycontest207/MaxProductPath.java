package com.algorithm.contest.weeklycontest207;

public class MaxProductPath {
    public static void main(String[] args) {
        MaxProductPath m = new MaxProductPath();
//        int[][] grid = new int[][]{{-1,-2,-3}, {-2,-3,-3}, {-3,-3,-2}};
//        System.out.println(m.maxProductPath(grid));
//        int[][] grid1 = new int[][]{{1, -2, 1}, {1, -2, 1}, {3, -4, 1}};
//        System.out.println(m.maxProductPath(grid1));
//        int[][] grid2 = new int[][]{{1, 3}, {0, -4}};
//        System.out.println(m.maxProductPath(grid2));
//        int[][] grid3 = new int[][]{{1, 4, 4, 0}, {-2, 0, 0, 1}, {1, -1, 1, 1}};
//        System.out.println(m.maxProductPath(grid3));
        int[][] grid4 = new int[][]{{1,-1,2,1,-1,0,0,4,3,2,0,-2,-2}, {-2,3,3,-1,-1,0,0,-2,4,-3,3,0,0}, {-4,-1,-1,-2,2,-1,-2,-2,0,3,-1,-4,1}, {-3,4,-3,0,-3,1,-3,1,4,4,-4,-4,-2}, {3,-3,1,0,-1,-4,-4,-4,3,2,2,3,3}, {2,-1,-1,-4,-3,-3,4,2,3,4,4,-4,0}, {4,-1,2,-3,-1,-1,-3,-4,4,4,4,-3,-1}, {-3,-4,4,-2,-1,2,3,-1,2,3,4,4,-4}, {-3,-1,-2,1,1,-1,-3,-4,-3,1,-3,3,-4}, {2,4,4,4,-3,-3,1,-1,3,4,-1,1,4}, {2,-2,0,4,-1,0,-2,4,-4,0,0,2,-3}, {1,1,-3,0,-4,-4,-4,-4,0,-1,-4,-1,0}, {3,-1,-3,-3,-3,-2,-1,4,-1,-2,4,2,3}};
        System.out.println(m.maxProductPath(grid4));
    }

    static final int MOD = (int) 1e9 + 7;
    public int maxProductPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        long[][][] dp = new long[n][m][2];
        dp[0][0] = new long[]{grid[0][0], grid[0][0]};
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
        dp[i][j] = new long[]{Math.max(minVal, maxVal), Math.min(minVal, maxVal)};
    }
}
