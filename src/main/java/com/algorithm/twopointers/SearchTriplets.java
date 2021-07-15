package com.algorithm.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchTriplets {

    /**
     * https://github.com/weiliping/Grokking-the-Coding-Interview-Patterns-for-Coding-Questions/blob/master/2.%20Pattern%20Two%20Pointers/Triplet%20Sum%20to%20Zero%20(medium).py
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[] { -5, 2, -1, -2, 3 };
        List<List<Integer>> res = searchTriplets(nums);
        for (List<Integer> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public static List<List<Integer>> searchTriplets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            searchHelper(nums, -nums[i], i + 1, res);
        }
        return res;
    }

    static void searchHelper(int[] nums, int target, int l, List<List<Integer>> res) {
        int n = nums.length, r = n - 1;
        while (l < r) {
            if (target == nums[l] + nums[r]) {
                List<Integer> sub = new ArrayList<>();
                sub.add(-target);
                sub.add(nums[l]);
                sub.add(nums[r]);
                res.add(sub);
                l++;
                r--;
                while (l < r && nums[l] == nums[l - 1]) {
                    l++;
                }
                while (l < r && nums[r] == nums[r + 1]) {
                    r--;
                }
                continue;
            }
            if (nums[l] + nums[r] > target) {
                r--;
            } else {
                l++;
            }
        }
    }
}
