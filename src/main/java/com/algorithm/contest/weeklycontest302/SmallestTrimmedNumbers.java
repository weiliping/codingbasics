package com.algorithm.contest.weeklycontest302;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmallestTrimmedNumbers {
    public static void main(String[] args) {
        String[] nums = new String[] { "102", "473", "251", "814" };
        int[][] queries = new int[][] { { 1, 1 }, { 2, 3 }, { 4, 2 }, { 1, 2 } };
        System.out.println(Arrays.toString(smallestTrimmedNumbers(nums, queries)));

        String[] nums2 = new String[] { "24", "37", "96", "04" };
        int[][] queries2 = new int[][] { { 2, 1 }, { 2, 2 } };
        System.out.println(Arrays.toString(smallestTrimmedNumbers(nums2, queries2)));

        String[] nums3 = new String[] { "111", "111", "111", "111" };
        int[][] queries3 = new int[][] { { 1, 1 }, { 2, 2 } };
        System.out.println(Arrays.toString(smallestTrimmedNumbers(nums3, queries3)));
    }

    public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = nums.length, m = queries.length;
        NumObject[] numObjs = new NumObject[n];
        for (int i = 0; i < n; i++) {
            numObjs[i] = new NumObject(nums[i], i);
        }
        Map<Integer, List<int[]>> queInd = new HashMap<>();
        for (int i = 0; i < m; i++) {
            List<int[]> sub;
            if (queInd.containsKey(queries[i][1])) {
                sub = queInd.get(queries[i][1]);
            } else {
                sub = new ArrayList<>();
            }
            sub.add(new int[] { i, queries[i][0] });
            queInd.put(queries[i][1], sub);
        }
        int len = nums[0].length();
        int[] ans = new int[m];
        for (int j = len - 1; j > -1; j--) {
            NumObject[] temp = new NumObject[n];
            int[] buckets = new int[10];
            for (NumObject obj : numObjs) {
                int ind = obj.num.charAt(j) - '0';
                buckets[ind]++;
            }
            for (int i = 1; i < 10; i++) {
                buckets[i] += buckets[i - 1];
            }

            for (int i = n - 1; i > -1; i--) {
                int bInd = numObjs[i].num.charAt(j) - '0';
                temp[buckets[bInd] - 1] = numObjs[i];
                buckets[bInd]--;
            }
            int k = len - j;
            if (queInd.containsKey(k)) {
                List<int[]> keys = queInd.get(k);
                for (int[] key : keys) {
                    ans[key[0]] = temp[key[1] - 1].i;
                }
            }
            System.arraycopy(temp, 0, numObjs, 0, n);
        }
        return ans;
    }

    static class NumObject {
        String num;
        int i;

        public NumObject(String num, int ind) {
            this.num = num;
            this.i = ind;
        }
    }
}
