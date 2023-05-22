package com.algorithm.selfpractice.round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        List<List<Integer>> res = permute(nums);

        for (List<Integer> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        helper(nums, 0, nums.length, res);
        return res;
    }

    static void helper(int[] nums, int start, int l, List<List<Integer>> res) {
        if (start == l - 1) {
            List<Integer> subRes = new ArrayList<>();
            for (int n : nums) {
                subRes.add(n);
            }
            res.add(subRes);
            return;
        }

        for (int j = start; j < l; j++) {
            swap(nums, start, j);
            helper(nums, start + 1, l, res);
            swap(nums, j, start);
        }
    }

    static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
