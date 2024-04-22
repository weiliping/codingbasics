package com.algorithm.leetcode;
/*
 * @lc app=leetcode.cn id=2982 lang=java
 *
 * [2982] 找出出现至少三次的最长特殊子字符串 II
 */

// @lc code=start

class Solution {
    public int maximumLength(String s) {
        int[][] cnts = new int[26][3];
        int n = s.length(), i = 0;
        while (i < n) {
            int j = i + 1;
            char p = s.charAt(i);
            while (j < n && p == s.charAt(j)) {
                j++;
            }
            int ind = (int)p - (int)'a';
            int v = j - i;
            int[] vs = cnts[ind];
            for (int k = 2; k > -1; k--) {
                if (v > vs[k]) {
                    int t = vs[k];
                    vs[k] = v;
                    v = t;
                }
            }
            i = j;
        }
        int res = -1;
        for (int j = 0; j < 26; j++) {
            int[] vs = cnts[j];
            if (vs[2] == 0 || vs[0] + vs[1] + vs[2] < 3) {
                continue;
            }
            if (vs[0] == vs[1] && vs[1] == vs[2]) {
                res = Math.max(res, vs[0]);
                continue;
            }
            if (vs[1] == vs[2] || vs[1] == vs[2] - 1) {
                res = Math.max(vs[2] - 1, res);
                continue;
            }
            res = Math.max(vs[2] - 2, res);
        }
        return res;
    }
}
// @lc code=end

