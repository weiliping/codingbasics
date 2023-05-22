package com.algorithm.binarysearch;

public class SearchInRotatedSortedArrayII {

    /**
     * #81
     * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(search(new int[] {3, 1, 1}, 3));
    }

    public static boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > nums[right]) {
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                right--;
            }
        }
        return false;
    }
}
