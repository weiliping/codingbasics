package com.algorithm.leetcode;
/*
 * @lc app=leetcode.cn id=2835 lang=java
 *
 * [2835] 使子序列的和等于目标的最少操作次数
 */

// @lc code=start

import java.util.Arrays;
import java.util.List;

class Solution2835 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1024,16777216,4194304,131072,4194304,4096,262144,131072,1073741824,1048576,512,1073741824,128,4096,2048,32768,128,128,262144,16384,2097152,1073741824,128,1,1073741824,2097152,32,16777216,1073741824,4194304,512,4194304,2048,128,1024,1,262144,128,8388608,1048576,262144,65536,8192,1073741824,4194304,1024,128,1073741824,512,4096,1,4194304,32768,4194304,4194304,1073741824,268435456,1024,262144,2,67108864,8192,1024,128,1073741824,1048576,8388608,4194304,8388608,4,128,32768,128,512,4096,67108864,1,8388608,128,4096,32768,1073741824,128,32,1048576,16777216,1048576,262144,4194304);
        Solution2835 s = new Solution2835();
        System.out.println(s.minOperations(nums, 89));
    }
    public int minOperations(List<Integer> nums, int target) {
        int[] t = new int[31];
        int[] cnt = new int[31];
        for (Integer num : nums) {
            for (int i = 0; i < 31; i++) {
                if (((num >> i) & 1) == 1) {
                    cnt[i]++;
                }
            }
        }
        for (int i = 0; i < 31; i++) {
            if (((target >> i) & 1) == 1) {
                t[i]++;
            }
        }
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            if (t[i] == 0) {
                continue;
            }
            if (t[i] != 0 && cnt[i] >= t[i]) {
                cnt[i] -= t[i];
                t[i] = 0;
                continue;
            }
            if (dfs(i, 1 << i, cnt)) {
                t[i] -= 1;
                continue;
            }
            boolean f = false;
            for (int j = i + 1; j < 31; j++) {
                if (cnt[j] != 0) {
                    f = true;
                    int k = j;
                    while (k > i) {
                        cnt[k] -= 1;
                        cnt[k - 1] += 2;
                        k--;
                        ans += 1;
                    }
                    cnt[i] -= 1;
                    break;
                }
            }
            if (!f) {
                return -1;
            }
        }
        return ans;    
    }

    boolean dfs(int i, int j, int[] cnt) {
        if (i == -1) {
            return false;
        } 
        if (cnt[i] > 0) {
            int v = 1 << i;
            int k = j / v;
            if (cnt[i] >= k) {
                cnt[i] -= k;
                return true;
            }
            boolean c = dfs(i - 1, j - cnt[i] * v, cnt);
            if (c) {
                cnt[i] = 0;
                return true;
            }
            return false;
        }
        return dfs(i - 1, j, cnt);
    }
}
// @lc code=end

