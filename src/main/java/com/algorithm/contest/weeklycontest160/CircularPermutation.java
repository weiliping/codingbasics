package com.algorithm.contest.weeklycontest160;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CircularPermutation {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(circularPermutation(2, 3).toArray()));
        System.out.println(Arrays.toString(circularPermutation(3, 2).toArray()));
    }

    public static List<Integer> circularPermutation(int n, int start) {
        int[] inds = new int[1];
        inds[0] = -1;
        List<Integer> g = grayCode(n, start, inds);
        List<Integer> res = new ArrayList<>();
        int len = (1 << n), max = len + inds[0];

        for (int i = inds[0]; i < max; i++) {
            res.add(g.get(i % len));
        }
        return res;
    }

    static List<Integer> grayCode(int n, int start, int[] inds) {
        if (n == 0) {
            List<Integer> l = new ArrayList<>();
            if (start == 0) {
                inds[0] = l.size();
            }
            l.add(0);
            return l;
        }
        List<Integer> list = grayCode(n - 1, start, inds);
        int num = 1 << (n - 1);
        for (int i = list.size() - 1; i >= 0; i--) {
            int v = list.get(i) + num;
            if (start == v) {
                inds[0] = list.size();
            }
            list.add(v);
        }
        return list;
    }
}
