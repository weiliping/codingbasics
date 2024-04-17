package com.algorithm.leetcode;
/*
 * @lc app=leetcode.cn id=2931 lang=java
 *
 * [2931] 购买物品的最大开销
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public long maxSpending(int[][] values) {
        long res = 0;
        int m = values.length, n = values[0].length;
        
        int[] minInds = new int[m];
        Arrays.fill(minInds, n - 1);
        int i = 0;
        
        while (i < m * n) {
            int v = 10000001, k = -1;
            for (int j = 0; j < m; j++) {
                if (minInds[j] == -1) {
                    continue;
                }
                if (values[j][minInds[j]] < v) {
                    v = values[j][minInds[j]];
                    k = j;
                }
            }
            i += 1;
            res += 1l * values[k][minInds[k]] * i;
            minInds[k]--;
        }
        return res;
    }
}
// @lc code=end

