package com.algorithm.dynamicprogramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestArithmeticProgression {

    /**
     * https://www.interviewbit.com/problems/longest-arithmetic-progression/
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] a = new int[] { 1, 7, 10, 15, 27, 29 };
        System.out.println(longestArithmeticProgression(a));
    }

    public static int longestArithmeticProgression(List<Integer> A) {
        if (A == null) {
            return 0;
        }
        int n = A.size();
        if (n <= 2) {
            return n;
        }
        Collections.sort(A);
        int[][] dp = new int[n][n];
        int llap = 2;
        for (int i = 0; i < n; i++) {
            dp[i][n - 1] = 2;
        }

        for (int j = n - 2; j >= 1; j--) {
            int i = j - 1, k = j + 1;
            while (i >= 0 && k <= n - 1) {
                if (A.get(i) + A.get(k) < 2 * A.get(j)) {
                    k++;
                } else if (A.get(i) + A.get(k) > 2 * A.get(j)) {
                    dp[i][j] = 2;
                    i--;
                } else {
                    dp[i][j] = dp[j][k] + 1;
                    llap = Math.max(llap, dp[i][j]);
                    i--;
                    k++;
                }
            }
            while (i >= 0) {
                dp[i][j] = 2;
                i--;
            }
        }
        return llap;
    }

    public static int longestArithmeticProgression(int[] a) {
        if (a == null) {
            return 0;
        }
        int n = a.length;
        if (n <= 2) {
            return n;
        }
        Arrays.sort(a);
        int[][] dp = new int[n][n];
        int llap = 2;
        for (int i = 0; i < n; i++) {
            dp[i][n - 1] = 2;
        }

        for (int j = n - 2; j >= 1; j--) {
            int i = j - 1, k = j + 1;
            while (i >= 0 && k <= n - 1) {
                if (a[i] + a[k] < 2 * a[j]) {
                    k++;
                } else if (a[i] + a[k] > 2 * a[j]) {
                    dp[i][j] = 2;
                    i--;
                } else {
                    dp[i][j] = dp[j][k] + 1;
                    llap = Math.max(llap, dp[i][j]);
                    i--;
                    k++;
                }
            }
            while (i >= 0) {
                dp[i][j] = 2;
                i--;
            }
        }
        return llap;
    }
}
