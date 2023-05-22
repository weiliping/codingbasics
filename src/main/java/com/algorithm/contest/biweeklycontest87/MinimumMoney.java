package com.algorithm.contest.biweeklycontest87;

public class MinimumMoney {

    public static void main(String[] args) {
        int[][] trans = new int[][] { { 2, 1 }, { 5, 0 }, { 4, 2 } };
        System.out.println(minimumMoney(trans));
        int[][] trans1 = new int[][] { { 3, 0 }, { 0, 3 } };
        System.out.println(minimumMoney(trans1));
    }

    public static long minimumMoney(int[][] transactions) {
        long paySum = 0l;
        int maxPay = 0;
        for (int[] trans : transactions) {
            paySum += Math.max(trans[0] - trans[1], 0);
            maxPay = Math.max(maxPay, Math.min(trans[0], trans[1]));
        }
        return paySum + maxPay;
    }
}
