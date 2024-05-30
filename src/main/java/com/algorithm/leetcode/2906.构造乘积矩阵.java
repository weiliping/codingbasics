package com.algorithm.leetcode;
/*
 * @lc app=leetcode.cn id=2906 lang=java
 *
 * [2906] 构造乘积矩阵
 */

// @lc code=start

class Solution {
    static final int NUM = 12345;
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] preSum = new int[m][n], suffSum = new int[m][n];
        int pre = 1, suff = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                preSum[i][j] = pre * (grid[i][j] % NUM) % NUM;
                pre = preSum[i][j];
            }
        }

        for (int i = m - 1; i > -1; i--) {
            for (int j = n - 1; j > -1; j--) {
                suffSum[i][j] = (suff * (grid[i][j] % NUM)) % NUM;
                suff = suffSum[i][j];
            }
        }
        int[][] ans = new int[m][n];
        if (n == 1) {
            ans[0][0] = suffSum[1][0];
            for (int i = 1; i < m - 1; i++) {
                ans[i][0] = preSum[i - 1][0] * suffSum[i + 1][0] % NUM;
            }
            ans[m - 1][0] = preSum[m - 2][0];
            return ans;
        }
        if (m == 1) {
            ans[0][0] = suffSum[0][1];
            for (int j = 1; j < n - 1; j++) {
                ans[0][j] = preSum[0][j - 1] * suffSum[0][j + 1] % NUM;
            }
            ans[0][n - 1] = preSum[0][n - 2];
            return ans;
        }
        ans[0][0] = suffSum[0][1];
        ans[m - 1][n - 1] = preSum[m - 1][n - 2];
        for (int i = 1; i < m; i++) {
            ans[i][0] = (preSum[i - 1][n - 1] * suffSum[i][1]) % NUM;
        }
        for (int i = 0; i < m - 1; i++) {
            ans[i][n - 1] = (preSum[i][n - 2] * suffSum[i + 1][0]) % NUM;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n - 1; j++) {
                ans[i][j] = (preSum[i][j - 1] * suffSum[i][j + 1]) % NUM;
            }
        }
        return ans;
    }
}
// @lc code=end

