package com.algorithm.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalIntersection {

    /**
     * #986
     * https://leetcode-cn.com/problems/interval-list-intersections/
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] firstList = new int[][] { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } },
                secondList = new int[][] { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };
        IntervalIntersection i = new IntervalIntersection();
        int[][] res = i.intervalIntersection(firstList, secondList);
        for (int[] r : res) {
            System.out.println(Arrays.toString(r));
        }

        int[][] res1 = i.intervalIntersectionI(firstList, secondList);
        for (int[] r : res1) {
            System.out.println(Arrays.toString(r));
        }
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        List<Integer> res = new ArrayList<>();

        while (i < firstList.length && j < secondList.length) {
            int minEnd = Math.min(secondList[j][1], firstList[i][1]);
            int maxHead = Math.max(secondList[j][0], firstList[i][0]);
            if (minEnd >= maxHead) {
                res.add(maxHead);
                res.add(minEnd);
            }
            if (secondList[j][1] >= firstList[i][1]) {
                i++;
            } else {
                j++;
            }
        }
        int size = res.size() / 2;
        int[][] ans = new int[size][2];
        for (int k = 0; k < size; k++) {
            ans[k][0] = res.get(2 * k);
            ans[k][1] = res.get(2 * k + 1);

        }
        return ans;
    }

    public int[][] intervalIntersectionI(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) {
            return new int[0][];
        }
        ArrayList<int[]> res = new ArrayList<>();
        helper(res, firstList, secondList, 0, 0);
        return res.toArray(new int[0][]);
    }

    private void helper(ArrayList<int[]> res, int[][] firstList, int[][] secondList, int firstIdx, int secondIdx) {
        if (firstIdx == firstList.length || secondIdx == secondList.length) {
            return;
        }
        if (firstList[firstIdx][0] > secondList[secondIdx][1]) {
            helper(res, firstList, secondList, firstIdx, secondIdx + 1);
        } else if (firstList[firstIdx][1] < secondList[secondIdx][0]) {
            helper(res, firstList, secondList, firstIdx + 1, secondIdx);
        } else {
            int left = Math.max(firstList[firstIdx][0], secondList[secondIdx][0]);
            int right = Math.min(firstList[firstIdx][1], secondList[secondIdx][1]);
            res.add(new int[] { left, right });
            if (firstList[firstIdx][1] < secondList[secondIdx][1]) {
                helper(res, firstList, secondList, firstIdx + 1, secondIdx);
            } else if (firstList[firstIdx][1] > secondList[secondIdx][1]) {
                helper(res, firstList, secondList, firstIdx, secondIdx + 1);
            } else {
                helper(res, firstList, secondList, firstIdx + 1, secondIdx + 1);
            }
        }
    }
}
