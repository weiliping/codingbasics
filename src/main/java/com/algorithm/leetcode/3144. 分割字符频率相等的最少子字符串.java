package com.algorithm.leetcode;

import java.util.Arrays;

class Solution3144 {
    static final int A = (int)'a';

    public static void main(String[] args) {
        Solution3144 s = new Solution3144();
        System.out.println(s.minimumSubstringsInPartition("fabccddg"));
        System.out.println(s.minimumSubstringsInPartition("abababaccddb"));
    }
    public int minimumSubstringsInPartition(String s) {
        int n = s.length();
        int[][] cnts = new int[n + 1][26];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        int[] chr = new int[26];
        chr[s.charAt(0) - A] += 1;
        cnts[1] = chr.clone();
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            int ind = (int) c - A;
            chr[ind] += 1;
            if (isValid(chr)) {
                dp[0][i] = 1;
            }
            cnts[i + 1] = chr.clone();
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isValid(cnts[i], cnts[j + 1])) {
                    dp[i][j] = 1;
                }    
            }
        }
        int[] p = new int[n];
        Arrays.fill(p, n);
        p[0] = 1;
        for (int i = 1; i < n; i++) {
            if (dp[0][i] == 1) {
                p[i] = 1;
                continue;
            } 
            for (int j = 1; j <= i; j++) {
                if (dp[j][i] == 1) {
                    p[i] = Math.min(p[i], p[j - 1] + 1);
                }
            }
        }
        return p[n - 1];
    }
    
    private boolean isValid(int[] chr, int[] chr2) {
        int c = -1;
        for (int i = 0; i < 26; i++) {
            if (chr[i] == chr2[i]) {
                continue;
            }
            if (c == -1) {
                c = chr2[i] - chr[i];
                continue;
            }
            if (c != chr2[i] - chr[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean isValid(int[] chr) {
        int c = -1;
        for (int i = 0; i < 26; i++) {
            if (chr[i] == 0) {
                continue;
            }
            if (c == -1) {
                c = chr[i];
                continue;
            }
            if (c != chr[i]) {
                return false;
            }
        }
        return true;
    }
}
