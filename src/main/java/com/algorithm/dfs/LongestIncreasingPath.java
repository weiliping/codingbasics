package com.algorithm.dfs;

public class LongestIncreasingPath {
    /**
     * #329
     * https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(longestIncreasingPath(new int[][] { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } }));
    }

    static int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int ans = 0;
        int rLen = matrix.length, cLen = matrix[0].length;
        int[][] mem = new int[rLen][cLen];
        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, mem, rLen, cLen));
            }
        }
        return ans;
    }

    static int dfs(int[][] matrix, int i, int j, int[][] mem, int rLen, int cLen) {
        if (mem[i][j] > 0) {
            return mem[i][j];
        }
        mem[i][j]++;

        for (int k = 0; k < dirs.length; k++) {
            int chr = i + dirs[k][0], chl = j + dirs[k][1];
            if (chr >= 0 && chr < rLen && chl >= 0 && chl < cLen && matrix[i][j] < matrix[chr][chl]) {
                int maxChild = dfs(matrix, chr, chl, mem, rLen, cLen);
                mem[i][j] = Math.max(mem[i][j], maxChild + 1);
            }
        }
        return mem[i][j];
    }
}
