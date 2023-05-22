package com.algorithm.others;

public class LongestCommonSubsequence {
    //    int lcs(char[] x, char[] y, int m, int n) {
    //        if (m == 0 || n == 0 ){
    //            return 0;
    //        }
    //
    //        if (x[m-1] == y[n-1]) {
    //            return 1 + lcs(x, y, m -1, n-1);
    //        }
    //        return max(lcs(x, y, m, n-1), lcs(x, y, m-1, n));
    //    }

    int lcs(char[] x, char[] y, int m, int n) {
        int[][] l = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    l[i][j] = 0;
                } else if (x[i - 1] == y[j - 1]) {
                    l[i][j] = l[i - 1][j - 1] + 1;
                } else {
                    l[i][j] = max(l[i - 1][j], l[i][j - 1]);
                }
            }
        }
        return l[m][n];
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is" + " " + lcs.lcs(X, Y, m, n));
    }
}
