package com.algorithm.contest.weeklycontest228;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/count-number-of-homogenous-substrings/
 * 1759. 统计同构子字符串的数目
 * 给你一个字符串 s ，返回 s 中 同构子字符串 的数目。由于答案可能很大，只需返回对 10^9 + 7 取余 后的结果。
 *
 * 同构字符串 的定义为：如果一个字符串中的所有字符都相同，那么该字符串就是同构字符串。
 *
 * 子字符串 是字符串中的一个连续字符序列。
 *
 *
 * 示例 1：
 *
 * 输入：s = "abbcccaa"
 * 输出：13
 * 解释：同构子字符串如下所列：
 * "a"   出现 3 次。
 * "aa"  出现 1 次。
 * "b"   出现 2 次。
 * "bb"  出现 1 次。
 * "c"   出现 3 次。
 * "cc"  出现 2 次。
 * "ccc" 出现 1 次。
 * 3 + 1 + 2 + 1 + 3 + 2 + 1 = 13
 * 示例 2：
 *
 * 输入：s = "xy"
 * 输出：2
 * 解释：同构子字符串是 "x" 和 "y" 。
 * 示例 3：
 *
 * 输入：s = "zzzzz"
 * 输出：15
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 10^5
 * s 由小写字符串组成
 *
 */
public class CountHomogenous {
    public static void main(String[] args) {
        System.out.println(countHomogenousI("abbcccaa"));
        System.out.println(countHomogenous("ax"));
    }

    static final int MOD = (int)1e9 + 7;

    public static int countHomogenousII(String s) {
    	char[] chrs = s.toCharArray();
        int n = chrs.length;
        char cur = chrs[0];
        long cnt = 0l, subCnt = 1;
        for (int i = 1; i < n; i++) {
            if (cur == chrs[i]) {
                subCnt++;
                continue;
            }
            cnt += (subCnt + 1) * subCnt / 2;
            cur = chrs[i];
            subCnt = 1;
        }
        cnt += (subCnt + 1) * subCnt / 2;
        return (int)(cnt % MOD);
    }

    public static int countHomogenousI(String s) {
        int l = 0, r = 0, len = s.length();
        long res = 0l;
        while (r < len) {
            if (s.charAt(l) == s.charAt(r)) {
                r++;
                continue;
            }
            res += cal(l, r);
            l = r;
            r++;
        }
        res += cal(l, r);
        return (int) res % MOD;
    }

    static long cal(int l, int r) {
        int cnt = r - l;
        return (long) (cnt * (cnt + 1) / 2);
    }

    public static int countHomogenous(String s) {
        Stack<Pair> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (st.isEmpty() || c != st.peek().c) {
                st.push(new Pair(c, 1));
                continue;
            }
            Pair p = st.pop();
            p.freq++;
            st.push(p);
        }
        long res = 0l;
        while (!st.isEmpty()) {
            Pair p = st.pop();
            res += getResult(p.freq);
        }
        return (int) res % MOD;
    }


    private static long getResult(int i) {
        long[] dp = new long[i + 1];
        for (int j = 1; j <= i; j++) {
            dp[j] = (long)j + dp[j - 1];
        }
        return dp[i];
    }
}

class Pair {
    char c;
    int freq;

    public Pair(char ch, int f) {
        c = ch;
        freq = f;
    }
}
