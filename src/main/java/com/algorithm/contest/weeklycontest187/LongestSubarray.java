package com.algorithm.contest.weeklycontest187;

import java.util.TreeMap;

public class LongestSubarray {

    public static void main(String[] args) {
        LongestSubarray l = new LongestSubarray();
        int nums1[] = new int[] { 8, 2, 4, 7 }, n1 = 4;
        System.out.println(l.longestSubarray(nums1, n1));
        int nums2[] = new int[] { 10, 1, 2, 4, 7, 2 }, n2 = 5;
        System.out.println(l.longestSubarray(nums2, n2));

        int nums3[] = new int[] { 4, 2, 2, 2, 4, 4, 2, 2 }, n3 = 0;
        System.out.println(l.longestSubarray(nums3, n3));
    }

    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        int n = nums.length;
        int i = 0, j = 0, res = 0;
        while (j < n) {
            tree.put(nums[j], tree.getOrDefault(nums[j], 0) + 1);
            while (Math.abs(tree.lastKey() - tree.firstKey()) > limit) {
                if (tree.get(nums[i]) > 1) {
                    tree.put(nums[i], tree.get(nums[i]) - 1);
                } else {
                    tree.remove(nums[i]);
                }
                i++;
            }
            int sub = j - i + 1;
            if (res < sub) {
                res = sub;
            }
            j++;
        }
        return res;
    }
}
