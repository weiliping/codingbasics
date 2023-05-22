package com.algorithm.contest.weeklycontest166;

public class SubtractProductAndSum {
    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234));
        System.out.println(subtractProductAndSum(4421));
    }

    public static int subtractProductAndSum(int n) {
        int sum = 0, multiple = 1;

        while (n > 0) {
            int cur = n % 10;
            sum += cur;
            multiple *= cur;

            n /= 10;
        }
        return multiple - sum;
    }
}
