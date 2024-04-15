package com.algorithm.leetcode;
/*
 * @lc app=leetcode.cn id=2972 lang=java
 *
 * [2972] 统计移除递增子数组的数目 II
 */

// @lc code=start
class Solution2972 {
    public static void main(String[] args) {
        int[] nums = new int[] {6,5,7,8};
        Solution2972 s = new Solution2972();
        System.out.println(s.incremovableSubarrayCount(nums));
    }
    public long incremovableSubarrayCount(int[] nums) {
        long res = 1l;
        int i = 0;
        int n = nums.length;
        int j = n - 1;
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == j) {
            return ((res * n * (n + 1)) >> 1);
        }

        while (j > 0 && nums[j] > nums[j - 1]) {
            j--;
        }
        res += i + 1;
        res += n - j;
        if ((i + 1) > n - j) {
            for (int k = j; k < n; k++) {
                int ind = binSearchFirstLess(nums, 0, i, nums[k]);
                res += ind + 1;
            }
            return res;
        }
        for (int k = 0; k < (i + 1); k++) {
            int ind = binSearchFirstGreater(nums, j, n - 1, nums[k]);
            res += n - ind;
        }
        return res;
    }

    public static int binSearchFirstGreater(int[] arr, int start, int end, int target) {
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

    public static int binSearchFirstLess(int[] arr, int start, int end, int target) {
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
}
// @lc code=end

