package com.algorithm.contest.weeklycontest242;

public class CheckZeroOnes {
    public static void main(String[] args) {
        CheckZeroOnes c = new CheckZeroOnes();
        System.out.println(c.checkZeroOnes("1101"));
        System.out.println(c.checkZeroOnes("111000"));
        System.out.println(c.checkZeroOnes("110100010"));
    }
    public boolean checkZeroOnes(String s) {
        char[] chrs = s.toCharArray();
        int maxOnes = 0, maxZeros = 0, subOnes = 0, subZeros = 0;
        char c = '2';
        for (char ch : chrs) {
            if (ch != c) {
                c = ch;
                if (c == '1') {
                    if (maxOnes < subOnes) {
                        maxOnes = subOnes;
                    }
                    subOnes = 1;
                    continue;
                }
                if (maxZeros < subZeros) {
                    maxZeros = subZeros;
                }
                subZeros = 1;
                continue;
            }
            if (ch == '1') {
                subOnes++;
            } else {
                subZeros++;
            }
        }
        if (maxOnes < subOnes) {
            maxOnes = subOnes;
        }
        if (maxZeros < subZeros) {
            maxZeros = subZeros;
        }
        return maxOnes > maxZeros;
    }
}
