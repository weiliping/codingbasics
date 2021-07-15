package com.algorithm.others;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SolverTwentyFour {

    public boolean judgePoint24(int[] nums) {
        // edge cases
        List<Double> list = new ArrayList<>();
        for (int n : nums) {
            list.add((double) n);
        }

        return dfs(list);
    }

    private boolean dfs(List<Double> list) {
        int n = list.size();
        if (n == 1) {
            return Math.abs(list.get(0) - 24.0) < 0.0001;
        }

        // pick 2 numbers, calculate a new number
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                List<Double> newVal = cal(list.get(i), list.get(j));
                // new list, pick remaining number from old list
                List<Double> newList = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j)
                        newList.add(list.get(k));
                }
                // backtracking, try new values
                int lastIdx = newList.size();
                for (double d : newVal) {
                    newList.add(d);
                    if (dfs(newList)) {
//                        System.out.println(Arrays.toString(newList.toArray()));
                        return true;
                    }
                    newList.remove(lastIdx);
                }
            }
        }

        return false;
    }

    private List<Double> cal(double n1, double n2) {
        List<Double> res = new ArrayList<>();
        res.add(n1 + n2);
        res.add(n1 - n2);
        res.add(n1 * n2);
        res.add(n1 / n2);
        res.add(n2 - n1);
        res.add(n2 / n1);
        return res;
    }

    public static void main(String[] args) {
        SolverTwentyFour f = new SolverTwentyFour();
//        Random r = new Random();
//        List<int[]> res = new ArrayList<>();
//        while (true) {
//            int[] sub = new int[4];
//            for (int j = 0; j < 4; j++) {
//                sub[j] = r.nextInt(10) + 1;
//            }
//            Arrays.sort(sub);
//            if (!res.contains(sub) && f.judgePoint24(sub)) {
//                res.add(sub);
//            }
//            if (res.size() == 1000) {
//                break;
//            }
//        }
//        for (int[] a : res) {
//            System.out.println(Arrays.toString(a));
//        }

//        System.out.println(f.judgePoint24(new int[] { 4, 1, 8, 7 }));
//        System.out.println(f.judgePoint24(new int[] { 5, 5, 5, 1 }));
//        System.out.println(f.judgePoint24(new int[] {1, 3, 4, 6}));
//        System.out.println(f.judgePoint24(new int[] {2, 5, 9, 9}));
//        System.out.println(f.judgePoint24(new int[] {4, 4, 7, 7}));
//        System.out.println(f.judgePoint24(new int[] {5, 8, 9, 10}));
//        System.out.println(f.judgePoint24(new int[]{2, 4, 5, 10}));
//        System.out.println(f.judgePoint24(new int[]{2, 4, 7, 8}));
//        System.out.println(f.judgePoint24(new int[]{3, 4, 6, 7}));
//        System.out.println(f.judgePoint24(new int[] { 6, 7, 9, 10 }));
//        System.out.println(f.judgePoint24(new int[]{3, 4, 8, 8}));
//        System.out.println(f.judgePoint24(new int[]{1, 2, 8, 10}));
//        System.out.println(f.judgePoint24(new int[]{2, 2, 7, 10}));
//        System.out.println(f.judgePoint24(new int[]{2, 4, 1, 10}));
        System.out.println(f.judgePoint24(new int[]{1, 5, 7, 7}));
//        System.out.println(f.judgePoint24(new int[]{1, 2, 11, 11}));
    }
}
