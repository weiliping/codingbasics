package com.algorithm.leetcode;
/*
 * @lc app=leetcode.cn id=2902 lang=java
 *
 * [2902] 和带限制的子多重集合的数目
 */

// @lc code=start

import java.util.Arrays;
import java.util.List;

class Solution2902 {
    public static void main(String[] args) {
        Solution2902 s = new Solution2902();
        List<Integer> nums = List.of(1, 2, 2, 3);
        System.out.println(s.countSubMultisets(nums, 6, 6));

        System.out.println(s.countSubMultisets(Arrays.asList(2, 1, 4, 2, 7), 1, 5));
        System.out.println(s.countSubMultisets(Arrays.asList(1,2,1,3,5,2), 3, 5));
    }

    static final int M = (int)1e9 + 7;
    static final long N = 20000;
    public int countSubMultisets(List<Integer> nums, int l, int r) {
        int[] s = new int[r + 1];
        Arrays.fill(s, r + 1);
        int n = nums.size();
        s[0] = 0;
        for (int j = r; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                int v = nums.get(i);
                if (j >= v) {
                    s[j] = Math.min(s[j], s[j - v] + 1);
                }
            }
        }
        long res = 0;
        for (int i = l; i <= r; i++) {
            res += s[i];
            res %= M;
        }
        return (int) res % M;
    }
}
// @lc code=end

