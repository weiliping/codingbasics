package com.algorithm.hashing;

import java.util.HashMap;
import java.util.Map;

public class FourSumCount {
    /**
     * #454
     * https://leetcode-cn.com/problems/4sum-ii/
     *
     * @param args
     */
    public static void main(String[] args) {
        int a[] = new int[] { 1, 2 };
        int b[] = new int[] { -2, -1 };
        int c[] = new int[] { -1, 2 };
        int d[] = new int[] { 0, 2 };
        System.out.println(fourSumCount(a, b, c, d));
    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> resMap = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int k = A[i] + B[j];
                resMap.put(k, resMap.getOrDefault(k, 0) + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                res += resMap.getOrDefault(-(C[i] + D[j]), 0);
            }
        }
        return res;
    }
}
