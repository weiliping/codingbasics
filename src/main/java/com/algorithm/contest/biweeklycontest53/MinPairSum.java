package com.algorithm.contest.biweeklycontest53;

import java.util.Arrays;

public class MinPairSum {

    /**
     * https://leetcode-cn.com/problems/minimize-maximum-pair-sum-in-array/
     * 输入：nums = [3,5,2,3]
     * 输出：7
     * 解释：数组中的元素可以分为数对 (3,3) 和 (5,2) 。
     * 最大数对和为 max(3+3, 5+2) = max(6, 7) = 7 。
     *
     * @param args
     */
    public static void main(String[] args) {
        MinPairSum m = new MinPairSum();
        System.out.println(m.minPairSum(new int[] { 3, 5, 2, 3 }));
        System.out.println(m.minPairSum(new int[] { 3, 5, 4, 2, 4, 6 }));
    }
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int j = 0, len = n / 2;
        int res = Integer.MIN_VALUE;
        while (j < len) {
            int sum = nums[j] + nums[n - 1 - j];
            if (res < sum) {
                res = sum;
            }
            j++;
        }
        return res;
    }
}
