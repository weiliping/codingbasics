package com.algorithm.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumSubarrayProductLessThanK {

    /**
     * #713
     * https://leetcode-cn.com/problems/subarray-product-less-than-k
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[] { 10, 5, 2, 6 }, 100));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left++];
            }
            ans += right - left + 1;
        }
        return ans;
    }

    public static int numSubarrayProductLessThanKI(int[] nums, int k) {
        int[] res = new int[1];
        List<Integer> sub = new ArrayList<>();
        dfs(nums, 0, 1, k, res, nums.length, sub);
        return res[0];
    }

    static void dfs(int[] nums, int s, int prod, int k, int[] res, int n, List<Integer> sub) {
        if (prod >= k) {
            return;
        }
        if (prod < k) {
            List<Integer> out = new ArrayList<>(sub);
            System.out.println(Arrays.toString(out.toArray()));
            res[0]++;
        }
        for (int i = s; i < n; i++) {
            sub.add(nums[i]);
            prod *= nums[i];
            dfs(nums, i + 1, prod, k, res, n, sub);
            prod /= nums[i];
            sub.remove(sub.size() - 1);
        }
    }
}
