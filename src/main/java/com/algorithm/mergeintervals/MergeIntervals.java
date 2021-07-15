package com.algorithm.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    /**
     * #56
     * https://leetcode-cn.com/problems/merge-intervals
     *
     * @param args
     */
    public static void main(String[] args) {
        //        int[][] intervals = new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        //        int[][] intervals = new int[][] { { 1, 4 }, { 4, 5 } };
        //        int[][] intervals = new int[][] { { 2, 3 }, { 4, 5 }, { 6, 7 }, { 8, 9 }, { 1, 10 } };
        int[][] intervals = new int[][] { { 2, 3 }, { 5, 5 }, { 2, 2 }, { 3, 4 }, { 3, 4 } };
        int[][] mergeIntervals = merge(intervals);
        for (int[] a : mergeIntervals) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            res = insert(res, intervals[i]);
        }
        return toArray(res);
    }

    static int[][] toArray(List<int[]> res) {
        if (res == null || res.size() == 0) {
            return new int[][] { {} };
        }
        int[][] nums = new int[res.size()][res.get(0).length];
        for (int i = 0; i < res.size(); i++) {
            nums[i] = res.get(i);
        }
        return nums;
    }

    static List<int[]> insert(List<int[]> intervals, int[] intvals) {
        List<int[]> res = new ArrayList<>();
        boolean inserted = false;
        for (int[] it : intervals) {
            if (inserted || it[1] < intvals[0]) {
                res.add(it);
            } else if (it[0] > intvals[1]) {
                res.add(intvals);
                res.add(it);
                inserted = true;
            } else {
                intvals[0] = Math.min(intvals[0], it[0]);
                intvals[1] = Math.max(intvals[1], it[1]);
            }
        }
        if (inserted == false) {
            res.add(intvals);
        }
        return res;
    }
}
