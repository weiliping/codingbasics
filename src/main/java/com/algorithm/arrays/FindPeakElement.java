package com.algorithm.arrays;

public class FindPeakElement {

    /**
     * #162
     * https://leetcode-cn.com/problems/find-peak-element/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[] {1, 2, 3, 1}));
        System.out.println(findPeakElement(new int[] { 1, 2, 1, 3, 5, 6, 4 }));
    }

    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) left = mid + 1;
            else right = mid;
        }
        return right;
    }
}
