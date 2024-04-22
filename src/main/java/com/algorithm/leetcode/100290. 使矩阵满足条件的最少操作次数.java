package com.algorithm.leetcode;

import java.util.Arrays;

class Solution100290 {

    public static void main(String[] args) {
        Solution100290 solution = new Solution100290();
        int[][] grid = new int[][] {
            {8,9,4,5,4,8,2,4},
            {9,1,6,8,5,1,5,5},
            {1,8,5,6,3,4,4,1},
            {9,0,1,4,9,9,8,6},
            {3,3,4,5,2,6,1,7},
            {3,8,4,4,4,1,0,1},
            {8,6,7,0,0,4,0,2},
            {5,1,3,1,8,5,9,5}};
        System.out.println(solution.minimumOperations(grid));
    }
    public int minimumOperations(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        int[][] cnts = new int[n][10];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                cnts[j][grid[i][j]] += 1;
            }
        }
        int[][] memo = new int[n][10];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        int c = Integer.MAX_VALUE;
        int i = 0;
        for (int j = 0; j < 10; j++) {
            if (cnts[0][j] != 0) {
                int v = 0;
                if (i < n - 1) {
                    v = dfs(cnts, j, i + 1, m, n, memo);
                }
                c = Math.min(c,  v + m - cnts[0][j]);
            }
        }
        return c;
    }
    
    public static int dfs(int[][] cnts, int j, int i, int m, int n, int[][] memo) {
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        
        int[] rCnts = cnts[i];
        int c = Integer.MAX_VALUE;
        for (int k = 0; k < 10; k++) {
            if (k != j) {
                int v = 0;
                if (i < n - 1) {
                    v = dfs(cnts, k, i + 1, m, n, memo);
                }
                c = Math.min(c, v + m - rCnts[k]);
            }
        }
        return memo[i][j] = c;
    }
}
