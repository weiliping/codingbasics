package com.algorithm.contest.weeklycontest224;

public class CountGoodRectangles {
    public static void main(String[] args) {
        System.out.println(countGoodRectangles(new int[][] {{5,8}, {3,9}, {5,12}, {16,5}}));    
    }
    
    public static int countGoodRectangles(int[][] rectangles) {
        int cnt = 0, maxR = Integer.MIN_VALUE;

        for (int[] r : rectangles) {
            int s = r[0] >= r[1] ? r[1] : r[0];
            if (s > maxR) {
                maxR = s;
                cnt = 1;
                continue;
            }
            if (s == maxR) {
                cnt++;
            }
        }
        return cnt;
    }
}
