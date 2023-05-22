package com.algorithm.contest.weeklycontest221;

import java.util.PriorityQueue;

public class EatenApples {
    public static void main(String[] args) {
        int[] apples = new int[] { 1, 2, 3, 5, 2 }, days = new int[] { 3, 2, 1, 4, 2 };
        System.out.println(eatenApples(apples, days));

        int[] apples1 = new int[] { 3,0,0,0,0,2 }, days1 = new int[] { 3,0,0,0,0,2 };
        System.out.println(eatenApples(apples1, days1));
        int[] apples2 = new int[] { 2, 1, 10}, days2 = new int[] { 2, 10, 1 };
        System.out.println(eatenApples(apples2, days2));

        int[] apples3 = new int[] { 1,10,17,10,12,6,20,8,8,22,14,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,5,2,1,0,0,0,0,0,0,23 };
        int[] days3 = new int[] {19999,11,18,22,5,2,14,5,20,7,17,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,2,1,4,2,7,0,0,0,0,0,0,1};
        System.out.println(eatenApples(apples3, days3));
    }

    public static int eatenApples(int[] apples, int[] days) {
        int n = apples.length, cnt = 0, i = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        while (true) {
            while (!queue.isEmpty() && queue.peek()[1] <= i) {
                queue.poll();
            }
            if (queue.isEmpty()) {
                if (i >= n) {
                    break;
                }
                if (apples[i] == 0 && days[i] == 0) {
                    i++;
                    continue;
                }
                if (apples[i] > 1) {
                    queue.offer(new int[] { apples[i] - 1, i + days[i] });
                }
                cnt++;
                i++;
                continue;
            }
            if (i < n && apples[i] != 0) {
                queue.offer(new int[] { apples[i], i + days[i] });
            }
            int[] curr = queue.poll();
            if (curr[0] > 1) {
                queue.offer(new int[] {curr[0] - 1, curr[1]});
            }
            cnt++;
            i++;
        }
        return cnt;
    }
}
