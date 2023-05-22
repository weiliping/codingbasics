package com.algorithm.contest.weeklycontest183;

public class NumSteps {
    public static void main(String[] args) {
        NumSteps s = new NumSteps();
        System.out.println(s.numSteps("1101"));
        System.out.println(s.numSteps("10"));
        System.out.println(s.numSteps("1"));
    }

    public int numSteps(String s) {
        char[] chrs = s.toCharArray();
        int cnt = 0, n = chrs.length;
        int pre = 0;
        for (int i = n - 1; i > 0; i--) {
            if (chrs[i] == '1') {
                cnt += 2;
                int j = i;
                while (j >= 0 && chrs[j] == '1') {
                    chrs[j--] = '0';
                }
                if (j < 0) {
                    pre = 1;
                } else {
                    chrs[j] = '1';
                }
                continue;
            }
            cnt++;
        }
        if (pre == 1) {
            if (chrs[0] == '0') {
                cnt++;
            } else {
                cnt += 2;
            }
        }
        return cnt;
    }
}
