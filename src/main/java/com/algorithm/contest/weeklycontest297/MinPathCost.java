package com.algorithm.contest.weeklycontest297;

public class MinPathCost {

    public static void main(String[] args) {
        int[][] grid = new int[][] { { 5, 3 }, { 4, 0 }, { 2, 1 } };
        int[][] moveCost = new int[][] { { 9, 8 }, { 1, 5 }, { 10, 12 }, { 18, 6 }, { 2, 4 }, { 14, 3 } };
        System.out.println(minPathCost(grid, moveCost));
    }

    public static int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length, n = grid[0].length;
        int[][] minDp = new int[m][n];

        for (int j = 0; j < n; j++) {
            minDp[m - 1] = grid[m - 1];
        }

        for (int i = m - 2; i >= 0; i--) {
            helper(i, minDp, grid, moveCost, n);
        }
        int minVal = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minVal = Math.min(minVal, minDp[0][j]);
        }
        return minVal;
    }

    static void helper(int r, int[][] minDp, int[][] grid, int[][] moveCost, int n) {
        int[] indexes = grid[r];
        for (int k = 0; k < n; k++) {
            int costInd = indexes[k];
            int minVal = Integer.MAX_VALUE;
            int[] costs = moveCost[costInd];
            for (int j = 0; j < n; j++) {
                minVal = Math.min(minDp[r + 1][j] + costs[j], minVal);
            }
            minDp[r][k] = minVal + costInd;
        }
    }
}
