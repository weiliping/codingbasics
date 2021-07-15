package com.algorithm.greedyalgorithm;

public class GasStation {

    /**
     * #134
     * https://leetcode-cn.com/problems/gas-station/
     * @param args
     */
    public static void main(String[] args) {
        int[] gas = new int[] {1, 2, 3, 4, 5};
        int[] cost = new int[] {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, start = 0, total = 0;
        for (int i = 0; i < cost.length; i++) {
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }
        return total < 0 ? -1 : start;
    }
}
