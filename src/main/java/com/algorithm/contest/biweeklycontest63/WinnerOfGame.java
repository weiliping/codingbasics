package com.algorithm.contest.biweeklycontest63;

public class WinnerOfGame {
    public static void main(String[] args) {
        WinnerOfGame w = new WinnerOfGame();
//        System.out.println(w.winnerOfGame("AAABABB"));
//        System.out.println(w.winnerOfGame("AA"));
//        System.out.println(w.winnerOfGame("ABBBBBBBAAA"));
        System.out.println(w.winnerOfGame("AAAABBBBBBAAA"));
    }
    public boolean winnerOfGame(String colors) {
        int cntA = 0, cntB = 0;
        char[] chrs = colors.toCharArray();

        int i = 0, n = chrs.length, j = 0;
        Character pre = null;
        while (i < n) {
            if (pre == null) {
                j = i;
                pre = chrs[i++];
                continue;
            }
            while(i < n && pre == chrs[i]) {
                i++;
            }
            if (i - j > 2) {
                if (pre == 'A') {
                    cntA += i - j - 2;
                } else {
                    cntB += i - j - 2;
                }
            }
            if (i < n) {
                j = i;
                pre = chrs[i];
                i++;
            }
        }
        return cntA > cntB;
    }
}
