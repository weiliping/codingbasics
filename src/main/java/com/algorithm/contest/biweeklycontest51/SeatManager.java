package com.algorithm.contest.biweeklycontest51;

public class SeatManager {

    public static void main(String[] args) {
        SeatManager s = new SeatManager(2);
        System.out.println(s.reserve());
        s.unreserve(1);
        System.out.println(s.reserve());
        System.out.println(s.reserve());
        s.unreserve(2);
        System.out.println(s.reserve());
        s.unreserve(1);
        System.out.println(s.reserve());
        s.unreserve(2);
        System.out.println(s.reserve());
    }
    int startInd;
    boolean[] queue;
    public SeatManager(int n) {
        queue = new boolean[n];
        startInd = 0;
    }

    public int reserve() {
        int r = -1;
        for (int j = startInd + 1; j < queue.length; j++) {
            if (!queue[j]) {
                r = j;
                break;
            }
        }
        queue[startInd] = true;
        int res = startInd + 1;
        startInd = r;
        return res;
    }

    public void unreserve(int seatNumber) {
        int ind = seatNumber - 1;
        queue[ind] = false;
        if (startInd == -1 || ind < startInd) {
            startInd = ind;
        }
    }
}
