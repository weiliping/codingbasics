package com.algorithm.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestElements {

    /**
     * #658
     * https://leetcode-cn.com/problems/find-k-closest-elements/
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[] { 12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56 };
        List<Integer> subArr = new ClosestElements().findClosestElements(arr, 4, 35);
        System.out.println(Arrays.toString(subArr.toArray()));
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();

        if (arr == null || arr.length == 0) {
            return res;
        }
        int l = 0, r = arr.length - k;

        while (l < r) {
            int mid = l + (r - l) / 2;
            int lVal = x - arr[mid];
            int rVal = arr[mid + k] - x;
            if (lVal > rVal) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        for (int i = l; i < l + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
