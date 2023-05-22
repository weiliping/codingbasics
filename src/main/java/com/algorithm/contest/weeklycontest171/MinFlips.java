package com.algorithm.contest.weeklycontest171;

public class MinFlips {

    public static void main(String[] args) {
        MinFlips m = new MinFlips();
        System.out.println(m.minFlips(2, 6, 5));
        System.out.println(m.minFlips(4, 2, 7));
        System.out.println(m.minFlips(1, 2, 3));
    }
    public int minFlips(int a, int b, int c) {
        int cnt = 0;

        for (int i = 0; i < 31; i++) {
            int t = ((c >> i) & 1);
            if (t == 0) {
                if (((b >> i) & 1) == 1) {
                    cnt++;
                }
                if (((a >> i) & 1) == 1) {
                    cnt++;
                }
                continue;
            }
            if (((b >> i) & 1) == 0 && ((a >> i) & 1) == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
