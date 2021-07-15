package com.algorithm.greedyalgorithm;

public class ClosestCost {
    /**
     * #greedy
     * https://leetcode-cn.com/problems/closest-dessert-cost
     * @param args
     */
    public static void main(String[] args) {
        int[] baseCosts = new int[] {1, 7};
        int[] toppingCosts = new int[] {3, 4};
        int target = 10;
        ClosestCost c = new ClosestCost();
        System.out.println(c.closestCost(baseCosts, toppingCosts, target));
        int[] baseCosts1 = new int[] {2,3};
        int[] toppingCosts1 = new int[] {4,5,100};
        int target1 = 18;
        ClosestCost c1 = new ClosestCost();
        System.out.println(c1.closestCost(baseCosts1, toppingCosts1, target1));

        int[] baseCosts2 = new int[] {3,10};
        int[] toppingCosts2 = new int[] {2, 5};
        int target2 = 9;
        ClosestCost c2 = new ClosestCost();
        System.out.println(c2.closestCost(baseCosts2, toppingCosts2, target2));

        int[] baseCosts3 = new int[] {10};
        int[] toppingCosts3 = new int[] {1};
        int target3 = 1;
        ClosestCost c3 = new ClosestCost();
        System.out.println(c3.closestCost(baseCosts3, toppingCosts3, target3));

        int[] baseCosts4 = new int[] {4};
        int[] toppingCosts4 = new int[] {9};
        int target4 = 9;
        ClosestCost c4 = new ClosestCost();
        System.out.println(c4.closestCost(baseCosts4, toppingCosts4, target4));
    }

    int answer;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        answer = Integer.MAX_VALUE;
        for (int base : baseCosts) {
            dfs(base, 0, toppingCosts, target);
        }
        return answer;
    }

    private void dfs(int sum, int idx, int[] toppingCosts, int target) {
        if (sum - target > Math.abs(answer - target)) {
            return;
        }
        if (idx == toppingCosts.length) {
            int cur = Math.abs(sum - target);
            int min = Math.abs(answer - target);
            if (cur < min || (cur == min && sum < answer)) {
                answer = sum;
            }
            return;
        }
        for (int i = 0; i < 3; i++) {
            dfs(sum + toppingCosts[idx] * i, idx + 1, toppingCosts, target);
        }
    }
}
