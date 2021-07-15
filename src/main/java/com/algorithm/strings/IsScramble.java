package com.algorithm.strings;

public class IsScramble {

    /**
     * #87
     * https://leetcode-cn.com/problems/scramble-string/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isScramble("great", "rgeat"));
        System.out.println(isScrambleII("great", "rgeat"));
        System.out.println(isScramble("abcde", "caebd"));
        System.out.println(isScrambleII("abcde", "caebd"));
    }

    public static boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return s2 == s1;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        int n = s1.length();
        int[] letters = new int[26];

        for (int i = 0; i < n; i++) {
            ++letters[s1.charAt(i) - 'a'];
            --letters[s2.charAt(i) - 'a'];
        }

        for (int l : letters) {
            if (l != 0) {
                return false;
            }
        }

        for (int i = 1; i < n; i++) {
            String prePart1 = s1.substring(0, i);
            String prePart2 = s2.substring(0, i);
            String postPart1 = s1.substring(i);
            String postPart2 = s2.substring(i);
            String oppPart2 = s2.substring(n - i);
            String postOppPart2 = s2.substring(0, n - 1);
            if ((isScramble(prePart1, prePart2) && isScramble(postPart1, postPart2)) ||
                (isScramble(prePart1, oppPart2) && isScramble(postPart1, postOppPart2))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isScrambleII(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return s2 == s1;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        int n = s1.length();
        boolean[][][] dp = new boolean[n][n][n + 1];

        for (int len = 1; len < n + 1; len++) {
            for (int i = 0; i <= n - len; i++) {
                for (int j = 0; j <= n - len; j++) {
                    if (len == 1) {
                        dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
                    } else {
                        for (int k = 1; k < len; k++) {
                            if ((dp[i][j][k] && dp[i + k][j + k][len - k]) ||
                                    (dp[i + k][j][len - k] && dp[i][j + len - k][k])) {
                                dp[i][j][len] = true;
                            }
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }
}
