package com.datastructure.day2;

public class MajorityElement {
    public static void main(String args[]) {
        System.out.println(majority(new int[] {23, 300, 300, 25, 28, 300, 300, 300, 300, 300, 300, 500, 500, 500, 500}));
    }

    public static int majority(int nums[]) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        int rightSize = 1, res = 0, n = nums.length;

        while (max > 1 << rightSize) {
            rightSize++;
        }

        for (int i = 0; i <= rightSize; i++) {
            int ones = 0, zeros = 0;
            for (int num : nums) {
                if (ones > n / 2 || zeros > n / 2) {
                    break;
                }

                if ((num & (1 << i)) != 0) {
                    ones++;
                } else {
                    zeros++;
                }
            }

            if (ones > zeros) {
                res |= (1 << i);
            }
        }
        return res;
    }
}
