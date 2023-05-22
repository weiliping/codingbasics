package com.algorithm.backtracking;

import java.util.Arrays;

public class Candy {

    /**
     * #135
     * https://leetcode-cn.com/problems/candy/
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(candy(new int[]{1, 2, 2}));
        System.out.println(candy(new int[]{1, 0, 2}));
        System.out.println(candy(new int[]{1, 3, 2, 2, 1}));
        System.out.println(candy(new int[]{1, 2, 87, 87, 87, 2, 1}));
        System.out.println(candy(new int[]{1, 3, 4, 5, 2}));
    }

    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 1;
        }
        int n = ratings.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] < ratings[i]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        for (int i = n - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                dp[i - 1] = Math.max(dp[i - 1], dp[i] + 1);
            }
        }
        int sum = 0;
        for (int i : dp) {
            sum += i;
        }
        return sum;
    }
}
