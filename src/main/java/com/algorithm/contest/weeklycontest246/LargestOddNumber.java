package com.algorithm.contest.weeklycontest246;

public class LargestOddNumber {
    public static void main(String[] args) {
        LargestOddNumber l = new LargestOddNumber();
        System.out.println(l.largestOddNumber("52"));
        System.out.println(l.largestOddNumber("4206"));
        System.out.println(l.largestOddNumber("35427"));
    }
    public String largestOddNumber(String num) {
        char[] chs = num.toCharArray();
        int n = chs.length, i = n - 1;
        for (; i >= 0; i--) {
            if ((chs[i] - '0') % 2 == 0) {
                continue;
            }
            break;
        }
        return num.substring(0, i + 1);
    }
}
