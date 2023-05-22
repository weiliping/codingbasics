package com.algorithm.selfpractice.sort;

public class FindKthLargest {

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 1, 4, 9, 0, 3, 5, 8, 7, 6 };
        System.out.println(findKthLargest(arr, 3));
    }
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        return kthLargest(nums, 0, n - 1, k);
    }

    private static int kthLargest(int[] nums, int start, int end, int k) {
        int i = start, j = end, tmp = nums[i];

        while (i < j) {
            while (i < j && nums[j] <= tmp) {
                j--;
            }
            nums[i] = nums[j];

            while (i < j && nums[i] >= tmp) {
                i++;
            }

            nums[j] = nums[i];
        }
        nums[j] = tmp;

        if (j == k - 1) {
            return tmp;
        } else if (j > k - 1) {
            return kthLargest(nums, start, j - 1, k);
        } else {
            return kthLargest(nums, j + 1, end, k);
        }
    }
}
