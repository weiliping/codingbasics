package com.algorithm.arrays;

import java.util.HashSet;

public class LongestConsecutive {
    /**
     * #128
     * https://leetcode-cn.com/problems/longest-consecutive-sequence/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
    }

    public static int longestConsecutive(int[] nums) {
        int l = nums.length;
        HashSet<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < l; i++) {
            s.add(nums[i]);
        }

        int ans = 0;
        for (int i = 0; i < l; i++) {
            if (s.contains(nums[i])) {
                int j = nums[i];
                while (s.contains(j)) {
                    j++;
                }

                ans = Math.max(ans, j - nums[i]);
            }
        }
        return ans;
    }
}
