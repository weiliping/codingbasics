package com.algorithm.contest.weeklycontest255;

public class FindGCD {

    public static void main(String[] args) {
        FindGCD f = new FindGCD();
        System.out.println(f.findGCD(new int[]{2,5,6,9,10}));
        System.out.println(f.findGCD(new int[]{7,5,6,8,3}));
        System.out.println(f.findGCD(new int[]{3,3}));
    }
    public int findGCD(int[] nums) {
        int n = nums.length;
        int max = maxNum(nums, 0, n - 1);
        int min = minNum(nums, 0, n - 1);
        return gcd(max, min);
    }

    static int gcd(int m, int n) {
        if (m % n == 0) {
            return n;
        }
        return gcd(n, m % n);
    }

    static int maxNum(int[] nums, int i, int j) {
        if (i > j) {
            return Integer.MIN_VALUE;
        }

        if (i == j) {
            return nums[i];
        }

        if (i + 1 == j) {
            return Math.max(nums[i], nums[j]);
        }

        int mid = i + ((j - i) >> 1);

        return Math.max(maxNum(nums, i, mid), maxNum(nums, mid + 1, j));
    }

    static int minNum(int[] nums, int i, int j) {
        if (i > j) {
            return Integer.MAX_VALUE;
        }

        if (i == j) {
            return nums[i];
        }

        if (i + 1 == j) {
            return Math.min(nums[i], nums[j]);
        }

        int mid = i + ((j - i) >> 1);

        return Math.min(minNum(nums, i, mid), minNum(nums, mid + 1, j));
    }
}
