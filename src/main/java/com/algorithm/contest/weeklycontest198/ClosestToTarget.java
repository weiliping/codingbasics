package com.algorithm.contest.weeklycontest198;

import java.util.ArrayList;

class ClosestToTarget {

    /**
     * #1521
     * https://leetcode-cn.com/problems/find-a-value-of-a-mysterious-function-closest-to-target/
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[] {9, 12, 3, 7, 15};
        System.out.println(new ClosestToTarget().closestToTarget(arr, 5));
    }

    public int closestToTarget(int[] arr, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr) {
            if (list.isEmpty() || i != list.get(list.size() - 1)) {
                list.add(i);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int X = list.get(i);
            for (int j = i; j < list.size(); j++) {
                X &= list.get(j);
                ans = Math.min(ans, Math.abs(target - X));
                if (X <= target)
                    break;
            }
        }
        return ans;
    }
}