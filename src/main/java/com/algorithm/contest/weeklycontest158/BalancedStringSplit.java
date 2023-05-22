package com.algorithm.contest.weeklycontest158;

public class BalancedStringSplit {
    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
        System.out.println(balancedStringSplit("RLLLLRRRLR"));
        System.out.println(balancedStringSplit("LLLLRRRR"));
        System.out.println(balancedStringSplit("RLRRRLLRLL"));
    }

    public static int balancedStringSplit(String s) {
        int cns = 0, cnt = 0, n = s.length();
        char[] chrs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (chrs[i] == 'R') {
                cns++;
            } else {
                cns--;
            }
            if (cns == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
