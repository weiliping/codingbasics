package com.algorithm.contest.weeklycontest166;

public class SmallestDivisor {
    public static void main(String[] args) {
        System.out.println(smallestDivisor(new int[] {1,2,5,9}, 6));
        System.out.println(smallestDivisor(new int[] {2,3,5,7,11}, 11));
        System.out.println(smallestDivisor(new int[] {19}, 5));
        System.out.println(smallestDivisor(new int[] {44,22,33,11,1}, 5));
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length, max = max(nums, 0, n - 1);
        int i = 1, j = max;
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            int subRes = getDivideVal(nums, mid);
            if (subRes > threshold) {
                i = mid + 1;
            } else {
                if (mid == 1) {
                    return mid;
                }
                int nextRes = getDivideVal(nums, mid - 1);
                if (nextRes > threshold) {
                    return mid;
                }
                j = mid - 1;
            }
        }
        return i;
    }

    static int getDivideVal(int[] nums, int divisor) {
        int res = 0;
        for (int num : nums) {
            res += num / divisor;
            if (num % divisor != 0) {
                res++;
            }
        }
        return res;
    }

    static int max(int[] nums, int i, int j) {
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
        return Math.max(max(nums, i, mid), max(nums, mid + 1, j));
    }
}
