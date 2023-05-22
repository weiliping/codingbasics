package com.algorithm.contest.biweeklycontest56;

public class SumGame {
    public static void main(String[] args) {
        SumGame s = new SumGame();
        System.out.println(s.sumGame("5023"));
        System.out.println(s.sumGame("25??"));
        System.out.println(s.sumGame("74??"));
        System.out.println(s.sumGame("?3295???"));
    }
    public boolean sumGame(String num) {
        char[] chrs = num.toCharArray();
        int leftQ = 0, rightQ = 0, sumL = 0, sumR = 0, len = chrs.length, n = len / 2;
        for (int i = 0; i < n; i++) {
            if (chrs[i] == '?') {
                leftQ++;
            } else {
                sumL += chrs[i] - '0';
            }
            int rInd = i + n;
            if (chrs[rInd] == '?') {
                rightQ++;
            } else {
                sumR += chrs[rInd] - '0';
            }
        }

        if (sumL < sumR) {
            return compare(rightQ, leftQ, sumR, sumL);
        } else {
            return compare(leftQ, rightQ, sumL, sumR);
        }
    }

    boolean compare(int lQ, int rQ, int sumL, int sumR) {
        int lB = lQ / 2, lA = lQ - lB, rB = rQ / 2, rA = rQ - rB;
        if (sumL + 9 * lA > sumR + 9 * (lA > lB ? rA : rB)) {
            return true;
        }
        if (sumL + 9 * (rA > rB ? lA : lB) < sumR + 9 * rA) {
            return true;
        }
        return false;
    }
}
