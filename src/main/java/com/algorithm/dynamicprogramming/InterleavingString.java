package com.algorithm.dynamicprogramming;

public class InterleavingString {

    /**
     * #97
     * https://leetcode-cn.com/problems/interleaving-string/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null) {
            if (s3 == null) {
                return s1 == null ? s2 == null : s1 == null;
            }
            return s1 == null ? s3.equals(s2) : s3.equals(s1);
        }

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int l1 = s1.length(), l2 = s2.length();

        boolean[][] dp = new boolean[l1 + 1][l2 + 1];

        dp[0][0] = true;

        for (int i = 1; i < l1 + 1; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        for (int j = 1; j < l2 + 1; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < l2 + 1; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1 + j)) ||
                        (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1 + i));
            }
        }
        return dp[l1][l2];
    }
}
