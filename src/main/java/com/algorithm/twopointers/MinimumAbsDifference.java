package com.algorithm.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsDifference {

    /**
     * https://leetcode-cn.com/problems/minimum-absolute-difference
     *
     * @param args
     */
    public static void main(String[] args) {
        MinimumAbsDifference df = new MinimumAbsDifference();
        List<List<Integer>> res = df.minimumAbsDifference(new int[] { 3, 8, -10, 23, 19, -4, -14, 27 });
        for (List<Integer> l : res) {
            System.out.println(Arrays.toString(l.toArray()));
        }
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return res;
        }

        Arrays.sort(arr);

        int nbs = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            int diff = Math.abs(arr[i + 1] - arr[i]);
            if (nbs > diff) {
                nbs = diff;
            }
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int diff = Math.abs(arr[i + 1] - arr[i]);
            if (nbs == diff) {
                List<Integer> sub = new ArrayList<>();
                sub.add(arr[i]);
                sub.add(arr[i + 1]);
                res.add(sub);
            }
        }
        return res;
    }
}
