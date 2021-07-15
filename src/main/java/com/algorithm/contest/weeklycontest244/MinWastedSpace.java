package com.algorithm.contest.weeklycontest244;

import java.util.Arrays;

public class MinWastedSpace {
    public static void main(String[] args) {
        MinWastedSpace m = new MinWastedSpace();
        int[] p1 = new int[] { 2, 3, 5 };
        int[][] b1 = new int[][] { { 4, 8 }, { 2, 8 } };
        System.out.println(m.minWastedSpace(p1, b1));

        int[] p2 = new int[] { 2, 3, 5 };
        int[][] b2 = new int[][] { { 1, 4 }, { 2, 3 }, { 3, 4 } };
        System.out.println(m.minWastedSpace(p2, b2));

        int[] p3 = new int[] { 3, 5, 8, 10, 11, 12 };
        int[][] b3 = new int[][] { { 12 }, { 11, 9 }, { 10, 5, 14 } };
        System.out.println(m.minWastedSpace(p3, b3));

//        String st1 = args[0];
//
//        String[] strs = st1.split(",");
//        int[] pa1 = new int[strs.length];
//        for (int i = 0; i < strs.length; i++) {
//            pa1[i] = Integer.parseInt(strs[i]);
//        }
//        int[][] boxes = new int[][]{{}};
//        System.out.println(m.minWastedSpace(pa1, boxes));
    }

    static int MOD = (int) 1e9 + 7;
    public int minWastedSpace(int[] packages, int[][] boxes) {
        int n = packages.length;
        Arrays.sort(packages);
        for (int[] b : boxes) {
            Arrays.sort(b);
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += packages[i];
        }
        int maxP = packages[n - 1];
        long cnt = Long.MAX_VALUE;
        for (int[] box : boxes) {
            int m = box.length;
            if (box[m - 1] < maxP) {
                continue;
            }
            long subSum = 0;
            int preIdx = -1;
            for (int j = 0; j < m; j++) {
                int l = preIdx, r = n - 1;
                while (l < r) {
                    int mid = (l + r + 1) >> 1;
                    if (packages[mid] > box[j])  {
                        r = mid - 1;
                    } else {
                        l = mid;
                    }
                }
                subSum += (r - preIdx) * (long) box[j];
                preIdx = l;
            }
            subSum -= sum;
            if (cnt > subSum) {
                cnt = subSum;
            }
        }
        if (cnt == Long.MAX_VALUE) {
            return -1;
        }
        return (int) (cnt % MOD);
    }


    static int binarySearch(int[] nums, int v, int n, int i) {
        int j = n - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (nums[mid] == v) {
                if (mid == n - 1 || nums[mid + 1] > v) {
                    return mid;
                }
                i = mid + 1;
            }
            if (nums[mid] > v) {
                if (mid == 0) {
                    return -1;
                }
                if (nums[mid - 1] < v) {
                    return mid - 1;
                }
                j = mid - 1;
                continue;
            }

            if (mid == n - 1) {
                return n - 1;
            }

            if (nums[mid + 1] > v) {
                return mid;
            }
            i = mid + 1;
        }
        return -1;
    }
}
