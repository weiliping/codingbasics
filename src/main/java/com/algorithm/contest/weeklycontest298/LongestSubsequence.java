package com.algorithm.contest.weeklycontest298;

/**
 * 给你一个二进制字符串s和一个正整数k。
 *
 * 请你返回s的最长子序列，且该子序列对应的二进制数字小于等于 k。
 *
 * 注意：
 *
 * 子序列可以有 前导 0。
 * 空字符串视为0。
 * 子序列是指从一个字符串中删除零个或者多个字符后，不改变顺序得到的剩余字符序列。
 *
 *
 * 示例 1：
 *
 * 输入：s = "1001010", k = 5
 * 输出：5
 * 解释：s 中小于等于 5 的最长子序列是 "00010" ，对应的十进制数字是 2 。
 * 注意 "00100" 和 "00101" 也是可行的最长子序列，十进制分别对应 4 和 5 。
 * 最长子序列的长度为 5 ，所以返回 5 。
 * 示例 2：
 *
 * 输入：s = "00101001", k = 1
 * 输出：6
 * 解释："000001" 是 s 中小于等于 1 的最长子序列，对应的十进制数字是 1 。
 * 最长子序列的长度为 6 ，所以返回 6 。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s[i] 要么是'0'，要么是'1' 。
 * 1 <= k <= 109
 *
 */
public class LongestSubsequence {
    public static void main(String[] args) {
        System.out.println(longestSubsequence("1001010", 5));
        System.out.println(longestSubsequence("00101001", 1));
    }

    public static int longestSubsequence(String s, int k) {
        String kStr = Long.toBinaryString(k);
        int m = kStr.length(), n = s.length();
        if (n < m) {
            return n;
        }
        int mid = n - m;
        int cnt = 0;
        for (int i = 0; i < mid; i++) {
            if (s.charAt(i) == '0') {
                cnt++;
            }
        }
        for (int i = 0; i < m; i++) {
            if (s.charAt(mid + i) == kStr.charAt(i)) {
                continue;
            }
            return s.charAt(mid + i) > kStr.charAt(i) ? cnt + m - 1 : cnt + m;
        }
        return cnt + m;
    }
}
