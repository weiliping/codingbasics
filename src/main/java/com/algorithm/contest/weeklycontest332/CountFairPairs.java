package com.algorithm.contest.weeklycontest332;

import java.util.Arrays;

public class CountFairPairs {

    public static void main(String[] args) {
        int[] nums1 = new int[] { 0, 1, 7, 4, 4, 5 };
        int l1 = 3, u1 = 6;
        System.out.println(countFairPairs(nums1, l1, u1));
        int[] nums2 = new int[] { 1, 7, 9, 2, 5 };
        int l2 = 11, u2 = 11;
        System.out.println(countFairPairs(nums2, l2, u2));

        int[] nums3 = new int[] { 0, 0, 0, 0, 0, 0 };
        int l3 = 0, u3 = 0;
        System.out.println(countFairPairs(nums3, l3, u3));
    }

    public static long countFairPairs(int[] nums, int lower, int upper) {
        long cnt = 0l;
        Arrays.sort(nums);
        int n = nums.length, mInd = n - 1;
        for (int i = 0; i < n - 1; i++) {
            int min = lower - nums[i];
            int max = upper - nums[i];
            cnt += count(i + 1, mInd, min, max, nums);
        }
        return cnt;
    }

    public static int count(int sInd, int eInd, int min, int max, int[] nums) {
        if (nums[sInd] > max || nums[eInd] < min) {
            return 0;
        }
        int i = sInd, j = eInd;
        return binarySearchMax(i, j, max, nums) - binarySearchMin(sInd, eInd, min, nums);
    }

    public static int binarySearchMax(int i, int j, int val, int[] nums) {
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (nums[mid] > val) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return i - 1;
    }

    public static int binarySearchMin(int i, int j, int val, int[] nums) {
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (nums[mid] < val) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return j;
    }
}
