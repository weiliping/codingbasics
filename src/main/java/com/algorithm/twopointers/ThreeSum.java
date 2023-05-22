package com.algorithm.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /**
     * #15
     * https://leetcode-cn.com/problems/3sum/
     *
     * @param args
     */
    public static void main(String[] args) {
        List<List<Integer>> res = new ThreeSum().threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
        for (List<Integer> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return res;
        }
        Arrays.sort(nums);
        int l = nums.length;
        for (int i = 0; i < l - 1; i++) {
            int j = i + 1, k = l - 1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (j < k) {
                if (k < l - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }
                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    List<Integer> sub = new ArrayList<>();
                    sub.add(nums[i]);
                    sub.add(nums[j]);
                    sub.add(nums[k]);
                    res.add(sub);
                    j++;
                    k--;
                }
            }
        }
        return res;
    }
}
