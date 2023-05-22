package com.algorithm.mergeintervals;

import java.util.Arrays;
import java.util.Comparator;

public class ConflictingAppointments {
    /**
     * #252
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(canAttendMeetings(new int[][] {{1, 4}, {2, 5}, {7, 9}}));
        System.out.println(canAttendMeetings(new int[][] {{6, 7}, {2, 4}, {8, 12}}));
    }
    /**
     * 
     * @param intervals
     * @return
     */
    public static boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null) {
            return false;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }

        return true;
    }
}
