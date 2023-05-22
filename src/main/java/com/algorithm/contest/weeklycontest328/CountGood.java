package com.algorithm.contest.weeklycontest328;

import java.util.HashMap;
import java.util.Map;

public class CountGood {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 1, 1, 1, 1 };
        int k = 10;
        System.out.println(countGood(nums, k));
        int[] nums1 = new int[] { 3, 1, 4, 3, 2, 2, 4 };
        int k1 = 2;
        System.out.println(countGood(nums1, k1));

        int[] nums2 = new int[] { 2, 3, 1, 3, 2, 3, 3, 3, 1, 1, 3, 2, 2, 2 };
        int k2 = 18;
        System.out.println(countGood(nums2, k2)); // 9
    }

    public static long countGood(int[] nums, int k) {
        long cnt = 0l;
        int i = 0, n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int sumK = 0;
        for (int j = 0; j < n; j++) {
            int c = mp.getOrDefault(nums[j], 0) + 1;
            mp.put(nums[j], c);
            if (c >= 2) {
                sumK += c - 1;
            }
            while (i < j && sumK >= k) {
                cnt += n - j;
                int minC = mp.get(nums[i]);
                if (minC >= 2) {
                    minC--;
                    sumK -= minC;
                    mp.put(nums[i], minC);
                } else {
                    mp.remove(Integer.valueOf(nums[i]));
                }
                i++;
            }
        }
        return cnt;
    }
}
