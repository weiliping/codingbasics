package com.algorithm.contest.weeklycontest186;

public class MaxScore {

    public static void main(String[] args) {
        MaxScore m = new MaxScore();
//        System.out.println(m.maxScore("011101"));
//        System.out.println(m.maxScore("00111"));
//        System.out.println(m.maxScore("1111"));
        System.out.println(m.maxScore("00"));
    }
    public int maxScore(String s) {
        char[] chrs = s.toCharArray();
        int n = chrs.length;
        int[] zeroNum = new int[n];
        zeroNum[0] = (chrs[0] == '0' ? 1 : 0);
        for (int i = 1; i < n; i++) {
            zeroNum[i] = zeroNum[i - 1] + (chrs[i] == '0' ? 1 : 0);
        }
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            int sub = n - i - 1 - zeroNum[n - 1] + (zeroNum[i] << 1);
            if (cnt < sub) {
                cnt = sub;
            }
        }
        return cnt;
    }
}
