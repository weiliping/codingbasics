package com.algorithm.greedyalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MaxNumber {
    /**
     * #321
     * https://leetcode-cn.com/problems/create-maximum-number/
     * @param args
     */
    public static void main(String[] args) {
//        int[] nums1 = new int[] { 3, 4, 6, 5 };
//        int[] nums2 = new int[] { 9, 1, 2, 5, 8, 3 };
//        System.out.println(Arrays.toString(maxNumber(nums1, nums2, 5)));
//        int[] nums1 = new int[] { 1, 2 };
//        int[] nums2 = new int[] {};
//        System.out.println(Arrays.toString(maxNumber(nums1, nums2, 2)));
//        int[] nums1 = new int[] { 2, 5, 6, 4, 4, 0 };
//        int[] nums2 = new int[] { 7, 3, 8, 0, 6, 5, 7, 6, 2 };
        //[7,3,8,2,5,6,4,4,0,6,5,7,6,2,0]
//        System.out.println(Arrays.toString(maxNumber(nums1, nums2, 15)));

        int[] nums1 = new int[] { 5, 6, 8 };
        int[] nums2 = new int[] { 6, 4, 0 };
        System.out.println(Arrays.toString(maxNumber(nums1, nums2, 3)));
    }

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        List<Integer> res = new ArrayList<>();
        int m = nums1.length, n = nums2.length;
        for (int i = 0; i <= k; i++) {
            if (i > m || k - i > n) {
                continue;
            }
            List<Integer> l1 = maxOne(nums1, i);
            List<Integer> l2 = maxOne(nums2, k - i);
            List<Integer> tmp = merge(l1, l2);
            res = isLargeList(res, tmp) ? res : tmp;
        }
        int[] cnt = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            cnt[i] = res.get(i);
        }
        return cnt;
    }

    public static boolean isLargeList(List<Integer> l1, List<Integer> l2) {
        int m = l1.size(), n = l2.size();
        int len = Math.min(m, n);
        for (int i = 0; i < len; i++) {
            if (l1.get(i).equals(l2.get(i))) {
                continue;
            }
            if (l1.get(i) > l2.get(i)) {
                return true;
            } else {
                return false;
            }
        }
        if (m > n) {
            return true;
        } else {
            return false;
        }
    }

    public static List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        int m = l1.size();
        int n = l2.size();
        List<Integer> l = new ArrayList<>(m + n);

        int i = 0, j = 0;
        while (i < m && j < n) {
            if (isLargeList(l1.subList(i, m), l2.subList(j, n))) {
                l.add(l1.get(i));
                i++;
            } else {
                l.add(l2.get(j));
                j++;
            }
        }

        while (i < m) {
            l.add(l1.get(i));
            i++;
        }
        while (j < n) {
            l.add(l2.get(j));
            j++;
        }
        return l;
    }


    public static List<Integer> maxOne(int[] nums, int m) {
        int n = nums.length;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && n - i + s.size() > m && s.peek() < nums[i]) {
                s.pop();
            }
            s.push(nums[i]);
            if (s.size() > m) {
                s.pop();
            }
        }
        return new ArrayList<>(s);
    }
}
