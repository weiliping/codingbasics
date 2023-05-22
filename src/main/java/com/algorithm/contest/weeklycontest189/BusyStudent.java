package com.algorithm.contest.weeklycontest189;

public class BusyStudent {
    public static void main(String[] args) {
        BusyStudent b = new BusyStudent();
        System.out.println(b.busyStudent(new int[]{1,2,3}, new int[] {3,2,7}, 4));
    }
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int cnt = 0, n = startTime.length;
        for (int i = 0; i < n; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                cnt++;
            }
        }

        return cnt;
    }
}
