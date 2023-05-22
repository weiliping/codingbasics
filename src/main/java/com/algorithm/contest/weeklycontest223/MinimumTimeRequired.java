package com.algorithm.contest.weeklycontest223;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs/
 * #1723. 完成所有工作的最短时间
 *
 * 给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
 *
 * 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
 *
 * 返回分配方案中尽可能 最小 的 最大工作时间 。
 *
 * 示例 1：
 * 输入：jobs = [3,2,3], k = 3
 * 输出：3
 * 解释：给每位工人分配一项工作，最大工作时间是 3 。
 *
 * 示例 2：
 * 输入：jobs = [1,2,4,7,8], k = 2
 * 输出：11
 * 解释：按下述方式分配工作：
 * 1 号工人：1、2、8（工作时间 = 1 + 2 + 8 = 11）
 * 2 号工人：4、7（工作时间 = 4 + 7 = 11）
 * 最大工作时间是 11 。
 *  
 *
 * 提示：
 * 1 <= k <= jobs.length <= 12
 * 1 <= jobs[i] <= 107
 */
public class MinimumTimeRequired {
    public static void main(String[] args) {
        int[] jobs = new int[] { 1, 2, 8, 4, 7 };
        int k = 2;
        MinimumTimeRequired time = new MinimumTimeRequired();
        System.out.println(time.minimumTimeRequired(jobs, k));
    }

    int ans = 0;

    public int minimumTimeRequired(int[] jobs, int k) {
        Queue<Integer> que = new PriorityQueue<>();
        Arrays.sort(jobs);
        for (int i = 0; i < k; i++) {
            que.offer(0);
        }
        for (int i = jobs.length - 1; i >= 0; i--) {
            que.offer(jobs[i] + que.poll());
        }
        while (!que.isEmpty()) {
            ans = que.poll();
        }

        int[] man = new int[k];
        backtrack(jobs, k, jobs.length - 1, man);

        return ans;
    }

    public void backtrack(int[] jobs, int k, int x, int[] workers) {
        if (x == -1) {
            int max = 0;
            for (int i = 0; i < k; i++) {
                max = Math.max(max, workers[i]);
            }
            ans = Math.min(ans, max);
            return;
        }

        int[] temWorkers = new int[k];
        for (int i = 0; i < k; i++) {
            temWorkers[i] = workers[i];
        }
        Arrays.sort(temWorkers);

        for (int i = 0; i < k; i++)
            if ((i == 0 || temWorkers[i] != temWorkers[i - 1]) && (temWorkers[i] + jobs[x] < ans)) {
                temWorkers[i] += jobs[x];
                backtrack(jobs, k, x - 1, temWorkers);
                temWorkers[i] -= jobs[x];
            }
        return;
    }
}
