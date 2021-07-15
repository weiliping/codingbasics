package com.algorithm.contest.weeklycontest215;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumSquares {
    public static void main(String[] args) {
        NumSquares s = new NumSquares();
        System.out.println(s.numSquares(12));
    }
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        List<Integer> nums = getNums(n);
        for (int i = 0; i <= n; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] = Math.min(dp[i], dp[i - num] + 1);
                }
            }
        }
        return dp[n];
    }

    public List<Integer> getNums(int n) {
        int i = 1, h = n / 2;
        List<Integer> res = new ArrayList<>();
        while (i <= h && i * i <= n) {
            res.add(i * i);
            i++;
        }
        return res;
    }
}
