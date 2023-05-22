package com.algorithm.contest.weeklycontest213;

public class CountVowelStrings {

    public static void main(String[] args) {
        CountVowelStrings c = new CountVowelStrings();
        System.out.println(c.countVowelStrings(1));
        System.out.println(c.countVowelStrings(2));
        System.out.println(c.countVowelStrings(33));
    }
    static int[][] dp = new int[51][5];
    static boolean flag = false;
    public int countVowelStrings(int n) {
        if (!flag) {
            for (int j = 0; j < 5; j++) {
                dp[1][j] = 1;
            }

            for (int i = 2; i < 51; i++) {
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k <= j; k++) {
                        dp[i][j] += dp[i - 1][k];
                    }
                }
            }
            flag = true;
        }
        int cnts = 0;
        for (int i = 0; i < 5; i++) {
            cnts += dp[n][i];
        }
        return cnts;
    }
}
