package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute {

    /**
     * #46
     * https://leetcode-cn.com/problems/permutations/
     *
     * @param args
     */
    public static void main(String[] args) {
        List<List<Integer>> res = new Permute().permute(new int[] { 1, 2, 3 });
        for (List<Integer> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0, nums);
        return result;
    }

    private void helper(int start, int[] nums) {
        if (start == nums.length - 1) {
//            ArrayList<Integer> list = new ArrayList<>();
//            for (int num : nums) {
//                list.add(num);
//            }
//            result.add(list);
            System.out.println(Arrays.toString(nums));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            helper(start + 1, nums);
            swap(nums, i, start);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
