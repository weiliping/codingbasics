package com.algorithm.contest.weeklycontest229;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/maximize-palindrome-length-from-subsequences/
 * 1771. 由子序列构造的最长回文串的长度 - Hard
 *
 * 给你两个字符串 word1 和 word2 ，请你按下述方法构造一个字符串：
 *
 * 从 word1 中选出某个 非空 子序列 subsequence1 。
 * 从 word2 中选出某个 非空 子序列 subsequence2 。
 * 连接两个子序列 subsequence1 + subsequence2 ，得到字符串。
 * 返回可按上述方法构造的最长 回文串 的 长度 。如果无法构造回文串，返回 0 。
 *
 * 字符串 s 的一个 子序列 是通过从 s 中删除一些（也可能不删除）字符而不更改其余字符的顺序生成的字符串。
 *
 * 回文串 是正着读和反着读结果一致的字符串。
 *
 * 示例 1：
 *
 * 输入：word1 = "cacb", word2 = "cbba"
 * 输出：5
 * 解释：从 word1 中选出 "ab" ，从 word2 中选出 "cba" ，得到回文串 "abcba" 。
 * 示例 2：
 *
 * 输入：word1 = "ab", word2 = "ab"
 * 输出：3
 * 解释：从 word1 中选出 "ab" ，从 word2 中选出 "a" ，得到回文串 "aba" 。
 * 示例 3：
 *
 * 输入：word1 = "aa", word2 = "bb"
 * 输出：0
 * 解释：无法按题面所述方法构造回文串，所以返回 0 。
 *  
 *
 * 提示：
 *
 * 1 <= word1.length, word2.length <= 1000
 * word1 和 word2 由小写英文字母组成
 *
 */
public class LongestPralindrome {

    public static void main(String[] args) {
        System.out.println(longestPralindromeI("afaaadacb", "ca"));
    }

    public static int longestPralindromeI(String word1, String word2) {
        return longestPalindromeSubseq(word1 + word2, word1.length());
    }

    public static int longestPalindromeSubseq(String s, int x) {
        char[] chs = s.toCharArray();
        int len = chs.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        int max = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (chs[i] == chs[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    if (i < x && j >= x) {
                        max = Math.max(max, dp[i][j]);
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return max;
    }

    public static int longestPralindrome(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        PriorityQueue<Integer>[] wInds = toKeyOrderMap(word2, m);

        int[][] dp = new int[n + 1][2];
        dp[0] = new int[] {0, m};
        for (int i = 1; i <= n; i++) {
            char c = word1.charAt(i - 1);
            int tInd = toInd(c);
            if (i == 1) {
                int ind = findInd(m, wInds[tInd]);
                int cnt = 0;
                if (ind != -1) {
                    cnt = 1;
                    wInds[tInd].poll();
                }
                dp[i] = new int[] {cnt, ind};
                continue;
            }
            dp[i] = getResult(dp[i - 1], dp[i - 2], wInds[tInd]);
        }
        if (dp[n][0] == 0) {
            return 0;
        }

        int res = 2 * dp[n][0];
        if (dp[n][1] > 0 || dp[n][0] == dp[n - 1][0]) {
            res++;
        }
        return res;
    }

    private static PriorityQueue<Integer>[] toKeyOrderMap(String word2, int m) {
        PriorityQueue<Integer>[] wInds = new PriorityQueue[26];
        for (int i = m - 1; i >= 0; i--) {
            char c = word2.charAt(i);
            int ind = toInd(c);
            if (wInds[ind] == null) {
                wInds[ind] = new PriorityQueue<>((a, b) -> b - a);
            }
            wInds[ind].add(i);
        }
        return wInds;
    }
    private static int[] getResult(int[] f, int[] l, PriorityQueue<Integer> queue) {
        int ind1 = findInd(f[1], queue);
        int cnt1 = ind1 == -1 ? f[0] : f[0] + 1;
        int ind2 = findInd(l[1], queue);
        int cnt2 = ind2 == -1 ? l[0] : l[0] + 1;
        if (cnt1 > cnt2) {
            return toRes(f, cnt1, ind1, queue);
        }
        return toRes(l, cnt2, ind2, queue);
    }

    private static int[] toRes(int[] r, int cnt, int ind, PriorityQueue<Integer> queue) {
        if (ind == -1) {
            return r;
        }
        queue.poll();
        return new int[] {cnt, ind};
    }

    private static int toInd(char c) {
        return (int) c - 'a';
    }

    private static int findInd(int startInd, PriorityQueue<Integer> queue) {
        if (queue == null || queue.isEmpty() || startInd < queue.peek()) {
            return -1;
        }
        return queue.peek();
    }
}
