package com.algorithm.dynamicprogramming;

import java.util.Arrays;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static Solution main;
    private static final long MOD = (long) 1e9 + 7;

    private static final int LEN = 101;
    private static final int HALF_L = 50;
    private static final int BIN_LEN = 6;

    public static void main(String[] args) {
        main = new Solution();
        long[][] dp = new long[LEN][LEN];
        long[][] dp1 = new long[LEN][LEN];
        long[][] dpsum = new long[LEN][LEN];
        for (int i = 0; i < LEN; i++) {
            Arrays.fill(dp[i], 0);
        }
        long[] pow2 = new long[BIN_LEN];
        pow2[0] = 1;
        for (int i = 1; i < BIN_LEN; i++) {
            pow2[i] = pow2[i - 1] * 2;
        }
        dp[1][1] = 1;
        for (int i = 2; i < LEN; i++) {
            for (int j = 1; j <= i; j++) {
                long temp = 0;
                for (int k = j + 1; k < i; k++) {
                    temp += dp[i - j][k];
                    if (temp >= MOD) {
                        temp -= MOD;
                    }
                }
                if (i == j) {
                    temp++;
                    if (temp >= MOD) {
                        temp -= MOD;
                    }
                }
                dp[i][j] = temp;
            }
        }
        for (int k = 0; k < LEN; k++) {
            Arrays.fill(dp1[k], 0);
        }
        for (int i = 0; i < LEN; i++) {
            dpsum[i][0] = 0;
        }
        for (int i = 0; i < LEN; i++) {
            for (int j = 1; j < LEN; j++) {
                dpsum[i][j] = dpsum[i][j - 1] + dp[i][j];
                if (dpsum[i][j] >= MOD) {
                    dpsum[i][j] -= MOD;
                }
            }
        }
        for (int k = 1; k < LEN; k++) {
            for (int i = k; i < LEN; i++) {
                if (i == k) {
                    dp1[i][k] = 1;
                } else {
                    dp1[i][k] = dp1[i - 1][k] + dp[i][k];
                    if (dp1[i][k] >= MOD) {
                        dp1[i][k] -= MOD;
                    }
                }
            }
        }
        int ii = 0;
        for (long[] d : dp) {
            System.out.print("i = " + ii);
            System.out.println(Arrays.toString(d));
            ii++;
        }
        // for (long[] d : dp1) {
        // System.out.println(Arrays.toString(d));
        // }
        // for (long[] d : dpsum) {
        // System.out.println(Arrays.toString(d));
        // }
        long[][][] list = new long[LEN][BIN_LEN][BIN_LEN];
        long[] all = new long[LEN];
        for (int i = 0; i < LEN; i++) {
            for (int j = 0; j < BIN_LEN; j++) {
                for (int k = 0; k < BIN_LEN; k++) {
                    list[i][j][k] = 0;
                }
            }
            all[i] = 0;
            for (int j = 1; j <= Math.min(i / 2, HALF_L); j++) {
                for (int k = j + 1; k <= i - j; k++) {
                    long repValue = 0;
                    if (j + k == i) {
                        repValue++;
                    }
                    repValue += dpsum[i - j - k][i - j - k] - dpsum[i - j - k][k];
                    if (repValue < 0) {
                        repValue += MOD;
                    }
                    if (repValue >= MOD) {
                        repValue -= MOD;
                    }
                    if (k < BIN_LEN) {
                        list[i][j][k] = repValue;
                    } else {
                        all[i] += repValue;
                    }
                }
            }
            all[i] %= MOD;
        }
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedOutputStream bos = new BufferedOutputStream(System.out);
        // String eol = System.getProperty("line.separator");
        // byte[] eolb = eol.getBytes();
        // try {
        // String str = br.readLine();
        // int t = Integer.parseInt(str);
        // for (int i = 0; i < t; i++) {
        // str = br.readLine();
        // int blank = str.indexOf(" ");
        int a = 1; // Integer.parseInt(str.substring(0, blank));
        int b = 5; // Integer.parseInt(str.substring(blank + 1));
        long ans = 0;
        if (b == 0) {
            System.out.println(a);
            // bos.write(new Long(a).toString().getBytes());
        } else if (a == 0) {
            for (int d = 0; d <= b; d++) {
                long temp = dp1[b][d];
                ans += temp;
            }
            ans %= MOD;
            System.out.println(ans);
            // bos.write(new Long(ans).toString().getBytes());
        } else {
            for (int d = 0; d < b; d++) {
                long temp = dp1[b - 1][d];
                long mult = 2;
                temp *= mult;
                ans += temp;
            }
            ans %= MOD;
            for (int d = 0; d < BIN_LEN; d++) {
                for (int e = d + 1; e < BIN_LEN; e++) {
                    long repValue = list[b][d][e];
                    long temp = repValue * Math.min(a + 1, pow2[e] - pow2[d]);
                    ans += temp;
                    ans %= MOD;
                }
            }
            ans %= MOD;
            long temp = all[b] * (a + 1);
            ans += temp;
            ans += a + 2;
            ans %= MOD;
            System.out.println(ans);
            // bos.write(new Long(ans).toString().getBytes());
        }
        // bos.write(eolb);
        // }
        // bos.flush();
        // } catch (IOException ioe) {
        // ioe.printStackTrace();
        // }
    }
}
