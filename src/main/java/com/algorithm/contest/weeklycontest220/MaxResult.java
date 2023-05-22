package com.algorithm.contest.weeklycontest220;

import java.util.PriorityQueue;

public class MaxResult {
    public static void main(String[] args) {
        MaxResult r = new MaxResult();
        System.out.println(r.maxResult(new int[] { 1, -1, -2, 4, -7, 3 }, 2));
        System.out.println(r.maxResult(new int[] { 10, -5, -2, 4, 0, 3 }, 3));
        System.out.println(r.maxResult(new int[] { 1, -5, -20, 4, -1, 3, -6, -3 }, 2));
    }

    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> b.v - a.v);
        q.offer(new Pair(nums[0], 0));
        int ans = nums[0];
        for (int i = 1; i < n; i++) {
            while (!q.isEmpty() && i - q.peek().k > k) {
                q.poll();
            }
            ans = q.peek().v + nums[i];
            q.offer(new Pair(ans, i));
        }

        return ans;
    }

    class Pair {
        int v;
        int k;
        public Pair(int val, int key) {
            v = val;
            k = key;
        }
    }
}
