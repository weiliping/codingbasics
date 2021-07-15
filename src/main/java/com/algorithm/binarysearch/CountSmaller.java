package com.algorithm.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSmaller {
    /**
     * #315
     * https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[] { 5, 2, 6, 1 };
        System.out.println(Arrays.toString(countSmaller(nums).toArray()));
        int[] nums2 = new int[] { 1, 0, 2 };
        System.out.println(Arrays.toString(countSmaller(nums2).toArray()));
    }

    public static List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> t = new ArrayList<>(n);
        int[] res = new int[n];
        int s = 0;
        for (int i = n - 1; i >= 0; i--) {
            int l = 0, r = s;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (t.get(mid) >= nums[i]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            res[i] = r;
            t.add(r, nums[i]);
            s++;
        }
        List<Integer> r = new ArrayList<>();
        for (int sub : res) {
            r.add(sub);
        }
        return r;
    }
}
