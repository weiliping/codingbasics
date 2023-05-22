package com.algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumProfitJobScheduling {
    /**
     * #1235
     * https://leetcode-cn.com/problems/maximum-profit-in-job-scheduling/
     *
     * @param args
     */
    public static void main(String[] args) {
        MaximumProfitJobScheduling maxProfitSchedule = new MaximumProfitJobScheduling();
        int result = maxProfitSchedule.jobScheduling(
                new int[] { 1, 2, 2, 3 },
                new int[] { 2, 5, 3, 4 },
                new int[] { 3, 4, 1, 2 });
        System.out.println(result);

        MaximumProfitJobScheduling maxProfitSchedule1 = new MaximumProfitJobScheduling();
        int result1 = maxProfitSchedule1.jobScheduling(
                new int[] { 3, 5, 3, 7, 4 },
                new int[] { 10, 8, 8, 10, 9 },
                new int[] { 10, 8, 10, 9, 9 });
        System.out.println(result1);

        MaximumProfitJobScheduling maxProfitSchedule2 = new MaximumProfitJobScheduling();
        int result2 = maxProfitSchedule2.jobScheduling(
                new int[] { 43, 13, 36, 31, 40, 5, 47, 13, 28, 16, 2, 11 },
                new int[] { 44, 22, 41, 41, 47, 13, 48, 35, 48, 26, 21, 39 },
                new int[] { 8, 20, 3, 19, 16, 8, 11, 13, 2, 15, 1, 1 });
        System.out.println(result2);
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        List<ProfitJobSchedule> schedules = new ArrayList<>(n);
        int maxEnd = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxEnd = Math.max(maxEnd, endTime[i]);
            schedules.add(new ProfitJobSchedule(startTime[i], endTime[i], profit[i]));
        }

        Collections.sort(schedules, Comparator.comparingInt(a -> a.end));
        Map<Integer, List<ProfitJobSchedule>> map = new HashMap<>();
        for (ProfitJobSchedule s : schedules) {
            List<ProfitJobSchedule> profits = map.getOrDefault(s.end, new ArrayList<>());
            profits.add(s);
            map.put(s.end, profits);
        }
        int res = 0, dp[] = new int[maxEnd + 1];

        for (int i = 1; i <= maxEnd; i++) {
            List<ProfitJobSchedule> sches = map.get(i);
            dp[i] = dp[i - 1];
            if (sches != null) {
                for (ProfitJobSchedule s : sches) {
                    dp[i] = Math.max(dp[i], s.profit + dp[s.start]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    class ProfitJobSchedule {
        private int start;
        private int end;
        private int profit;

        public ProfitJobSchedule(int startTime, int endTime, int profit) {
            this.start = startTime;
            this.end = endTime;
            this.profit = profit;
        }
    }
}
