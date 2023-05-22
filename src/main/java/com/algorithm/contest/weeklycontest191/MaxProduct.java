package com.algorithm.contest.weeklycontest191;

public class MaxProduct {
    public static void main(String[] args) {
        MaxProduct m = new MaxProduct();
        System.out.println(m.maxProduct(new int[] { 3, 4, 5, 2 }));
    }

    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 2) {
            return (nums[0] - 1) * (nums[1] - 1);
        }

        int num1 = nums[0], num2 = nums[1];
        if (num1 < num2) {
            int t = num1;
            num1 = num2;
            num2 = t;
        }

        for (int i = 2; i < n; i++) {
            if (nums[i] > num1) {
                num2 = num1;
                num1 = nums[i];
                continue;
            }
            if (nums[i] > num2) {
                num2 = nums[i];
            }
        }
        return (num1 - 1) * (num2 - 1);
    }
}
