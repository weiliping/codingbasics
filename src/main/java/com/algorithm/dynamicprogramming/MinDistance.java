package com.algorithm.dynamicprogramming;

public class MinDistance {

    /**
     *
     * https://leetcode-cn.com/problems/edit-distance/
     *
     * @param args
     */
    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        System.out.println(minDistance(word1, word2));
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m][n];
        return helper(word1, 0, word2, 0, dp);
    }

    static int helper(String word1, int i, String word2, int j, int[][] dp) {
        if (i == word1.length()) {
            return word2.length() - j;
        }
        if (j == word2.length()) {
            return word1.length() - i;
        }

        if (dp[i][j] > 0) {
            return dp[i][j];
        }

        int res = 0;

        if (word1.charAt(i) == word2.charAt(j)) {
            return helper(word1, i + 1, word2, j + 1, dp);
        } else {
            int insertCnt = helper(word1, i, word2, j + 1, dp);
            int deleteCnt = helper(word1, i + 1, word2, j, dp);
            int replaceCnt = helper(word1, i + 1, word2, j + 1, dp);

            res = Math.min(Math.min(insertCnt, deleteCnt), replaceCnt) + 1;
        }
        dp[i][j] = res;
        return res;
    }
}