package com.algorithm.arrays;

public class FindMinimumRotatedArrayII {

    /**
     * #154
     * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(findMinI(new int[] { 2, 2, 2, 0, 1}));
        System.out.println(findMin(new int[] { 2, 2, 2, 0, 1}));
    }

    public static int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else if (nums[r] > nums[mid]){
                r = mid;
            } else {
                r--;
            }
        }
        return nums[r];
    }

    public static int findMinI(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    static int helper(int nums[], int l, int r) {
        if (l == r) {
            return nums[l];
        }
        if (nums[l] < nums[r]) {
            return nums[l];
        }
        int mid = l + (r - l) / 2;
        return Math.min(helper(nums, l, mid), helper(nums, mid + 1, r));
    }
}
