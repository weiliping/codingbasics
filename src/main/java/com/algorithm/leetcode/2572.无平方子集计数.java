package com.algorithm.leetcode;
/*
 * @lc app=leetcode.cn id=2572 lang=java
 *
 * [2572] 无平方子集计数
 */

// @lc code=start
class Solution {
    static final int[] PRIMES = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    static final int MOD = (int)1e9 + 7, MX = 30, L_PRIMES = 10, M = 1 << L_PRIMES;
    static final int[] MASK_BIN = new int[MX + 1];
    static {
        for (int i = 2; i < MX + 1; i++) {
            for (int j = 0; j < L_PRIMES; j++) {
                int p = PRIMES[j];
                if (i % p == 0) {
                    if (i % (p * p) == 0) {
                        MASK_BIN[i] = -1;
                        break;
                    }
                    MASK_BIN[i] |= 1 << j;    
                }
            }
        }
    } 
    public int squareFreeSubsets(int[] nums) {
        int[] dp = new int[M];
        dp[0] = 1;
        for (int num : nums) {
            int mask = MASK_BIN[num];
            if (mask == -1) {
                continue;
            }
            for (int j = M - 1; j >= mask; j--) {
                if ((j | mask) == j) {
                    dp[j] = (dp[j] + dp[j ^ mask]) % MOD;
                }
            }
        }
        long ans = 0l;
        for (int v : dp) {
            ans += v;
        }
        return (int)((ans - 1) % MOD);
    }
}
// @lc code=end

