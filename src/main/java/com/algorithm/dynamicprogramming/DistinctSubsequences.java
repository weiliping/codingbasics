package com.algorithm.dynamicprogramming;

public class DistinctSubsequences {
    /**
     * #115
     * https://leetcode-cn.com/problems/distinct-subsequences/
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(numDistinct("babgbag", "bag"));
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }

    public static int numDistinct(String s, String t) {
        if (s == null || t == null || s.length() == 0 && t.length() != 0) {
            return 0;
        }
        if (t.length() == 0) {
            return 1;
        }
        int m = s.length(), n = t.length();

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < m + 1; i++) {
            for (int j = n; j > 0; j--) {
                dp[j] = dp[j] + (s.charAt(i - 1) == t.charAt(j - 1) ? dp[j - 1] : 0);
            }
        }
        return dp[n];
    }
}
