package com.algorithm.dynamicprogramming;

public class PalindromePartitioningII {

    /**
     * #132
     * https://leetcode-cn.com/problems/palindrome-partitioning-ii/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(minCut("aab"));
    }

    public static int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        boolean[][] q = new boolean[len][len];
        int[] dp = new int[len];

        for (int i = 0; i < len; i++) {
            dp[i] = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j < 2 || q[j + 1][i - 1])) {
                    q[j][i] = true;
                    dp[i] = (j == 0) ? 0 : Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[len - 1];
    }
}
