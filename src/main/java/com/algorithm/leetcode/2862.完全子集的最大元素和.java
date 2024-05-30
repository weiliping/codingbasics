package com.algorithm.leetcode;
/*
 * @lc app=leetcode.cn id=2862 lang=java
 *
 * [2862] 完全子集的最大元素和
 */

// @lc code=start

import java.util.HashMap;
import java.util.List;

class Solution {
    static final int N = 10_001;
    static int[] INDEX = new int[N];
    static {
        INDEX[1] = 1;
        INDEX[2] = 2;
        INDEX[3] = 3;
        for (int i = 4; i < N; i++) {
            INDEX[i] = removeSquareNums(i);
        }
    }
    public static int removeSquareNums(int num) {
        int res = 1;
        for (int i = 2; i < 101; i++) {
            int j = 0;
            while (num > 1 && num % i == 0) {
                j ^= 1;
                num /= i;
            }
            if (j == 1) {
                res *= i;
            }
            if (num == 1) {
                return res;
            }
        }
        return res * num;
    }

    public long maximumSum(List<Integer> nums) {
        long res = 0;
        int n = nums.size() + 1;
        long[] sum = new long[n];
        for (int i = 1; i < n; i++) {
            sum[INDEX[i]] += nums.get(i - 1);
            res = Math.max(res, sum[INDEX[i]]);
        }
        return res;
    }
}
// @lc code=end

