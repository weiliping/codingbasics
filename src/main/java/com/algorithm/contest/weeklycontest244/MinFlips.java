package com.algorithm.contest.weeklycontest244;

public class MinFlips {
    public int minFlips(String s) {
        char[] chrs = s.toCharArray();

        int n = chrs.length;

        int[][] pre = new int[n][2];
        pre[0][0] = I(chrs[0], 1);
        pre[0][1] = I(chrs[0], 0);
        for (int i = 0; i < n; i++) {
            pre[i][0] = (i == 0 ? 0 : pre[i - 1][1]) + I(chrs[i], 1);
            pre[i][1] = (i == 0 ? 0 : pre[i - 1][0]) + I(chrs[i], 0);
        }

        int cnt = Math.min(pre[n - 1][0], pre[n - 1][1]);
        if (n % 2 == 1) {
            int[][] suf = new int[n][2];
            for (int i = n - 1; i >= 0; --i) {
                suf[i][0] = (i == n - 1 ? 0 : suf[i + 1][1]) + I(chrs[i], 1);
                suf[i][1] = (i == n - 1 ? 0 : suf[i + 1][0]) + I(chrs[i], 0);
            }

            for (int i = 0; i + 1 < n; ++i) {
                cnt = Math.min(cnt, pre[i][0] + suf[i + 1][0]);
                cnt = Math.min(cnt, pre[i][1] + suf[i + 1][1]);
            }
        }
        return cnt;
    }

    static int I(char i, int num) {
        return (i - '0') == num ? 1 : 0;
    }
}
