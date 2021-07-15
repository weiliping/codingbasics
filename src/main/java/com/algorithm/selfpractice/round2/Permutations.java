package com.algorithm.selfpractice.round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        List<List<Integer>> res = permute(new int[]{1, 2, 3});
        for (List<Integer> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        helper(nums, 0, res);
        return res;
    }

    static void helper(int[] nums, int start, List<List<Integer>> res) {
        if (start == nums.length - 1) {
            ArrayList<Integer> sub = new ArrayList<>();
            for(int n : nums) {
                sub.add(n);
            }
            res.add(sub);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            helper(nums, start + 1, res);
            swap(nums, start, i);
        }
    }

    static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
