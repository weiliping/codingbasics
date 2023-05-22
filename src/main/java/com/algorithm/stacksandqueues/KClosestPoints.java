package com.algorithm.stacksandqueues;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPoints {
    public static void main(String[] args) {
        KClosestPoints points = new KClosestPoints();
        int[][] res = points.kClosest(new int[][] { { 1, 3 }, { -2, 2 } }, 1);
        for (int[] r : res) {
            System.out.println(Arrays.toString(r));
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(k, (a, b) -> b[0] - a[0]);
        int m = points.length;
        for (int i = 0; i < m; i++) {
            int[] point = points[i];
            int dist = getDistance(point);
            if (i < k) {
                queue.offer(new int[] { dist, i });
                continue;
            }
            int[] distance = queue.peek();

            if (dist < distance[0]) {
                queue.poll();
                queue.offer(new int[] { dist, i });
            }
        }

        int[][] res = new int[k][2];

        int i = 0;
        for (int[] dist : queue) {
            res[i++] = points[dist[1]];
        }
        return res;
    }

    int getDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
