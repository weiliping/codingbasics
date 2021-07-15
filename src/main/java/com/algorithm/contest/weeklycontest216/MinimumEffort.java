package com.algorithm.contest.weeklycontest216;

import java.util.PriorityQueue;

public class MinimumEffort {
    public static void main(String[] args) {
        MinimumEffort m = new MinimumEffort();
        int[][] tasks = new int[][] { { 1, 2 }, { 2, 4 }, { 4, 8 } };
        System.out.println(m.minimumEffort(tasks));
        int[][] tasks1 = new int[][] { { 1,3}, {2,4}, {10,11}, {10,12}, {8,9 } };
        System.out.println(m.minimumEffort(tasks1));

        int[][] tasks2 = new int[][] { { 1,7}, {2,8}, {3,9}, {4,10}, {5,11}, {6,12 } };
        System.out.println(m.minimumEffort(tasks2));
    }

    public int minimumEffort(int[][] tasks) {
        int n = tasks.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(n, (a, b) -> a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]);
        for (int[] t : tasks) {
            queue.offer(new int[] {t[0], t[1], t[1] - t[0]});
        }
        int cnt = queue.peek()[2];

        while (!queue.isEmpty()) {
            int[] t = queue.poll();
            if (cnt + t[0] >= t[1]) {
                cnt += t[0];
                continue;
            }
            cnt = t[1];
        }
        return cnt;
    }
}
