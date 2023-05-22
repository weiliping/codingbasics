package com.algorithm.arrays;

public class FindMinimumRotatedArray {

    /**
     * #153
     * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(findMinI(new int[] { 4, 5, 6, 7, 8, 0, 1, 2 }));
        System.out.println(findMin(new int[] { 4, 5, 6, 7, 8, 0, 1, 2 }));
    }

    public static int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[r];
    }

    public static int findMinI(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    static int helper(int nums[], int l, int r) {
        if (nums[l] <= nums[r]) {
            return nums[l];
        }
        int mid = l + (r - l) / 2;
        if (nums[l] > nums[mid]) {
            return helper(nums, l, mid);
        } else {
            return helper(nums, mid + 1, r);
        }
    }
}
