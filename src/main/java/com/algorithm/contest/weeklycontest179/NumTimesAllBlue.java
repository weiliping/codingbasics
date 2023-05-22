package com.algorithm.contest.weeklycontest179;

public class NumTimesAllBlue {

    public static void main(String[] args) {
        NumTimesAllBlue n = new NumTimesAllBlue();
        System.out.println(n.numTimesAllBlue(new int[]{2,1,3,5,4}));
        System.out.println(n.numTimesAllBlue(new int[]{3,2,4,1,5}));
        System.out.println(n.numTimesAllBlue(new int[]{4,1,2,3}));
        System.out.println(n.numTimesAllBlue(new int[]{2,1,4,3,6,5}));
        System.out.println(n.numTimesAllBlue(new int[]{1,2,3,4,5,6}));
    }

    public int numTimesAllBlue(int[] light) {
        int n = light.length, cnt = 0;
        int maxInd = -1;
        for (int i = 0; i < n; i++) {
            int ind = light[i] - 1;
            if (maxInd < ind) {
                maxInd = ind;
            }
            if (i == maxInd) {
                cnt++;
            }
        }
        return cnt;
    }
}
