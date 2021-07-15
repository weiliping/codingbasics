package com.algorithm.selfpractice.round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermuteUnique {

    public static void main(String[] args) {
        List<List<Integer>> res = permute(new int[] {1, 1, 3});
        for (List<Integer> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        helper(nums, 0, res);
        return res;
    }

    static void helper(int[] nums, int s, List<List<Integer>> res) {
        int len = nums.length;
        if (s == len - 1) {
            List<Integer> sub = new ArrayList<>();
            for (int n : nums) {
                sub.add(n);
            }
            res.add(sub);
            return;
        }

        Set<Integer> uniqueSet = new HashSet<>();
        for (int j = s; j < len; j++) {
            if (uniqueSet.contains(nums[j])) {
                continue;
            }
            uniqueSet.add(nums[j]);
            swap(nums, s, j);
            helper(nums, s + 1, res);
            swap(nums, j, s);
        }

    }

    static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
