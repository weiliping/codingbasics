package com.algorithm.contest.weeklycontest332;

public class MinimumScore {
    public static void main(String[] args) {

        String s = "abacaba", t = "bzaa";
        System.out.println(minimumScore(s, t));
        String s1 = "cde", t1 = "xyz";
        System.out.println(minimumScore(s1, t1));
    }

    public static int minimumScore(String s, String t) {
        int n = s.length(), m = t.length();
        int[] dp = new int[n + 1];
        int[] d = new int[n + 1];
        char[] chrs = s.toCharArray();
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (chrs[i] == t.charAt(j)) {
                dp[i + 1] = dp[i] + 1;
                i++;
                j++;
                continue;
            }
            dp[i + 1] = dp[i];
            i++;
        }
        i = n - 1;
        j = m - 1;
        while (i >= 0 && j >= 0) {
            if (chrs[i] == t.charAt(j)) {
                d[i] = d[i + 1] + 1;
                i--;
                j--;
                continue;
            }
            d[i] = d[i + 1];
            i--;
        }
        int max = Integer.MIN_VALUE;
        int l = -1, r = -1;
        for (int k = 0; k <= n; k++) {
            int v = dp[k] + d[k];
            if (max < v) {
                max = v;
                l = dp[k];
                r = d[k];
            }
        }
        int v = r + l;
        return v >= m ? 0 : m - v;
    }
}
