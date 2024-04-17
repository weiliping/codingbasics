package com.algorithm.leetcode;
/*
 * @lc app=leetcode.cn id=2930 lang=java
 *
 * [2930] 重新排列后包含指定子字符串的字符串数目
 */

// @lc code=start
class Solution {
    public static final int MOD = (int)1e9 + 7;
    public int stringCount(int n) {
        long res = quickMultiple(26, n);
        res -= quickMultiple(25, n - 1) * (75 + n);
        res += quickMultiple(24, n - 1) * (72 + (n << 1));
        res -= quickMultiple(23, n - 1) * (23 + n);
        return (int)((res % MOD + MOD) % MOD);
    }

    public static long quickMultiple(long x, int n) {
        if (n == 0) {
            return 1l;
        }
        long y = quickMultiple(x, n >> 1);
        y = y * y % MOD;
        return ((n & 1) == 0 ? y : (y * x)%MOD); 
    }
}
// @lc code=end

