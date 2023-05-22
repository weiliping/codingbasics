package com.algorithm.contest.biweeklycontest57;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SmallestChair {

    public static void main(String[] args) {
        SmallestChair s = new SmallestChair();

//        int[][] times1 = new int[][] {{1,4}, {2,3}, {4,6}};
//        int targetFriend1 = 1;
//        System.out.println(s.smallestChair(times1, targetFriend1));
//
//        int[][] times2 = new int[][] {{3,10}, {1,5}, {2,6}};
//        int targetFriend2 = 0;
//        System.out.println(s.smallestChair(times2, targetFriend2));

//        int[][] times3 = new int[][] {{3,10}, {1,5}, {2,6}, {6, 9}};
//        int targetFriend3 = 3;
//        System.out.println(s.smallestChair(times3, targetFriend3));

        int[][] times4 = new int[][] {{33889,98676}, {80071,89737}, {44118,52565}, {52992,84310}, {78492,88209}, {21695,67063}, {84622,95452}, {98048,98856}, {98411,99433}, {55333,56548}, {65375,88566}, {55011,62821}, {48548,48656}, {87396,94825}, {55273,81868}, {75629,91467}};
        int targetFriend4 = 6;
        System.out.println(s.smallestChair(times4, targetFriend4));
    }

    public int smallestChair(int[][] times, int targetFriend) {
        PriorityQueue<int[]> leaveQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> chairQueue = new PriorityQueue<>();
        int targetTime = times[targetFriend][0], n = times.length;

        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        int chairInd = 0;
        for (int i = 0; i < n; i++){
            int[] t = times[i];
            while (!leaveQueue.isEmpty() && leaveQueue.peek()[0] <= t[0]) {
                int[] l = leaveQueue.poll();
                chairQueue.offer(l[1]);
            }
            if (t[0] == targetTime) {
                if (chairQueue.isEmpty()) {
                    return chairInd;
                } else {
                    return chairQueue.poll();
                }
            }
            if (chairQueue.isEmpty()) {
                leaveQueue.offer(new int[] {t[1], chairInd});
                chairInd++;
            } else {
                leaveQueue.offer(new int[] {t[1], chairQueue.poll()});
            }
        }
        if (chairQueue.isEmpty()) {
            return chairInd;
        } else {
            return chairQueue.poll();
        }
    }
}
