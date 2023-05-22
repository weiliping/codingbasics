package com.algorithm.dynamicprogramming;

public class MaxScore {

    /**
     * #1423
     * https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards
     * @param args
     */
    public static void main(String[] args) {
        int[] cardPoints = new int[] { 1, 2, 3, 4, 5, 6, 1 };
        int k = 3;
        System.out.println(maxScoreII(cardPoints, k));
//
//        int[] cardPoints1 = new int[] { 1, 2, 3, 4, 5, 6, 1 };
//        int k1 = 3;
//        System.out.println(maxScore(cardPoints1, k1));
    }

    public static int maxScore(int[] cardPoints, int k) {
        int ans = 0;
        if (k >= cardPoints.length) {
            for (int n : cardPoints) {
                ans += n;
            }
            return ans;
        }
        int l = cardPoints.length;
        for (int i = 0; i <= k; i++) {
            int sub = 0;
            for (int j = 0; j < i; j++) {
                sub += cardPoints[j];
            }
            int left = k - i;
            for (int j = l - 1; j > l - left - 1; j--) {
                sub += cardPoints[j];
            }
            ans = Math.max(ans, sub);
        }
        return ans;
    }

    public static int maxScoreII(int[] cardPoints, int k) {
        int sumL = 0, sumR = 0, len = cardPoints.length;
        for (int i = 0; i < k; i++) {
            sumL += cardPoints[i];
        }

        int ans = sumL;
        for (int l = 1; l <= k; l++) {
            sumL -= cardPoints[k - l];
            sumR += cardPoints[len - l];
            ans = Math.max(ans, sumL + sumR);
        }
        return ans;
    }
}
