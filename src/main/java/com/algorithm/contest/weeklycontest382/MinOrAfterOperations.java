package com.algorithm.contest.weeklycontest382;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinOrAfterOperations {
    private static final int MASK_LEN = 5;

    public static void main(String[] args) {
        MinOrAfterOperations m = new MinOrAfterOperations();
        int i = -1;
        System.out.println(Integer.toBinaryString(-1));
        // System.out.println(m.minOrAfterOperations(new int[] { 7, 3, 15, 14, 2, 8 },
        // 4));
    }

    public int minOrAfterOperations(int[] nums, int k) {
        int[] mask = new int[MASK_LEN];

        List<Integer>[] indes = new ArrayList[MASK_LEN];
        int n = nums.length;
        int[][] binaryNum = new int[n][MASK_LEN];
        for (int i = 0; i < MASK_LEN; i++) {
            indes[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = 0; j < MASK_LEN; j++) {
                if (((num >> j) & 1) == 1) {
                    binaryNum[i][j] = 1;
                    mask[j] += 1;
                    indes[j].add(i);
                }
            }
        }
        int maxId = n - 1;
        for (int i = MASK_LEN - 1; i > -1; i--) {
            if (mask[i] > k) {
                continue;
            }
            List<Integer> ides = indes[i];
            int[][] selected = new int[n][2];
            int canReduce = 0;
            for (Integer id : ides) {
                if (id != 0 && binaryNum[id - 1][i] == 0) {
                    canReduce += 1;
                    selected[id][0] = -1;
                    continue;
                }
                if (id != maxId && binaryNum[id + 1][i] == 0) {
                    canReduce += 1;
                    selected[id][1] = 1;
                }
            }
            if (canReduce < mask[i]) {
                continue;
            }

            for (Integer id : ides) {
                int[] sId = selected[id];
                int t = 0;
                if (sId[0] != 0) {
                    t = sId[0];
                }
                if (sId[1] != 0) {
                    if (t == 0 || (nums[id] & nums[id + sId[1]]) < (nums[id] & nums[id + t])) {
                        t = sId[1];
                    }
                }
                int nInd = id + t;
                int b = nums[id] & nums[nInd];
                nums[id] = b;
                nums[nInd] = b;
                for (int j = 0; j < MASK_LEN; j++) {
                    if ((binaryNum[id][j] | binaryNum[nInd][j]) == 1) {
                        mask[j] -= 1;
                    }
                }
                k -= 1;
                if (k == 0) {
                    break;
                }
            }
            if (k == 0) {
                break;
            }
        }
        int res = 0;
        System.out.println(Arrays.toString(mask));
        for (int i = 0; i < MASK_LEN; i++) {
            if (mask[i] > 0) {
                res += (1 << i);
            }
        }
        return res;
    }
}
