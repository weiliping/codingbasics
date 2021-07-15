package com.algorithm.binarysearch;

public class RotationCount {

    public static void main(String[] args) {
        System.out.println(countRotations(new int[] { 10, 15, 1, 3, 8 }));
        System.out.println(countRotations(new int[] { 4, 5, 7, 9, 10, -1, 2 }));
        System.out.println(countRotations(new int[] { 1, 3, 8, 10 }));
    }

    public static int countRotations(int[] nums) {
        int i = 0, j = nums.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (mid < j && nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }

            if (mid > i && nums[mid] < nums[mid - 1]) {
                return mid;
            }

            if (nums[i] < nums[mid]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return 0;
    }
}
