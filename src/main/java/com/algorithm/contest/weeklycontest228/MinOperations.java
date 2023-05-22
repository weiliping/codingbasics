package com.algorithm.contest.weeklycontest228;

public class MinOperations {
    public static void main(String[] args) {
        System.out.println(new MinOperations().minOperations("10101"));
    }
    public int minOperations(String s) {
        int zeroStartCnt = 0, oneCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            int v = s.charAt(i) - '0';
            if (i % 2 == v) {
                oneCnt++;
            } else {
                zeroStartCnt++;
            }
        }
        return Math.min(zeroStartCnt, oneCnt);
    }
}
