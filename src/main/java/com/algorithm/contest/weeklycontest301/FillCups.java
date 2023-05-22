package com.algorithm.contest.weeklycontest301;

public class FillCups {
    public static void main(String[] args) {
        System.out.println(fillCups(new int[] { 5, 4, 4 }));
        System.out.println(fillCups(new int[] { 1, 4, 2 }));
        System.out.println(fillCups(new int[] { 5, 0, 0 }));
    }

    public static int fillCups(int[] amount) {
        int cnt = 0;
        int lInd = 0, mInd = 1, hInd = 2;
        while (amount[lInd] > 0) {
            if (amount[mInd] > amount[hInd]) {
                int t = hInd;
                hInd = mInd;
                mInd = t;
            }
            if (amount[lInd] > amount[hInd]) {
                int t = hInd;
                hInd = lInd;
                lInd = t;
            }
            if (amount[lInd] > amount[mInd]) {
                int t = mInd;
                mInd = lInd;
                lInd = t;
            }
            int diff = amount[hInd] - amount[lInd];
            if (diff == 0) {
                diff = 1;
            }
            if (diff < amount[mInd]) {
                cnt += diff;
                amount[hInd] -= diff;
                amount[mInd] -= diff;
            } else {
                cnt += amount[mInd];
                amount[hInd] -= amount[mInd];
                amount[mInd] = 0;
            }
        }

        cnt += amount[hInd];
        return cnt;
    }
}
