package com.algorithm.dynamicprogramming;

public class MaxTurbulenceSize {
    public static void main(String[] args) {
        System.out.println(maxTurbulenceSize(new int[] { 9, 4, 2, 10, 7, 8, 8, 1, 9 }));
    }

    public static int maxTurbulenceSize(int[] A) {
        int ans = 1, anchor = 0, len = A.length;
        for (int i = 1; i < len; i++) {
            int c = Integer.compare(A[i - 1], A[i]);
            if (i == len - 1 || c * Integer.compare(A[i], A[i + 1]) != -1) {
                if (c != 0) {
                    ans = Math.max(ans, i - anchor + 1);
                }
                anchor = i;
            }
        }
        return ans;
    }
}
