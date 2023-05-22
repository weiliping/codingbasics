package com.algorithm.backtracking;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumTimeRequiredI {
    public static void main(String[] args) {
        int[] jobs = new int[] { 1, 2, 4, 7, 8 };
        int k = 2;
        MinimumTimeRequiredI time = new MinimumTimeRequiredI();
        System.out.println(time.minimumTimeRequired(jobs, k));
    }

    int n;
    int[] jobs;
    int k;
    int ans = 0;

    public void dfs(int idx, int[] array) {
        if (idx == 0) {
            int min = Integer.MAX_VALUE, max = 0;
            for (int i = 0; i < k; i++) {
                min = Math.min(min, array[i]);
                max = Math.max(max, array[i]);
            }
            ans = Math.min(ans, Math.max(min + jobs[0], max));
            return;
        }
        for (int i = 0; i < k; i++) {
            if (array[i] + jobs[idx] <= ans) {
                array[i] += jobs[idx];
                dfs(idx - 1, array);
                array[i] -= jobs[idx];
                if (array[i] == 0) {
                    break;
                }
            }
        }
    }

    public boolean check(int cap) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            q.offer(0);
        }
        for (int i = n - 1; i >= 0; i--) {
            int cur = q.poll();
            if (cur + jobs[i] > cap) {
                return false;
            }
            q.offer(cur + jobs[i]);
        }
        return true;
    }

    public int minimumTimeRequired(int[] jobs, int k) {
        this.n = jobs.length;
        this.jobs = jobs;
        this.k = k;
        int sum = 0;

        for (int job : jobs) {
            sum += job;
        }
        int max = 0;
        for (int job : jobs) {
            max = Math.max(max, job);
        }
        if (n == k) {
            return max;
        } else if (k == 1) {
            return sum;
        }
        Arrays.sort(jobs);
        int left = Math.max(max, sum / k), right = sum - jobs[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (ans == max || ans == sum / k) {
            return ans;
        }
        int[] array = new int[k];
        dfs(n - 1, array);
        return ans;
    }
}
