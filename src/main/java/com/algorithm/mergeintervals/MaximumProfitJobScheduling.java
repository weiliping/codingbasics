package com.algorithm.mergeintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumProfitJobScheduling {
    public class Task {
        public int start;
        public int end;
        public int profit;

        public Task(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    /**
     * #1235
     * https://leetcode-cn.com/problems/maximum-profit-in-job-scheduling/
     * @param args
     */
    public static void main(String[] args) {
       /* MaximumProfitJobScheduling maximumProfitJobScheduling = new MaximumProfitJobScheduling();
        int result = maximumProfitJobScheduling.jobScheduling(
                new int[]{1, 2, 3, 3},
                new int[]{3, 4, 5, 6},
                new int[]{50, 10, 40, 70});
        System.out.println(result);*/

       /* MaximumProfitJobScheduling maximumProfitJobScheduling = new MaximumProfitJobScheduling();
        int result = maximumProfitJobScheduling.jobScheduling(
                new int[]{1, 2, 3, 4, 6},
                new int[]{3, 5, 10, 6, 9},
                new int[]{20, 20, 100, 70, 60});
        System.out.println(result);*/
//        MaximumProfitJobScheduling maximumProfitJobScheduling = new MaximumProfitJobScheduling();
//        int result = maximumProfitJobScheduling.jobScheduling(
//                new int[]{4, 2, 4, 8, 2},
//                new int[]{5, 5, 5, 10, 8},
//                new int[]{1, 2, 8, 10, 4});
//        System.out.println(result);

//        MaximumProfitJobScheduling maximumProfitJobScheduling = new MaximumProfitJobScheduling();
//        int result = maximumProfitJobScheduling.jobScheduling(
//                new int[]{1,2,2,3},
//                new int[]{2,5,3,4},
//                new int[]{3,4,1,2});
//        System.out.println(result);

//        MaximumProfitJobScheduling maximumProfitJobScheduling = new MaximumProfitJobScheduling();
//        int result = maximumProfitJobScheduling.jobScheduling(
//                new int[]{3,5,3,7,4},
//                new int[]{10,8,8,10,9},
//                new int[]{10,8,10,9,9});
//        System.out.println(result);

        MaximumProfitJobScheduling maximumProfitJobScheduling = new MaximumProfitJobScheduling();
        int result = maximumProfitJobScheduling.jobScheduling(
                new int[]{43,13,36,31,40,5,47,13,28,16,2,11},
                new int[]{44,22,41,41,47,13,48,35,48,26,21,39},
                new int[]{8,20,3,19,16,8,11,13,2,15,1,1});
        System.out.println(result);
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < profit.length; i++) {
            tasks.add(new Task(startTime[i], endTime[i], profit[i]));
        }
        Collections.sort(tasks, (u, v) -> {
            if (u.end > v.end) return 1;
            else if (u.end < v.end) return -1;
            else return 0;
        });

        Map<Integer, List<Task>> map = new HashMap<>();
        int maxTask = 0;
        for (Task t : tasks) {
            maxTask = Math.max(maxTask, t.end);
            map.compute(t.end, (k, v) -> v == null ? new ArrayList<Task>() : v).add(t);
        }
        int[] cache = new int[maxTask + 1];

        int maxProfit = 0;
        for (int i = 1; i < cache.length; i++) {
            List<Task> tList = map.get(i);
            if (tList == null)
                cache[i] = cache[i - 1];
            else {
                cache[i] = cache[i - 1];
                for (Task t : tList) {
                    cache[i] = Math.max(cache[i], t.profit + cache[t.start]);
                }
            }
            maxProfit = Math.max(maxProfit, cache[i]);
        }
        return maxProfit;
    }
}
