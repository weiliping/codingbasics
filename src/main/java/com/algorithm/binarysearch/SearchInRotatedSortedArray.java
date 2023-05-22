package com.algorithm.binarysearch;

public class SearchInRotatedSortedArray {

    /**
     * #33
     * https://leetcode-cn.com/problems/search-in-rotated-sorted-array
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArray().search(new int[] { 1, 3, 5 }, 1));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int s = 0, n = nums.length - 1;

        while (s <= n) {
            int mid = s + (n - s) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < nums[n]) {
                if (nums[mid] < target && nums[n] >= target) {
                    s = mid + 1;
                } else {
                    n = mid - 1;
                }
            } else {
                if (nums[s] <= target && nums[mid] > target) {
                    n = mid - 1;
                } else {
                    s = mid + 1;
                }
            }
        }
        return -1;
    }
}
