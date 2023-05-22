package com.algorithm.greedyalgorithm;

import java.util.Arrays;

public class MinDeletionSizeII {
    public static void main(String[] args) {
        System.out.println(minDeletionSize(new String[] {"ca","bb","ac"}));
    }
    public static int minDeletionSize(String[] A) {
        int n = A.length, wlen = A[0].length(), res = 0;
        String[] curr = new String[n];
        Arrays.fill(curr, "");
        for (int j = 0; j < wlen; j++) {
            String[] curr2 = Arrays.copyOf(curr, n);

            for (int i = 0; i < n; i++) {
                curr2[i] += A[i].charAt(j);
            }

            if (isSorted(curr2)) {
                curr = curr2;
            } else {
                res++;
            }
        }

        return res;
    }

    static boolean isSorted(String[] strs) {
        for (int i = 0; i < strs.length - 1; i++) {
            if (strs[i].compareTo(strs[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
}
