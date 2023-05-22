package com.algorithm.contest.weeklycontest213;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CanFormArray {

    public static void main(String[] args) {
        CanFormArray c = new CanFormArray();
//        System.out.println(c.canFormArray(new int[] {85}, new int[][] {{85}}));
//        System.out.println(c.canFormArray(new int[] {15, 88}, new int[][] {{88}, {15}}));
//        System.out.println(c.canFormArray(new int[] {49,18,16}, new int[][] {{16,18,49}}));
//        System.out.println(c.canFormArray(new int[] {91,4,64,78}, new int[][] {{78}, {4, 64}, {91}}));
//        System.out.println(c.canFormArray(new int[] {1, 3, 5, 7}, new int[][] {{2, 4, 6, 8}}));
        System.out.println(c.canFormArray(new int[] {1, 2, 3}, new int[][] {{1, 3}, {2}}));
//        System.out.println(c.canFormArray(new int[] {91,2,4,64,5,78,12,9}, new int[][] {{78,12,3}, {4,64,5}, {91,2}}));
    }


    public boolean canFormArray(int[] arr, int[][] pieces) {
        if (arr.length == 1) {
            return arr[0] == pieces[0][0];
        }

        int n = pieces.length;
        Map<Integer, int[]> mp = new HashMap<>();
        int[] lens = new int[n];
        for (int i = 0; i < n; i++) {
            int m = pieces[i].length;
            lens[i] = m;
            for (int j = 0; j < m; j++) {
                mp.put(pieces[i][j], new int[]{i, j});
            }
        }
        boolean canFrom = true;
        for (int i = 0; i < arr.length - 1; i++) {
            int[] prev = mp.get(arr[i]);
            int[] curr = mp.get(arr[i + 1]);
            if (prev == null || curr == null) {
                return false;
            }
            if (prev[1] + 1 == lens[prev[0]] && prev[0] != curr[0]) {
                continue;
            }
            if (prev[1] != curr[1] - 1) {
                return false;
            }
        }
        return canFrom;
    }

    public boolean canFormArrayI(int[] arr, int[][] pieces) {
        int[] f = new int[101];
        int zero = arr[0];
        for (int i=0; i<arr.length; i++) {
            f[arr[i]] = i;
        }

        for (int[] p : pieces) {
            if (p.length == 1) {
                if (f[p[0]] != 0) continue;
                else if (f[p[0]] == 0 && zero == p[0]) continue;
                else return false;
            } else {
                int pre = f[p[0]];
                for (int i=1; i<p.length; i++) {
                    if (f[p[i]] != pre + 1) return false;
                    pre = f[p[i]];
                }
            }
        }
        return true;
    }
}
