package com.algorithm.leetcode;
/*
 * @lc app=leetcode.cn id=2897 lang=java
 *
 * [2897] 对数组执行操作使平方和最大
 */

// @lc code=start

import java.util.List;

class Solution {
    public static final int M = 30;
    public static final int MOD = 1000000007;
    public int maxSum(List<Integer> nums, int k) {
        int[] bins = new int[M];
        for (int num : nums) {
            for (int j = M - 1; j > -1; j--) {
                if (((num >> j) & 1) == 1) {
                    bins[j] += 1;
                }
            }
        }
        long res = 0;
        while (k > 0) {
            int s = 0;
            for (int i = M - 1; i > -1; i--) {
                if (bins[i] > 0) {
                    s |= (1 << i);
                    bins[i] -= 1;
                }
            }
            s %= MOD;
            res += (1l * s * s) % MOD;
            res %= MOD;
            k -= 1;
        }
        return (int)res%MOD;
    }
}
// @lc code=end

