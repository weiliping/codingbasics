package com.algorithm.leetcode;
/*
 * @lc app=leetcode.cn id=2262 lang=java
 *
 * [2262] 字符串的总引力
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    static final int C_BASE = (int) 'a';
    public long appealSum(String s) {
        int[] inds = new int[26];
        long ans = 0, pre = 0;
        Arrays.fill(inds, -1);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int j = (int) s.charAt(i) - C_BASE;
            pre += i - inds[j];
            inds[j] = i;
            ans += pre;
        }
        return ans;
    }
}
// @lc code=end

