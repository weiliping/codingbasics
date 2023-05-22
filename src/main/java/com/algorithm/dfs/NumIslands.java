package com.algorithm.dfs;

public class NumIslands {

    /**
     * #200
     * https://leetcode-cn.com/problems/number-of-islands/
     *
     * @param args
     */
    public static void main(String[] args) {
        //        char[][] grid = new char[][] { { '1', '1', '1', '1', '0' },
        //                { '1', '1', '0', '1', '0' },
        //                { '1', '1', '0', '0', '0' },
        //                { '0', '0', '0', '0', '0' } };
        char[][] grid = new char[][] { { '1' }, { '1' } };
        System.out.println(numIslands(grid));
    }

    static int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int rLen = grid.length, cLen = grid[0].length;

        boolean[][] visited = new boolean[rLen][cLen];
        int res = 0;
        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    res++;
                    dfs(grid, i, j, rLen, cLen, visited);
                }
            }
        }
        return res;
    }

    static void dfs(char[][] grid, int i, int j, int rLen, int cLen, boolean[][] visited) {
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        for (int k = 0; k < dirs.length; k++) {
            int sunI = i + dirs[k][0];
            int sunJ = j + dirs[k][1];
            if (sunI >= 0 && sunI < rLen && sunJ >= 0 && sunJ < cLen && grid[sunI][sunJ] == '1') {
                dfs(grid, sunI, sunJ, rLen, cLen, visited);
            }
        }
    }
}
