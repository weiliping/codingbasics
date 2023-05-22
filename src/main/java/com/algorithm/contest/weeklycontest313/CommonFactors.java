package com.algorithm.contest.weeklycontest313;

public class CommonFactors {
    public static void main(String[] args) {
        System.out.println(commonFactors(12, 6));
        System.out.println(commonFactors(25, 30));
        System.out.println(commonFactors(25, 100));
        System.out.println(commonFactors(43, 945));
    }

    public static int commonFactors(int a, int b) {
        int c = a > b ? gcd(a, b) : gcd(b, a);
        return count(c);
    }

    public static int gcd(int a, int b) {
        int c = a % b;
        if (c == 0) {
            return b;
        }
        return gcd(b, c);
    }

    public static int count(int a) {
        if (a == 1) {
            return 1;
        }
        int h = a >> 1;
        int cnt = 2;
        for (int i = 2; i <= h; i++) {
            int c = a % i;
            if (c == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}