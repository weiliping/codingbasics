package com.algorithm.contest.weeklycontest213;

import java.util.PriorityQueue;

public class FurthestBuilding {

    public static void main(String[] args) {
        FurthestBuilding f = new FurthestBuilding();
//        System.out.println(f.furthestBuildingII(new int[] {4,2,7,6,9,14,12}, 5, 1));
//        System.out.println(f.furthestBuildingII(new int[] {4,12,2,7,3,18,20,3,19}, 10, 2));
//        System.out.println(f.furthestBuildingII(new int[] {14,3,19,3}, 17, 0));
        System.out.println(f.furthestBuildingII(new int[] {2,7,9,12}, 5, 1));
    }
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length, l = 0, r = n;
        int[] costs = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            if (heights[i + 1] <= heights[i]) {
                continue;
            }
            costs[i] = heights[i + 1] - heights[i];
        }

        while (l < r) {
            int mid = l + ((r - l) >> 1);
            PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
            for (int i = 0; i < mid; i++) {
                if (costs[i] == 0) {
                    continue;
                }
                q.offer(costs[i]);
            }
            int sum = 0, k = ladders, temp = -1;
            while (!q.isEmpty()) {
                if (k > 0) {
                    temp = q.poll();
                    k--;
                    continue;
                }
                sum += q.poll();
            }

            if (sum <= bricks) {
                if (mid == n - 1) {
                    return mid;
                }
                int next = costs[mid];
                if (temp != -1 && next > temp) {
                    next = temp;
                }
                if (sum + next > bricks) {
                    return mid;
                }
                l = mid + 1;
                continue;
            }
            r = mid - 1;
        }
        return l;
    }

    public int furthestBuildingII(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int i = 0;
        for (; i < n - 1; i++) {
            if (heights[i + 1] <= heights[i]) {
                continue;
            }
            int diff = heights[i + 1] - heights[i];
            if (bricks >= diff) {
                bricks -= diff;
                q.offer(diff);
            } else if (ladders > 0) {
                ladders--;
                if (!q.isEmpty() && q.peek() > diff) {
                    q.offer(diff);
                    bricks += q.poll() - diff;
                }
            } else {
                break;
            }
        }
        return i;
    }
}
