package com.algorithm.contest.weeklycontest159;

public class BalancedString {

    public static void main(String[] args) {
        System.out.println(balancedString("QWER"));
        System.out.println(balancedString("QQWE"));
        System.out.println(balancedString("QQQW"));
        System.out.println(balancedString("QQQQ"));
        System.out.println(balancedString("WQWRQQQW"));
        System.out.println(balancedString("WWWEQRQEWWQQQWQQQWEWEEWRRRRRWWQE"));
        System.out.println(balancedString("WWQQRRRRQRQQ"));
    }

    public static int balancedString(String s) {

        char[] chrs = s.toCharArray();
        int n = chrs.length, m = n / 4;
        int[] cnts = new int[4];
        for (int i = 0; i < n; i++) {
            cnts[toInd(chrs[i])]++;
        }
        int k = 0;
        for (int i = 0; i < 4; i++) {
            if (cnts[i] > m) {
                k += cnts[i] - m;
            }
        }
        if (k == 0) {
            return 0;
        }

        int cns = Integer.MAX_VALUE;
        int l = 0;
        for (int r = 0; r < n; r++) {
            int ind = toInd(chrs[r]);
            if (--cnts[ind] >= m) {
                k--;
            }

            while (k == 0) {
                cns = Math.min(cns, r - l + 1);
                int in = toInd(chrs[l]);
                if (++cnts[in] > m) {
                    k++;
                }
                l++;
            }
        }
        return cns;
    }

    static int toInd(char c) {
        if (c == 'Q') {
            return 0;
        }
        if (c == 'W') {
            return 1;
        }
        if (c == 'E') {
            return 2;
        }
        return 3;
    }
}
