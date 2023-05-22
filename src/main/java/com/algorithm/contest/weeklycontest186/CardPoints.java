package com.algorithm.contest.weeklycontest186;

public class CardPoints {

    public static void main(String[] args) {
        CardPoints c = new CardPoints();
        System.out.println(c.maxScore(new int[] {1,2,3,4,5,6,1}, 3));
        System.out.println(c.maxScore(new int[] {9,7,7,9,7,7,9}, 7));
        System.out.println(c.maxScore(new int[] {96,90,41,82,39,74,64,50,30}, 8));
    }
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + cardPoints[i];
        }
        int len = n - k, res = Integer.MAX_VALUE;
        for (int j = 0; j <= k; j++) {
            res = Math.min(res, sum[j + len] - sum[j]);
        }
        return sum[n] - res;
    }
}
