package com.algorithm.stacksandqueues;

public class Trap {
    /**
     * https://leetcode-cn.com/problems/trapping-rain-water
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(new Trap().trap2(height));
    }

    public int trap(int[] height) {
        if (height == null) {
            return 0;
        }
        int n = height.length;
        int[] dp = new int[n];
        int mv = 0, res = 0;
        for (int i = 0; i < n; i++) {
            mv = Math.max(height[i], mv);
            dp[i] = mv;
        }

        mv = 0;
        for (int j = n - 1; j >= 0; j--) {
            dp[j] = Math.min(dp[j], mv);
            mv = Math.max(dp[j], height[j]);
            if (dp[j] > height[j]) {
                res += dp[j] - height[j];
            }
        }
        return res;
    }

    public int trap2(int[] height) {
        int res = 0, level = 0, l = 0, r = height.length - 1;

        while (l < r) {
            int lower = height[height[l] < height[r] ? l++ : r--];
            level = Math.max(level, lower);
            res += level - lower;
        }
        return res;
    }
}
