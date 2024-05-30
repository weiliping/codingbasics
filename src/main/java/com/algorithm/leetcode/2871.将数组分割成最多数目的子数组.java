package com.algorithm.leetcode;
/*
 * @lc app=leetcode.cn id=2871 lang=java
 *
 * [2871] 将数组分割成最多数目的子数组
 */

// @lc code=start

class Solution {
    static final int MIN_NUM = 1048575;
    public int maxSubarrays(int[] nums) {
        int minNum = MIN_NUM;
        for (int num : nums) {
            minNum &= num;
            if (minNum == 0) {
                break;
            }
        }
        if (minNum != 0) {
            return 1;
        }
        int ans = 0;
        int tNum = MIN_NUM;
        for (int num : nums) {
            tNum &= num;
            if (tNum == minNum) {
                tNum = MIN_NUM;
                ans += 1;
            }
        }
        return ans;
    }
}
// @lc code=end

