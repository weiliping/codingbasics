package com.algorithm.contest.weeklycontest89;

public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[] { 0, 10, 5, 2 }));
        System.out.println(peakIndexInMountainArray(new int[] { 3, 4, 5, 1 }));
        System.out.println(peakIndexInMountainArray(new int[] { 24, 69, 100, 99, 79, 78, 67, 36, 26, 19 }));
        System.out.println(peakIndexInMountainArray(new int[] { 24, 69, 100, 103, 108, 99 }));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int i = 0, j = arr.length;
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] < arr[mid + 1]) {
                i = mid;
            } else {
                j = mid;
            }
        }
        return 0;
    }
}
