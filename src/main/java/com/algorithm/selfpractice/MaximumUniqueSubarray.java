package com.algorithm.selfpractice;

public class MaximumUniqueSubarray {
    public static void main(String[] args) {
        MaximumUniqueSubarray mua = new MaximumUniqueSubarray();
        int[] nums = {4, 2, 4, 5, 6};
        System.out.println(mua.maximumUniqueSubarray(nums)); // Output: 17
    }
    public int maximumUniqueSubarray(int[] nums) {
        int[] cnts = new int[10001];
        int res = 0;
        int cur = 0;
        int i = 0;
        int n = nums.length;
        for (int j = 0; j < n; j++) {
            int k = nums[j];
            cur += k;
            cnts[k]++;
            if (cnts[k] > 1) {
                while (i < n && cnts[k] > 1) {
                    cur -= nums[i];
                    cnts[nums[i]]--;
                    i++;
                }    
                continue;
            }
            res = Math.max(res, cur);
        }
        return res;    
    }
}
