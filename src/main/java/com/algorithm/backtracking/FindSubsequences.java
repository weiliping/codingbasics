package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/increasing-subsequences/
 *
 * 491. 递增子序列
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 *
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * 示例 2：
 *
 * 输入：nums = [4,4,3,2,1]
 * 输出：[[4,4]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 15
 * -100 <= nums[i] <= 100
 *
 */
public class FindSubsequences {
    public static void main(String[] args) {
        FindSubsequences f = new FindSubsequences();
        List<List<Integer>> res = f.findSubsequences(new int[] {4, 6, 7, 7});
//        List<List<Integer>> res = f.findSubsequences(new int[] {4, 4, 3, 2, 1});
        for (List<Integer> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        dfs(nums, 0, n, new ArrayList<>(), res);
        return res;
    }

    void dfs(int[] nums, int s, int n, List<Integer> subRes, List<List<Integer>> res) {
        Set<Integer> set = new HashSet<>();
        if (subRes.size() > 1) {
            res.add(new ArrayList<>(subRes));
        }
        for (int i = s; i < n; i++) {
            if (set.contains(nums[i]) || (subRes.size() > 0 && nums[i] < subRes.get(subRes.size() - 1))) {
                continue;
            }
            subRes.add(nums[i]);
            set.add(nums[i]);
            dfs(nums, i + 1, n, subRes, res);
            subRes.remove(subRes.size() - 1);
        }
    }
}
