package com.algorithm.twoheaps;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class RightInterval {
    /**
     * #436
     * https://leetcode-cn.com/problems/find-right-interval/
     * @param args
     */
    public static void main(String[] args) {
        int[][] intervals = new int[][] {{3,4},{2,3},{1,2}};
        System.out.println(Arrays.toString(findRightInterval(intervals)));
        System.out.println(Arrays.toString(findRightIntervalII(intervals)));
    }

    public static int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            if (map.get(intervals[i][0]) == null) {
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                pq.add(i);
                map.put(intervals[i][0], pq);
            } else {
                map.get(intervals[i][0]).add(i);
            }
        }
        for (int i = 0; i < intervals.length; i++) {
            Integer key = map.ceilingKey(intervals[i][1]);
            res[i] = key != null ? map.get(key).peek() : -1;
        }
        return res;
    }

    public static int[] findRightIntervalII(int[][] intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            min = Math.min(min, interval[0]);
            max = Math.max(max, interval[1]);
        }
        int[] index = new int[max - min + 1];
        Arrays.fill(index, -1);
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            index[intervals[i][0] - min] = i;
        }
        for (int i = index.length - 2; i >= 0; i--) {
            if (index[i] == -1) {
                index[i] = index[i + 1];
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = index[intervals[i][1] - min];
        }
        return ans;
    }
}
