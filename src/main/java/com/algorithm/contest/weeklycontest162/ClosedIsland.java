package com.algorithm.contest.weeklycontest162;

public class ClosedIsland {
    public static void main(String[] args) {
        ClosedIsland c = new ClosedIsland();
        int[][] grid = new int[][]{{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        System.out.println(c.closedIsland(grid));

        int[][] grid1 = new int[][]{{0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}};
        System.out.println(c.closedIsland(grid1));
        int[][] grid2 = new int[][]{{1,1,1,1,1,1,1},{1,0,0,0,0,0,1},{1,0,1,1,1,0,1},{1,0,1,0,1,0,1},{1,0,1,1,1,0,1},{1,0,0,0,0,0,1},{1,1,1,1,1,1,1}};
        System.out.println(c.closedIsland(grid2));

        int[][] grid3 = new int[][]{{0,0,1,1,0,1,0,0,1,0},{1,1,0,1,1,0,1,1,1,0},{1,0,1,1,1,0,0,1,1,0},{0,1,1,0,0,0,0,1,0,1},{0,0,0,0,0,0,1,1,1,0},{0,1,0,1,0,1,0,1,1,1},{1,0,1,0,1,1,0,0,0,1},{1,1,1,1,1,1,0,0,0,0},{1,1,1,0,0,1,0,1,0,1},{1,1,1,0,1,1,0,1,1,0}};
        System.out.println(c.closedIsland(grid3));
    }
    static final int[][] DIRS = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    public int closedIsland(int[][] grid) {
        int ans = 0;
        int m = grid.length, n = grid[0].length;
        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j, m, n);
            dfs(grid, m - 1, j, m, n);
        }
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0, m, n);
            dfs(grid, i, n - 1, m, n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    dfs(grid, i, j, m, n);
                    ans++;
                }
            }
        }
        return ans;
    }

    void dfs(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 1) {
            return;
        }
        grid[i][j] = 1;
        for (int k = 0; k < 4; k++) {
            int[] d = DIRS[k];
            dfs(grid, i + d[0], j + d[1], m, n);
        }
    }
}
