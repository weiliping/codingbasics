package com.algorithm.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSubarray {
    /**
     * https://github.com/weiliping/Grokking-the-Coding-Interview-Patterns-for-Coding-Questions/blob/master/2.%20Pattern%20Two%20Pointers/Subarrays%20with%20Product%20Less%20than%20a%20Target%20(medium).py
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[] { 10,5,2,6 };
        int target = 100;
        List<Integer[]> res = findSubarray(nums, target);
        for (Integer[] r : res) {
            System.out.println(Arrays.toString(r));
        }
    }

    public static List<Integer[]> findSubarray(int[] nums, int target) {
        int p = 1, l = 0, n = nums.length;

        List<Integer[]> res = new ArrayList<>();

        for (int r = 0; r < n; r++) {
            p *= nums[r];

            while (p >= target && l < n) {
                p /= nums[l];
                l++;
            }
            List<Integer> subRes = new ArrayList<>();
            for (int i = r; i > l - 1; i--) {
                subRes.add(nums[i]);
                res.add(getIntArray(subRes));
            }
        }
        return res;
    }

    static Integer[] getIntArray(List<Integer> res) {
        Integer[] r = new Integer[res.size()];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;
    }
}
