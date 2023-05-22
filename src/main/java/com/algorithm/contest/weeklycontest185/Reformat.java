package com.algorithm.contest.weeklycontest185;

public class Reformat {
    public static void main(String[] args) {
        Reformat r = new Reformat();
        System.out.println(r.reformat("a0b1c2"));
    }
    public String reformat(String s) {
        char[] chrs = s.toCharArray();
        int n = chrs.length;
        int numCnt = 0;
        for (char c : chrs) {
            if (Character.isDigit(c)) {
                numCnt++;
            }
        }
        int half = n >> 1;
        boolean numOod = true;
        if ((n & 1) == 0) {
            if (numCnt != half) {
                return "";
            }
        } else {
            if (numCnt != half && numCnt != half + 1) {
                return "";
            }
            if (numCnt == half + 1) {
                numOod = false;
            }
        }
        char[] chs = new char[n];
        int numInd = 0, charInd = 1;
        if (numOod) {
            numInd = 1;
            charInd = 0;
        }

        for (int i = 0; i < n; i++) {
            if (Character.isDigit(chrs[i])) {
                chs[numInd] = chrs[i];
                numInd += 2;
                continue;
            }
            chs[charInd] = chrs[i];
            charInd += 2;
        }
        return new String(chs);
    }
}
