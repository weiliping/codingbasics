package com.algorithm.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    /**
     * #57
     * https://leetcode-cn.com/problems/insert-interval/
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] intervals = new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] intvals = new int[] { 4, 8 };
        int[][] res = insert(intervals, intvals);
        for (int[] r : res) {
            System.out.println(Arrays.toString(r));
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][] { newInterval };
        }
        boolean inserted = false;
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            int[] nums = intervals[i];
            if (inserted || nums[1] < newInterval[0]) {
                res.add(nums);
            } else if (nums[0] > newInterval[1]) {
                res.add(newInterval);
                res.add(nums);
                inserted = true;
            } else {
                newInterval[0] = Math.min(newInterval[0], nums[0]);
                newInterval[1] = Math.max(newInterval[1], nums[1]);
            }
        }
        if (!inserted) {
            res.add(newInterval);
        }
        int[][] resInts = new int[res.size()][res.get(0).length];
        for (int i = 0; i < res.size(); i++) {
            resInts[i] = res.get(i);
        }
        return resInts;
    }
}
