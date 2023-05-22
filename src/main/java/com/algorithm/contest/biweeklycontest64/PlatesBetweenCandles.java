package com.algorithm.contest.biweeklycontest64;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlatesBetweenCandles {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(platesBetweenCandles("**|**|***|", new int[][] { { 2, 5 }, { 5, 9 } })));
        String s = "***|**|*****|**||**|*";
        int[][] queries = new int[][] { { 1, 17 }, { 4, 5 }, { 14, 17 }, { 5, 11 }, { 15, 16 } };
        System.out.println(Arrays.toString(platesBetweenCandles(s, queries)));
    }

    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int n = queries.length;
        char[] chrs = s.toCharArray();
        int len = chrs.length;
        List<Integer> splits = new ArrayList<>();
        int[] sums = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            if (chrs[i - 1] == '|') {
                splits.add((i - 1));
                sums[i] = sums[i - 1];
                continue;
            }
            sums[i] = sums[i - 1] + 1;
        }
        int sz = splits.size() - 1;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int[] q = queries[i];
            int cnt = sums[q[1] + 1] - sums[q[0]], total = q[1] - q[0] + 1;
            if (cnt + 2 <= total) {
                int l = getGreaterInd(splits, q[0], 0, sz), r = getLessInd(splits, q[1], 0, sz);
                ans[i] = splits.get(r) - splits.get(l)  - r  + l;
            }
        }
        return ans;
    }

    static int getGreaterInd(List<Integer> splits, int v, int l, int r) {
        int i = l, j = r;
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            int cur = splits.get(mid);
            if (cur == v) {
                return mid;
            }
            if (cur > v) {
                if (mid == l || splits.get(mid - 1) < v) {
                    return mid;
                }
                j = mid - 1;
                continue;
            }
            i = mid + 1;
        }
        return -1;
    }

    static int getLessInd(List<Integer> splits, int v, int l, int r) {
        int i = l, j = r;
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            int cur = splits.get(mid);
            if (cur == v) {
                return mid;
            }
            if (cur < v) {
                if (mid == r || splits.get(mid + 1) > v) {
                    return mid;
                }
                i = mid + 1;
                continue;
            }
            j = mid - 1;
        }
        return -1;
    }
}
