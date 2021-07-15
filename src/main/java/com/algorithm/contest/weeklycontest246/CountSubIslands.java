package com.algorithm.contest.weeklycontest246;

public class CountSubIslands {

    public static void main(String[] args) {
        CountSubIslands c = new CountSubIslands();
        int grid11[][] = new int[][] { {1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}};
        int grid21[][] = new int[][] { {1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};
        System.out.println(c.countSubIslands(grid11, grid21));

        int grid1[][] = new int[][] { { 1, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1 },
                { 1, 0, 1, 0, 1 } };
        int grid2[][] = new int[][] {{0,0,0,0,0},{1,1,1,1,1},{0,1,0,1,0},{0,1,0,1,0},{1,0,0,0,1}};
        System.out.println(c.countSubIslands(grid1, grid2));
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int cnt = 0, n = grid2.length, m = grid2[0].length;
        boolean[][] visits = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visits[i][j]) {
                    continue;
                }
                if (grid2[i][j] == 1) {
                    boolean res[] = new boolean[1];
                    res[0] = true;
                    dfs(grid2, i, j, n, m, visits, grid1, res);
                    if (res[0]) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    void dfs(int[][] grid, int i, int j, int n, int m, boolean[][] visits, int[][] grid1, boolean res[]) {
        if (visits[i][j]) {
            return;
        }
        if (grid[i][j] == 1) {
            if (res[0] && grid1[i][j] != 1) {
                res[0] = false;
            }
            visits[i][j] = true;
            if (i > 0) {
                dfs(grid, i - 1, j, n, m, visits, grid1, res);
            }
            if (i < n - 1) {
                dfs(grid, i + 1, j, n, m, visits, grid1, res);
            }
            if (j > 0) {
                dfs(grid, i, j - 1, n, m, visits, grid1, res);
            }
            if (j < m - 1) {
                dfs(grid, i, j + 1, n, m, visits, grid1, res);
            }
        }
    }
}
