package com.algorithm.contest.biweeklycontest153;

public class MaxActiveSectionsAfterTrade {
    public static void main(String[] args) {
        System.out.println(maxActiveSectionsAfterTrade("01"));
        System.out.println(maxActiveSectionsAfterTrade("0100"));
        System.out.println(maxActiveSectionsAfterTrade("1000100"));
        System.out.println(maxActiveSectionsAfterTrade("01010"));
        System.out.println(maxActiveSectionsAfterTrade("010101100"));
    }
    public static int maxActiveSectionsAfterTrade(String s) {
        char[] chrs = s.toCharArray();
        int n = chrs.length;
        int maxZeros = 0;
        int i = 0;
        int preZero = -1;
        int zero = 0;
        int time = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && chrs[i] == chrs[j]) {
                j++;
            }
            if (chrs[i] == '0') {
                int v = j - i;
                if (preZero != -1) {
                    maxZeros = Math.max(maxZeros, preZero + v);
                }
                time += 1;
                zero += v;
                preZero = v;
            }
            i = j;
        }
        if (i < n && chrs[i] == '0') {
            int v = n - i;
            zero += v;
            if (preZero != -1) {
                maxZeros = Math.max(maxZeros, preZero + v);
            }
            time += 1;
        }
        if (time < 2) {
            return n - zero;
        }
        return n - zero + maxZeros;
    }
}
