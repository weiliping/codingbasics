package com.algorithm.contest.weeklycontest217;

import java.util.Arrays;

public class MaximumWealth {
    public static void main(String[] args) {
        MaximumWealth m = new MaximumWealth();
        System.out.println(m.maximumWealth(new int[][]{{1,2,3}, {3,2,1}}));
        System.out.println(m.maximumWealth(new int[][]{{1,5}, {7,3}, {3,5}}));
        System.out.println(m.maximumWealth(new int[][]{{2,8,7}, {7,1,3}, {1,9,5}}));
    }
    public int maximumWealth(int[][] accounts) {
        int maxSum = Integer.MIN_VALUE, subSum = 0;
        for (int[] a : accounts) {
            subSum = Arrays.stream(a).sum();
            if (maxSum < subSum) {
                maxSum = subSum;
            }
        }
        return maxSum;
    }
}
