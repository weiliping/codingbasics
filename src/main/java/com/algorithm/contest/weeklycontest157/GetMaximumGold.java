package com.algorithm.contest.weeklycontest157;

public class GetMaximumGold {
    public static void main(String[] args) {
//        int[][] grid = new int[][] {{0,6,0},{5,8,7},{0,9,0}};
//        System.out.println(getMaximumGold(grid));
        
        int[][] grid1 = new int[][] {{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,2}};
        System.out.println(getMaximumGold(grid1));
    }
    public static int getMaximumGold(int[][] grid) {
        int[] res = new int[1];
        int ans = Integer.MIN_VALUE;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    res[0] = Integer.MIN_VALUE;
                    System.out.println(" i = " + i + " j = " + j);
                    dfs(res, i, j, 0, grid, m, n);
                    ans = Math.max(res[0], ans);
                }
            }
        }
        return ans;
    }

    static void dfs(int[] res, int i, int j, int val, int[][] grid, int m, int n) {
        if ((i < 1 || grid[i - 1][j] == 0) && (i >= m - 1 || grid[i + 1][j] == 0) &&
                (j < 1 || grid[i][j - 1] == 0) && (j >= n - 1 || grid[i][j + 1] == 0)) {
            res[0] = Math.max(val + grid[i][j], res[0]);
            return;
        }
        int curr = grid[i][j];
        grid[i][j] = 0;
        if (i > 0 && grid[i - 1][j] > 0) {
            dfs(res, i - 1, j,val + curr, grid, m, n);
        }

        if (i < m - 1 && grid[i + 1][j] > 0) {
            dfs(res, i + 1, j,val + curr, grid, m, n);
        }

        if (j > 0 && grid[i][j - 1] > 0) {
            dfs(res, i, j - 1, val + curr, grid, m, n);
        }

        if (j < n - 1 && grid[i][j + 1] > 0) {
            dfs(res, i, j + 1, val + curr, grid, m, n);
        }
        grid[i][j] = curr;
    }
}
