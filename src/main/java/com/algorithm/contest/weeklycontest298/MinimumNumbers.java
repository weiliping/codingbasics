package com.algorithm.contest.weeklycontest298;

public class MinimumNumbers {
    public static void main(String[] args) {
        System.out.println(minimumNumbers(58, 9));
        System.out.println(minimumNumbers(37, 2));
        System.out.println(minimumNumbers(0, 7));
        System.out.println(minimumNumbers(10, 8));
        System.out.println(minimumNumbers(9, 1));
        System.out.println(minimumNumbers(10, 1));
        System.out.println(minimumNumbers(20, 1));
        System.out.println(minimumNumbers(20, 0));
        System.out.println(minimumNumbers(30, 3));
    }
    public static int minimumNumbers(int num, int k) {
        if (num == 0) {
            return num;
        }
        int left = num % 10;
        int minLen = -1;
        for (int i = 1; i < 11; i++) {
            if (k * i % 10 == left) {
                minLen = i;
                break;
            }
        }
        if (minLen == -1 || minLen * k > num) {
            return -1;
        }
        return minLen;
    }
}
