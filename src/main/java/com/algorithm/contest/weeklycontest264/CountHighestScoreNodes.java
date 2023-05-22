package com.algorithm.contest.weeklycontest264;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountHighestScoreNodes {

    public static void main(String[] args) {
//        int[] parents = new int[] {-1,2,0,2,0};
//        System.out.println(countHighestScoreNodes(parents));
//
//        int[] parents1 = new int[] {-1,2,0};
//        System.out.println(countHighestScoreNodes(parents1));
        System.out.println(args[0]);
        String[] str = args[0].split(",");
        int[] p2 = new int[str.length];
        int i = 0;
        for (String s : str) {
            p2[i++] = Integer.parseInt(s);
        }
//        int[] parents1 = new int[] {};
        System.out.println(countHighestScoreNodes(p2));
    }
    public static int countHighestScoreNodes(int[] parents) {
        int n = parents.length;
        Map<Integer, Integer[]> tree = new HashMap<>();
        for (int i = 1; i < n; i++) {
            Integer[] r = tree.getOrDefault(parents[i], new Integer[2]);
            if (r[0] == null) {
                r[0] = i;
            } else {
                r[1] = i;
            }
            tree.put(parents[i], r);
        }
        Map<Integer, Integer[]> cnts = new HashMap<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            Integer root = stack.pop();
            Integer[] r = tree.get(root);
            if (r == null) {
                Integer[] cnt = new Integer[2];
                cnt[0] = cnt[1] = 0;
                cnts.put(root, cnt);
                continue;
            }
            Integer[] cnt = cnts.getOrDefault(root, new Integer[2]);
            boolean hasLeft = true, hasRight = true;
            if (r[0] == null) {
                cnt[0] = 0;
            } else {
                Integer[] lChild = cnts.get(r[0]);
                if (lChild != null) {
                    cnt[0] = lChild[0] + 1 + lChild[1];
                } else {
                    hasLeft = false;
                }
            }
            if (r[1] == null) {
                cnt[1] = 0;
            } else {
                Integer[] rChild = cnts.get(r[1]);
                if (rChild != null) {
                    cnt[1] = rChild[0] + 1 + rChild[1];
                } else {
                    hasRight = false;
                }
            }
            if (hasLeft && hasRight) {
                cnts.put(root, cnt);
                continue;
            }

            stack.push(root);
            if (!hasLeft) {
                stack.push(r[0]);
            }
            if (!hasRight) {
                stack.push(r[1]);
            }
        }
        long max = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            Integer[] l = cnts.get(i);
            long sub = 1l;
            if (l[0] != 0) {
                sub *= l[0];
            }
            if (l[1] != 0) {
                sub *= l[1];
            }
            int left = n - l[0] - l[1] - 1;
            if (left != 0) {
                sub *= left;
            }
            if (max < sub) {
                max = sub;
                cnt = 1;
                continue;
            }
            if (max == sub) {
                cnt++;
            }
        }
        return cnt;
    }
}
