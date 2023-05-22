package com.algorithm.contest.weeklycontest176;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxEvents {

    public static void main(String[] args) {
        MaxEvents m = new MaxEvents();

        int[][] events = new int[][]{{1,2}, {2,3}, {3,4}};
        System.out.println(m.maxEvents(events));

        int[][] events1 = new int[][]{{1,2}, {2,3}, {3,4}, {1,2}};
        System.out.println(m.maxEvents(events1));

        int[][] events2 = new int[][]{{1,4}, {4,4}, {2,2}, {3,4}, {1,1}};
        System.out.println(m.maxEvents(events2));

        int[][] events3 = new int[][]{{1,100000}};
        System.out.println(m.maxEvents(events3));

        int[][] events4 = new int[][]{{1,1}, {1,2}, {1,3}, {1,4}, {1,5}, {1,6}, {1,7}};
        System.out.println(m.maxEvents(events4));

        int[][] events5 = new int[][]{{1,5}, {1,5}, {1,5}, {2,3}, {2,3}};
        System.out.println(m.maxEvents(events5));
    }
    public int maxEvents(int[][] events) {
        int n = events.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(n, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int[] event : events) {
            queue.offer(event);
        }

        int cnt = 0;
        while (!queue.isEmpty()) {
            int preDate = queue.poll()[0];
            cnt++;
            int nextStart = preDate + 1;
            while (!queue.isEmpty() && preDate == queue.peek()[0]) {
                int[] dt = queue.poll();
                if (nextStart <= dt[1] ) {
                    queue.offer(new int[] { nextStart, dt[1]});
                }
            }
            preDate++;
        }
        return cnt;
    }

    public int maxEventsI(int[][] events) {
        int n = events.length;
        int j = 1, cnt = 1;

        Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int currDt = events[0][0];
        PriorityQueue<int[]> in = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        while (true) {
            currDt++;
            while (!in.isEmpty() && in.peek()[1] < currDt) {
                in.poll();
            }
            while (j < n && events[j][0] <= currDt) {
                in.offer(events[j]);
                j++;
            }
            if (!in.isEmpty()) {
                in.poll();
                cnt++;
            }
            if (j >= n) {
                break;
            }
        }

        while (!in.isEmpty()) {
            currDt++;
            while (!in.isEmpty() && in.peek()[1] < currDt) {
                in.poll();
            }
            if (!in.isEmpty()) {
                in.poll();
                cnt++;
            }
        }
        return cnt;
    }
}
