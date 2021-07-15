package com.algorithm.dynamicprogramming;

public class GetMoneyAmount {

    /**
     * #375
     * https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new GetMoneyAmount().getMoneyAmountII(10));
    }

    public int getMoneyAmount(int n) {
        return cal(1, n);
    }

    int cal(int low, int high) {
        if (low >= high) {
            return 0;
        }

        int minRes = Integer.MAX_VALUE;
        for (int i = (low + high)/2; i < high; i++) {
            int max = i + Math.max(cal(low, i - 1), cal(i + 1, high));
            minRes = Math.min(minRes, max);
        }
        return minRes;
    }

    public int getMoneyAmountII(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int minres = Integer.MAX_VALUE;
                for (int piv = start; piv < start + len - 1; piv++) {
                    int res = piv + Math.max(dp[start][piv - 1], dp[piv + 1][start + len - 1]);
                    minres = Math.min(res, minres);
                }
                dp[start][start + len - 1] = minres;
            }
        }
        return dp[1][n];
    }
}
