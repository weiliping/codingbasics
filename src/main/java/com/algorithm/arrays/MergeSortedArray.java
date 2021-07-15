package com.algorithm.arrays;

import java.util.Arrays;

public class MergeSortedArray {

    /**
     * #88
     * https://leetcode-cn.com/problems/merge-sorted-array/
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = new int[] {4, 5, 6, 0, 0, 0};
        int[] nums2 = new int[] {1, 2, 3};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
