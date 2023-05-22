package com.algorithm.contest.weeklycontest208;

public class MinOperationsMaxProfit {
    public static void main(String[] args) {
        MinOperationsMaxProfit m = new MinOperationsMaxProfit();
//        System.out.println(m.minOperationsMaxProfit(new int[] {8, 3}, 5, 6));
//        System.out.println(m.minOperationsMaxProfit(new int[] {10, 9, 6}, 6, 4));
//        System.out.println(m.minOperationsMaxProfit(new int[] {3,4,0,5,1}, 1, 92));
//        System.out.println(m.minOperationsMaxProfit(new int[] {10,10,6,4,7}, 3, 8));
        System.out.println(m.minOperationsMaxProfit(new int[] {2}, 2, 4));
    }
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        if (4 * boardingCost <= runningCost) {
            return -1;
        }
        int n = customers.length, left = 0, c = 0, profile = 0, cnt = -1;
        for (int i = 0; i < n; i++) {
            int cur = customers[i] + left;
            if (cur > 4) {
                c += 4;
                left = cur - 4;
            } else {
                c += cur;
                left = 0;
            }
            int subProfile = c * boardingCost - (i + 1) * runningCost;
            if (profile < subProfile) {
                profile = subProfile;
                cnt = i + 1;
            }
        }
        if (left > 0) {
            int s = left % 4, lCnt = left / 4;

            if (s * boardingCost - runningCost > 0) {
                lCnt++;
            }
            cnt += lCnt;
        }
        return cnt;
    }
}
