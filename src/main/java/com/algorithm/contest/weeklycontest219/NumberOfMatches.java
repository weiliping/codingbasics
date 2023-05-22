package com.algorithm.contest.weeklycontest219;

public class NumberOfMatches {
    public static void main(String[] args) {

    }
    public int numberOfMatches(int n) {
        int cnt = 0, k;
        while (n > 1) {
            k = n / 2;
            cnt += k;
            n = k + (n & 1);
        }
        return cnt;
    }
}
