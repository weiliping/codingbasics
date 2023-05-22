package com.algorithm.binarysearch;

public class BinarySearch {

    /**
     * #704
     * https://leetcode-cn.com/problems/binary-search/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[] {1, 2, 3, 6, 7, 9, 10}, 3));
    }

    public static int binarySearch(int[] nums, int target) {
        int i = 0, j = nums.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }
}
