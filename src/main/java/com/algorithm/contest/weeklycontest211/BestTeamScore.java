package com.algorithm.contest.weeklycontest211;

import java.util.Arrays;

public class BestTeamScore {
    public static void main(String[] args) {
        BestTeamScore b = new BestTeamScore();
        int[] scores = new int[]{1, 3, 5, 10, 15};
        int[] ages = new int[]{1, 2, 3, 4, 5};
        System.out.println(b.bestTeamScore(scores, ages));

        int[] scores1 = new int[]{4, 5, 6, 5};
        int[] ages1 = new int[]{2, 1, 2, 1};
        System.out.println(b.bestTeamScore(scores1, ages1));

        int[] scores2 = new int[]{1, 2, 3, 5};
        int[] ages2 = new int[]{8, 9, 10, 1};
        System.out.println(b.bestTeamScore(scores2, ages2));
        int[] scores3 = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] ages3 = new int[]{811, 364, 124, 873, 790, 656, 581, 446, 885, 134};
        System.out.println(b.bestTeamScore(scores3, ages3));

        int[] scores4 = new int[]{1, 3, 7, 3, 2, 4, 10, 7, 5};
        int[] ages4 = new int[]{4, 5, 2, 1, 1, 2, 4, 1, 4};
        System.out.println(b.bestTeamScore(scores4, ages4));
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] re = new int[n][2];

        for (int i = 0; i < n; i++) {
            re[i] = new int[]{ages[i], scores[i]};
        }
        Arrays.sort(re, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        int[] dp = new int[n];
        dp[0] = re[0][1];
        int cnt = dp[0];
        for (int i = 1; i < n; i++) {
            int subMax = 0;
            for (int j = 0; j < i; j++) {
                if (re[j][1] <= re[i][1] && subMax < dp[j]) {
                    subMax = dp[j];
                }
            }
            dp[i] = subMax + re[i][1];
            cnt = Math.max(cnt, dp[i]);
        }
        return cnt;
    }
}
