package com.algorithm.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SubsetsII {

    public static void main(String[] args) {
        List<List<Integer>> res = subsetsWithDup(new int[] {1, 2, 2});
        for (List<Integer> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helperSubsets(nums, 0, res, new ArrayList<>());
        return res;
    }

    static void helperSubsets(int[] nums, int s, List<List<Integer>> res, List<Integer> subRes) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = s; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            subRes.add(nums[i]);
            res.add(new ArrayList<>(subRes));
            helperSubsets(nums, i + 1, res, subRes);
            subRes.remove(subRes.size() - 1);
        }
    }
}
