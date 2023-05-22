package com.algorithm.binarysearch;

import java.util.Arrays;

public class TwoSumSortedArray {

    /**
     * #167
     * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] { 2, 3, 4 }, 6)));
        System.out.println(Arrays.toString(twoSumII(new int[] { 2, 3, 4 }, 6)));
    }

    public static int[] twoSumII(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null) {
            return res;
        }
        int l = 0, r = numbers.length - 1;

        while (l < r) {
            int sum = numbers[l] + numbers[r];

            if (sum == target) {
                res[0] = l + 1;
                res[1] = r + 1;
                return res;
            }

            if (sum > target) {
                r--;
                continue;
            }
            l++;
        }
        return res;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null) {
            return res;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int subTarget = target - nums[i], l = i + 1, r = n;
            res[0] = i + 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] > subTarget) {
                    r = mid;
                } else if (nums[mid] < subTarget) {
                    l = mid + 1;
                } else {
                    res[1] = mid + 1;
                    return res;
                }
            }
        }
        return res;
    }
}
