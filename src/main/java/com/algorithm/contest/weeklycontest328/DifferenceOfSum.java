package com.algorithm.contest.weeklycontest328;

public class DifferenceOfSum {
    public static void main(String[] args) {
        System.out.println(differenceOfSum(new int[] { 1, 15, 6, 3 }));
    }

    public static int differenceOfSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;

            while (num > 0) {
                sum -= num % 10;
                num /= 10;
            }
        }
        return sum < 0 ? -sum : sum;
    }
}
