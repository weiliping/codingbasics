package com.algorithm.leetcode;
/*
 * @lc app=leetcode.cn id=2932 lang=java
 *
 * [2932] 找出强数对的最大异或值 I
 */

// @lc code=start
class Solution2932 {
    public int maximumStrongPairXor(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = nums[i], b = nums[j];
                if (a < b) {
                    int t = a;
                    a = b;
                    b = t;
                }
                if (a <= (b << 1)) {
                    res = Math.max(res, a^b);
                }
            }
        }
        return res;
    }
}
// @lc code=end

