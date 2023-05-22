package com.algorithm.contest.weeklycontest310;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinGroups {
    public static void main(String[] args) {
        int[][] intervals = new int[][] {{5,10},{6,8},{1,5},{2,3},{1,10}};
        System.out.println(minGroups(intervals));

        int[][] intervals2 = new int[][] {{1,3},{5,6},{8,10},{11,13}};
        System.out.println(minGroups(intervals2));
    }

    public static int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int n = intervals.length;
        queue.offer(intervals[0][1]);
        for (int i = 1; i < n; i++) {
            if (queue.peek() < intervals[i][0]) {
                queue.poll();
            }
            queue.offer(intervals[i][1]);
        }
        return queue.size();
    }
}
