package com.algorithm.arrays;

public class SearchInsert {

    /**
     * https://leetcode-cn.com/problems/search-insert-position/
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 5));
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int n = nums.length;
        if (target <= nums[0]) {
            return 0;
        }

        if (target > nums[n - 1]) {
            return n;
        }
        for (int i = 1; i < n; i++) {
            if (target <= nums[i] && target > nums[i - 1]) {
                return i;
            }
        }
        return -1;
    }
}
