package com.algorithm.leetcode;

import java.util.Arrays;

class Solution {
    static final int C_BASE = (int)'a';
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
