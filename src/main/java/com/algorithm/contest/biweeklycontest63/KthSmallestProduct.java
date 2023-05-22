package com.algorithm.contest.biweeklycontest63;

public class KthSmallestProduct {

    public static void main(String[] args) {
        int[] nums1 = new int[] { -2, -1, 0, 1, 2 }, nums2 = new int[] { -3, -1, 2, 4, 5 };

        kthSmallestProduct(nums1, nums2, 3);
    }

    public static long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long res = 1l;
        // int m = nums1.length, n = nums2.length;

        // int negNum1 = binarySearch(nums1, 0), negNum2 = binarySearch(nums2, 0);

        // int posNum1 = m - negNum1 - 1, posNum2 = n - negNum2 - 1;

        // long i = k / m, j = k % m;
        return res;
    }

    static int binarySearch(int[] nums, int val) {
        int i = 0, n = nums.length - 1, j = n;
        while (i <= j) {
            int mid = i + ((j - 1) >> 1);
            if (nums[mid] < val) {
                if (mid == n - 1 || nums[mid + 1] >= val) {
                    return mid;
                }
                j = mid - 1;
            } else {
                if (mid == 0) {
                    return -1;
                }
                i = mid + 1;
            }
        }
        return -1;
    }
}
