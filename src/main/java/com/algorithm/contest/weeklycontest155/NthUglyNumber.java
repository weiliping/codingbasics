package com.algorithm.contest.weeklycontest155;

import java.util.PriorityQueue;

public class NthUglyNumber {
    public static void main(String[] args) {
//        System.out.println(nthUglyNumber(3, 2, 3, 5));
//        System.out.println(nthUglyNumber(4, 2, 3, 4));
//        System.out.println(nthUglyNumber(5, 2, 11, 13));
//        System.out.println(nthUglyNumber(1000000000, 2, 217983653, 336916467));
        //1000000000
        System.out.println(nthUglyNumber(1000000000, 2, 740091218, 473796308));
    }

    public static int nthUglyNumber(int n, int a, int b, int c) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((i, j) -> i[0] == j[0] ? j[1] - i[1] : i[0] - j[0]);
        queue.offer(new int[]{a, a});
        queue.offer(new int[]{b, b});
        queue.offer(new int[]{c, c});
        while (n > 1) {
            int[] t = queue.poll();
            int next = queue.peek()[0];
            if (next == Integer.MAX_VALUE) {
                return (t[0] + (n - 1) * t[1]);
            }
            int i = ((next - t[0]) / t[1]) + 1;
            if (n <= i) {
                return (t[0] + (n - 1) * t[1]);
            }
            if (t[0] > (Integer.MAX_VALUE - i * t[1])) {
                t[0] = Integer.MAX_VALUE;
            } else {
                t[0] += i * t[1];
            }
            n -= next % t[1] == 0 ? (i - 1) : i;
            queue.offer(t);
        }
        return queue.poll()[0];
    }
}
