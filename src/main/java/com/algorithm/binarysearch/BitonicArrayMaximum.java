package com.algorithm.binarysearch;

public class BitonicArrayMaximum {

    public static void main(String[] args) {
        System.out.println(bitonicArrayMaximum(new int[] { 1, 3, 8, 12, 4, 2 }));
        System.out.println(bitonicArrayMaximum(new int[] { 3, 8, 3, 1 }));
        System.out.println(bitonicArrayMaximum(new int[] { 1, 3, 8, 12 }));
        System.out.println(bitonicArrayMaximum(new int[] { 10, 9, 8 }));
    }

    public static int bitonicArrayMaximum(int[] nums) {
        int i = 0, j = nums.length - 1;

        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > nums[mid + 1]) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return nums[i];
    }
}
