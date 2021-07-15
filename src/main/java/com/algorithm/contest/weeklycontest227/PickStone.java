package com.algorithm.contest.weeklycontest227;

import java.util.PriorityQueue;

public class PickStone {

    public static void main(String[] args) {
        System.out.println(pickStone(2, 4, 6));
        System.out.println(pickStone(4, 4, 6));
        System.out.println(pickStone(1, 8, 8));
    }

    public static int pickStone(int a, int b, int c) {
        PriorityQueue<Integer> q = new PriorityQueue<>(3, (i, j) -> j - i);
        q.offer(a);
        q.offer(b);
        q.offer(c);
        int cnt = 0;
        while (!q.isEmpty() && q.size() >= 2) {
            Integer n1 = q.poll();
            Integer n2 = q.poll();
            cnt++;
            n1--;
            n2--;
            if (n1 > 0) {
                q.offer(n1);
            }
            if (n2 > 0) {
                q.offer(n2);
            }
        }
        return cnt;
    }
}
