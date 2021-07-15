package com.algorithm.practice;

public class CanCompleteCircuit {
    public static void main(String[] args) {
//        int[] gas = new int[]{1,2,3,4,5};
//        int[] cost = new int[]{3,4,5,1,2};
//        System.out.println(new CanCompleteCircuit().canCompleteCircuit(gas, cost));

//        int[] gas = new int[]{2, 3, 4};
//        int[] cost = new int[]{3, 4, 3};
//        System.out.println(new CanCompleteCircuit().canCompleteCircuit(gas, cost));

//        int[] gas = new int[]{5,1,2,3,4};
//        int[] cost = new int[]{4,4,1,5,1};
//        System.out.println(new CanCompleteCircuit().canCompleteCircuit(gas, cost));

        int[] gas = new int[]{2};
        int[] cost = new int[]{2};
        System.out.println(new CanCompleteCircuit().canCompleteCircuit(gas, cost));
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        for (int i = 0; i < n; i++) {
            if (gas[i] >= cost[i]) {
                if (canComplete(gas, cost, i, n)) {
                    return i;
                }
            }
        }
        return -1;
    }

    boolean canComplete(int[] gas, int[] cost, int startInd, int n) {
        int g = gas[startInd], i = n;
        while (i > 0) {

            g -= cost[startInd % n];
            i--;
            startInd++;
            if (g < 0) {
                return false;
            }
            g += gas[startInd % n];
        }
        return g >= 0;
    }
}
