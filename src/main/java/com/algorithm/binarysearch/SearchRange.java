package com.algorithm.binarysearch;

import java.util.Arrays;

public class SearchRange {

    /**
     * #34
     * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
     *
     * @param args
     */
    public static void main(String[] args) {
        //        System.out.println(Arrays.toString(new SearchRange().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        //        System.out.println(Arrays.toString(new SearchRange().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(new SearchRange().searchRange(new int[] { 1 }, 1)));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = leftPosition(nums, target);
        res[1] = rightPosition(nums, target);
        return res;
    }

    static int leftPosition(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (start < nums.length && nums[start] == target) {
            return start;
        }
        return -1;
    }

    static int rightPosition(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start + 1) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        if (end < nums.length && end >= 0 && nums[end] == target) {
            return end;
        }
        return -1;
    }
}
