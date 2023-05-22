package com.algorithm.mergeintervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinMeetingRooms {
    /**
     * #253
     * https://github.com/weiliping/Grokking-the-Coding-Interview-Patterns-for-Coding-Questions/blob/master/4.%20Pattern%20Merge%20Intervals/Problem%20Challenge%201%20-%20Minimum%20Meeting%20Rooms%20(hard)%20.py
     * @param args
     */
    public static void main(String[] args) {
        int[][] intervals = new int[][] { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        System.out.println(minMeetingRooms(intervals));

        int[][] intervals2 = new int[][] { {1,4}, {2,5}, {7,9}};
        System.out.println(minMeetingRooms(intervals2));
        int[][] intervals3 = new int[][] { {6,7}, {2,4}, {8,12}};
        System.out.println(minMeetingRooms(intervals3));
        int[][] intervals4 = new int[][] { {1,4}, {2,3}, {3,6}};
        System.out.println(minMeetingRooms(intervals4));
        int[][] intervals5 = new int[][] { {4,5}, {2,3}, {2,4}, {3,5}};
        System.out.println(minMeetingRooms(intervals5));
    }

    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int[] in : intervals) {
            if (!queue.isEmpty() && queue.peek() <= in[0]) {
                queue.poll();
            }
            queue.offer(in[1]);
        }
        return queue.size();
    }
}
