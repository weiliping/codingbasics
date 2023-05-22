package com.algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumSquares {

    /**
     * #279
     * https://leetcode-cn.com/problems/perfect-squares/
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new NumSquares().numSquares(1));
    }

    public int numSquares(int n) {
        List<Integer> squareNums = squareNums(n);

        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (Integer num : squareNums) {
                if (i >= num) {
                    dp[i] = Math.min(dp[i], dp[i - num] + 1);
                }
            }
        }
        return dp[n] == n + 1 ? -1 : dp[n];
    }

    private List<Integer> squareNums(int n) {
        List<Integer> res = new ArrayList<>();
        int i = 1;
        while (i * i <= n) {
            res.add(i * i);
            i++;
        }
        return res;
    }
}
