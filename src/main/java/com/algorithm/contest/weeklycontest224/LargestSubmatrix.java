package com.algorithm.contest.weeklycontest224;

import java.util.Arrays;

public class LargestSubmatrix {

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{0,0,1}, {1,1,1}, {1,0,1}};
//        System.out.println(largestSubmatrix(matrix));

//        int[][] matrix1 = new int[][]{{1,0,1,0,1}};
//        System.out.println(largestSubmatrix(matrix1));

//        int[][] matrix2 = new int[][]{{0, 0}, {0, 0}};
//        System.out.println(largestSubmatrix(matrix2));
        
        int[][] matrix3 = new int[][]{{1,1,1}, {1,1,1}, {1,1,1}, {1,1,0}, {0,0,1}, {1,1,1}, {1,0,1}, {1,0,1}, {1,1,1}, {1,0,1}, {1,1,0}, {1,1,1}, {1,1,1}, {1,1,1}, {1,1,0}, {1,1,1}, {0,0,0}, {1,1,1}, {1,1,1}, {1,0,1}, {1,0,0}, {1,1,1}, {1,1,1}, {1,1,1}, {1,1,1}, {1,0,0}, {1,1,1}, {1,1,1}, {1,1,1}, {1,1,1}, {1,1,1}, {1,1,1}, {1,1,1}};
        System.out.println(largestSubmatrix(matrix3));
    }

    public static int largestSubmatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    dp[i][j] = matrix[i][j];
                    continue;
                }
                if (matrix[i][j] == 1) {
                    dp[i][j] = dp[i - 1][j] + 1;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            Arrays.sort(dp[i]);
            for (int j = m - 1; j >= 0; j--) {
                if (dp[i][j] == 0) {
                    break;
                }
                int sub = dp[i][j] * (m - j);
                if (sub > cnt) {
                    cnt = sub;
                }
            }
        }
        return cnt;
    }
}
