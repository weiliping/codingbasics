package com.algorithm.contest.weeklycontest330;

public class MonkeyMove {
    public static void main(String[] args) {
        // System.out.println(monkeyMove(3));
        // System.out.println(monkeyMove(4));
        // System.out.println(monkeyMove(500000003)); // 1000000006
        // System.out.println(monkeyMove(874392046));
        // System.out.println(monkeyMove(10000));
        // System.out.println(monkeyMove30(30));

        int j = 1;
        for (int i = 0; i < 10; i++) {
            j *= 10;
            System.out.println(monkeyMoveN(j));
        }
    }

    public static final int MOD = (int) (1e9 + 7);

    public static int monkeyMove(int n) {
        int s = monkeyMoveN(n) - 2;
        return s < 0 ? s + MOD : s;
    }

    private static int monkeyMoveN(int n) {
        if (n <= 30) {
            return monkeyMove30(n);
        }
        if (n <= 100) {
            return monkeyMove100(n);
        }
        if (n <= 1000) {
            return monkeyMove1000(n);
        }
        if (n <= 10000) {
            return monkeyMove10000(n);
        }
        if (n <= 100000) {
            return monkeyMove100000(n);
        }
        if (n <= 1000000) {
            return monkeyMove1000000(n);
        }
        return monkeyMove10000000(n);
    }

    private static int monkeyMove30(int n) {
        int r = (1 << n);
        if (r > MOD) {
            r %= MOD;
        }
        return r;
    }

    private static int monkeyMove100(int n) {
        int r = monkeyMove30(30);
        long res = 1l;
        while (n > 30) {
            res *= r;
            if (res > MOD) {
                res %= MOD;
            }
            n -= 30;
        }
        res *= monkeyMove30(n);
        return (int) (res % MOD);
    }

    private static int monkeyMove1000(int n) {
        int r = monkeyMove100(100);
        long res = 1l;
        while (n > 100) {
            res *= r;
            if (res > MOD) {
                res %= MOD;
            }
            n -= 100;
        }
        res *= monkeyMove100(n);
        return (int) (res % MOD);
    }

    private static int monkeyMove10000(int n) {
        int r = monkeyMove1000(1000);
        long res = 1l;
        while (n > 1000) {
            res *= r;
            if (res > MOD) {
                res %= MOD;
            }
            n -= 1000;
        }
        res *= monkeyMove1000(n);
        return (int) (res % MOD);
    }

    private static int monkeyMove100000(int n) {
        int r = monkeyMove1000(10000);
        long res = 1l;
        while (n > 10000) {
            res *= r;
            if (res > MOD) {
                res %= MOD;
            }
            n -= 10000;
        }
        res *= monkeyMove10000(n);
        return (int) (res % MOD);
    }

    private static int monkeyMove1000000(int n) {
        int r = monkeyMove100000(100000);
        long res = 1l;
        while (n > 100000) {
            res *= r;
            if (res > MOD) {
                res %= MOD;
            }
            n -= 100000;
        }
        res *= monkeyMove100000(n);
        return (int) (res % MOD);
    }

    private static int monkeyMove10000000(int n) {
        int r = monkeyMove1000000(1000000);
        long res = 1l;
        while (n > 1000000) {
            res *= r;
            if (res > MOD) {
                res %= MOD;
            }
            n -= 1000000;
        }
        res *= monkeyMove1000000(n);
        return (int) (res % MOD);
    }
}
