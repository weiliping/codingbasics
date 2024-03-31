package com.algorithm.binarysearch;

public class BinarySearch {

    /**
     * #704
     * https://leetcode-cn.com/problems/binary-search/
     * @param args
     */
    public static void main(String[] args) {
        // System.out.println(binarySearch(new int[] {1, 2, 3, 6, 7, 9, 10}, 3));
        System.out.println(binSearchFirstLess(new int[] {1, 2, 3, 6, 7, 9, 10}, -1));
        System.out.println(binSearchFirstGreater(new int[] {1, 2, 3, 6, 7, 9, 10}, 11));
    }

    public static int binSearchFirstGreater(int[] arr, int target) {
        int start = 0, end = arr.length - 1; 
    
        int ans = arr.length; 
        while (start <= end) { 
            int mid = (start + end) / 2; 
            if (arr[mid] <= target) {
                start = mid + 1; 
            } else { 
                ans = mid;
                end = mid - 1;
            } 
        } 
        return ans;     
    }

    public static int binSearchFirstLess(int[] arr, int target) {
        int start = 0, end = arr.length - 1; 
    
        int ans = -1; 
        while (start <= end) { 
            int mid = (start + end) / 2; 
            if (arr[mid] >= target) { 
                end = mid - 1; 
            } else { 
                ans = mid;
                start = mid + 1; 
            } 
        } 
        return ans; 
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
