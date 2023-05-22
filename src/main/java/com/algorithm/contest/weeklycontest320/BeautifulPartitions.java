package com.algorithm.contest.weeklycontest320;

public class BeautifulPartitions {
    public final static int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        // String s = "23542185131";
        // int k = 3, minLength = 2;
        // System.out.println(beautifulPartitionsI(s, k, minLength)); // 3

        // String s1 = "23542185131";
        // int k1 = 3, minLength1 = 3;
        // System.out.println(beautifulPartitionsI(s1, k1, minLength1)); // 1

        // String s2 = "3312958";
        // int k2 = 3, minLength2 = 1;
        // System.out.println(beautifulPartitionsI(s2, k2, minLength2)); // 1

        // String s3 =
        // "38737664528187667419688711491264689456727783517411923972227428986913355726499196714767766496823989939585234733115996197583248799596843464726921";
        // int k3 = 36, minLength3 = 1;
        // System.out.println(beautifulPartitionsI(s3, k3, minLength3)); // 0

        String s4 = "783938233588472343879134266968";
        int k4 = 4, minLength4 = 6;

        System.out.println(beautifulPartitionsII(s4, k4, minLength4));
    }

    public static int beautifulPartitionsII(String s, int k, int minLength) {
        int n = s.length();
        if (k * minLength > n || !isPrime(s.charAt(0)) || isPrime(s.charAt(n - 1))) {
            return 0;
        }
        int[][] f = new int[k + 1][n + 1];
        f[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            int sum = 0;
            for (int j = i * minLength; j + (k - i) * minLength <= n; j++) {
                if (canPart(s, j - minLength, n)) {
                    sum += f[i - 1][j - minLength];
                    if (sum >= MOD) {
                        sum -= MOD;
                    }
                }
                if (canPart(s, j, n)) {
                    f[i][j] = sum;
                }
            }
        }
        return f[k][n];
    }

    public static boolean canPart(String s, int j, int n) {
        return j == 0 || j == n || !isPrime(s.charAt(j - 1)) && isPrime(s.charAt(j));
    }

    public static int beautifulPartitionsI(String s, int k, int minLength) {
        int n = s.length();
        int pre = -1, cnt = 0;
        boolean[] flags = new boolean[n];
        for (int i = 0; i < n - 1; i++) {
            if (!isPrime(s.charAt(i)) && isPrime(s.charAt(i + 1))) {
                flags[i] = true;
                if (i - pre >= minLength) {
                    cnt++;
                    pre = i;
                }
            }
        }
        cnt++;
        if (k > cnt) {
            return 0;
        }
        if (k == 1 || k == cnt) {
            return 1;
        }
        int t = cnt + 1;
        int[][] res = new int[t][k + 1];
        for (int i = 0; i < t; i++) {
            res[i][1] = 1;
            if (i > 1) {
                res[i][2] = i - 1;
            }
        }
        for (int i = 2; i < t; i++) {
            for (int j = 2; j <= k; j++) {
                res[i][j] = res[i - 1][j] + res[i - 1][j - 1];
                if (res[i][j] > MOD) {
                    res[i][j] -= MOD;
                }
            }
        }
        return res[cnt][k];
    }

    public static int beautifulPartitions(String s, int k, int minLength) {
        int n = s.length();
        boolean[][] cnts = new boolean[n][n];
        for (int i = 0; i < n - minLength; i++) {
            for (int j = i + minLength - 1; j < n - minLength; j++) {
                if (!isPrime(s.charAt(j)) && isPrime(s.charAt(j + 1))) {
                    cnts[i][j] = true;
                }
            }
        }
        int[] res = new int[1];
        dfs(0, k - 1, cnts, res, minLength, n);
        return res[0];
    }

    static void dfs(int i, int k, boolean[][] cnts, int[] res, int minLength, int n) {
        if (i + minLength >= n) {
            return;
        }
        if (k == 0) {
            res[0]++;
            if (res[0] > MOD) {
                res[0] -= MOD;
            }
            return;
        }
        for (int j = i + minLength - 1; j < n; j++) {
            if (cnts[i][j]) {
                dfs(j + 1, k - 1, cnts, res, minLength, n);
            }
        }
    }

    public static boolean isPrime(char s) {
        return s == '2' || s == '3' || s == '5' || s == '7';
    }
}
