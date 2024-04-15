package com.algorithm.leetcode;
/*
 * @lc app=leetcode.cn id=2935 lang=java
 *
 * [2935] 找出强数对的最大异或值 II
 */

// @lc code=start
import java.util.Arrays;

class TrieNode {
    int i;
    int v;
    TrieNode[] child = new TrieNode[2];

    public TrieNode(int i, int v) {
        this.i = i;
        this.v = v;
    }
}

class Solution {
    static final int LEN = 20;
    public int maximumStrongPairXor(int[] nums) {
        TrieNode root = new TrieNode(LEN, -1);
        int n = nums.length;
        Arrays.sort(nums);
        TrieNode[] nodes = new TrieNode[n];
        for (int j = n - 1; j > -1; j--) {
            int num = nums[j];
            TrieNode p = root;
            for (int i = LEN - 1; i > -1; i--) {
                int v = ((num >> i) & 1);
                if (nodes[j] == null && v == 1) {
                    nodes[j] = p;
                }
                if (p.child[v] == null) {
                    p.child[v] = new TrieNode(i, v);
                }
                p = p.child[v];
            }
        }
        int res = 0;
        boolean find = false;
        for (int i = n - 1; i > -1; i--) {
            int num = nums[i];
            TrieNode p = nodes[i];
            int half = num >> 1;
            if ((num & 1) == 1) {
                half += 1;
            }
            int k = p.i - 1;
            if (p.child[0] != null && 0 == ((half >> k) & 1)) {
                p = p.child[0];
                int v = dfs(half, k - 1, p, num, false);
                if (v != -1) {
                    find = true;
                    res = Math.max(res, v | (1 << k) );    
                }
            }
            if (!find) {
                boolean less = false;
                int xorV = 0;
                p = nodes[i].child[1];
                for (int j = k - 1; j > -1; j--) {
                    int v = (nums[i] >> j) & 1;
                    int c = v ^ 1;
                    if (p.child[c] != null && (less || c <= v)) {
                        if (!less && c < v) {
                            less = true;
                        }
                        p = p.child[c];
                        xorV |= 1 << j;
                        continue;
                    }
                    p = p.child[v];
                }
                res = Math.max(res, xorV);
            }
        }
        return res;
    }
    public static int dfs(int half, int j, TrieNode p, int num, boolean isBigger) {
        if (j == -1) {
            return 0;
        }
        int s = (half >> j) & 1;
        int v = (num >> j) & 1;
        int c = v ^ 1;
        if (p.child[c] != null && (isBigger || c >= s)) {
            if (!isBigger && c > s) {
                isBigger = true;
            }
            int childV = dfs(half, j - 1, p.child[c], num, isBigger);
            if (childV != -1) {
                return (1 << j) | childV;
            }
        }
        if (p.child[v] != null && (isBigger || v >= s)) {
            if (!isBigger && v > s) {
                isBigger = true;
            }
            return dfs(half, j - 1, p.child[v], num, isBigger);
        }
        return -1;
    }
}
// @lc code=end

