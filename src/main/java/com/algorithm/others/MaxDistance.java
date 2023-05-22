package com.algorithm.others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxDistance {
    /**
     * @param args
     */
    public static void main(String[] args) {
        MaxDistance maxDis = new MaxDistance();
        System.out.println(maxDis.maxDistance(new int[] { 3, 5, 4, 2 }));
    }

    public int maxDistance(int[] A) {
        if (A == null || A.length < 2) {
            return 0;
        }
        int n = A.length;
        List<Helper> helpers = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            helpers.add(new Helper(i, A[i]));
        }

        Collections.sort(helpers);

        int[] rightDifs = new int[n];
        int rightDif = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            rightDif = Math.max(rightDif, helpers.get(i).i);
            rightDifs[i] = rightDif;
        }
        int maxDiff = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            maxDiff = Math.max(maxDiff, rightDifs[i]);
        }
        return maxDiff;
    }

    class Helper implements Comparable<Helper> {
        public int i;
        public int v;

        public Helper(int i, int v) {
            this.i = i;
            this.v = v;
        }

        @Override
        public int compareTo(Helper helper) {
            if (this.v > helper.v) {
                return 1;
            } else if (this.v < helper.v) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
