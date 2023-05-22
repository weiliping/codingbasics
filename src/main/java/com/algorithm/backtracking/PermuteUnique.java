package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermuteUnique {

    /**
     * #47
     * https://leetcode-cn.com/problems/permutations-ii/
     *
     * @param args
     */
    public static void main(String[] args) {
        List<List<Integer>> res = new PermuteUnique().permuteUnique(new int[] { 1, 1, 3 });
        for (List<Integer> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        helper(nums, 0, nums.length, res);
        return res;
    }

    static void helper(int[] nums, int s, int l, List<List<Integer>> res) {
        if (s == l - 1) {
            List<Integer> subRes = new ArrayList<>();
            for (int n : nums) {
                subRes.add(n);
            }
            res.add(subRes);
            return;
        }

        Set<Integer> uniqueSet = new HashSet<>();
        for (int j = s; j < l; j++) {
            if (uniqueSet.contains(nums[j])) {
                continue;
            }
            uniqueSet.add(nums[j]);
            swap(nums, s, j);
            helper(nums, s + 1, l, res);
            swap(nums, s, j);
        }
    }

    static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
