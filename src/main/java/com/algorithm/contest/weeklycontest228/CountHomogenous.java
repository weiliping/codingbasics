package com.algorithm.contest.weeklycontest228;

import java.util.Stack;

public class CountHomogenous {
    public static void main(String[] args) {
        System.out.println(countHomogenousI("abbcccaa"));
//        System.out.println(countHomogenous("ax"));
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
