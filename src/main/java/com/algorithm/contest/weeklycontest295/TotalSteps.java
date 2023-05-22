package com.algorithm.contest.weeklycontest295;

import java.util.ArrayDeque;

public class TotalSteps {
    public static void main(String[] args) {
        System.out.println(totalSteps(new int[] { 5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11 }));
        System.out.println(totalSteps(new int[] { 4, 5, 7, 7, 13 }));
        System.out.println(totalSteps(new int[] { 10, 1, 2, 3, 4, 5, 6, 1, 2, 3 }));
        System.out.println(totalSteps(new int[] { 12, 3, 9, 4, 10, 8, 9, 3, 4, 2, 1,
                7, 8, 11 }));

        int[] nums = new int[] { 1682, 63, 124, 147, 897, 1210, 1585, 1744, 1764,
                1945, 323, 984, 1886, 346, 481, 1059,
                1388, 1483, 1516, 1842, 1868, 1877, 504, 1197, 785, 955, 970, 1848, 1851,
                398, 907, 995, 1167, 1214,
                1423, 1452, 1464, 1474, 1311, 1427, 1757, 1992, 57, 1625, 1260, 700, 725 };
        System.out.println(totalSteps(nums));
        // ArrayDeque<int[]> stack = new ArrayDeque<>();
        // int n = nums.length;
        // for (int i = 0; i < n; i++) {
        // if (stack.isEmpty()) {
        // stack.push(new int[] { nums[i], i });
        // } else {
        // if (stack.peek()[0] > nums[i]) {
        // System.out.print(nums[i]);
        // System.out.print(", ");
        // } else {
        // System.out.println(" ");
        // stack.push(new int[] { nums[i], i });
        // }
        // }
        // }
        // System.out.println("");
    }

    public static int totalSteps(int[] nums) {
        ArrayDeque<int[]> st = new ArrayDeque<>();
        int n = nums.length, last = n - 1, i = 1, preNum = nums[0];
        int subPre = 0, res = 0;
        while (i < n) {
            if (nums[i] < preNum) {
                if (st.isEmpty()) {
                    st.push(new int[] { 1, nums[i] });
                } else {
                    if (nums[i] < subPre) {
                        if (i < last && nums[i] <= nums[i + 1]) {
                            st.push(new int[] { 1, nums[i] });
                        }
                    } else {
                        int[] cur = st.pop();
                        cur[0]++;
                        cur[1] = nums[i];
                        while (!st.isEmpty()) {
                            int[] next = st.peek();
                            if (next[0] < cur[0]) {
                                st.pop();
                                continue;
                            }
                            if (next[1] <= nums[i]) {
                                cur[0] = next[0] + 1;
                                continue;
                            }
                            break;
                        }
                        st.push(cur);
                    }
                }
                subPre = nums[i];
            } else {
                preNum = nums[i];
                if (!st.isEmpty()) {
                    res = Math.max(res, st.getLast()[0]);
                    st.clear();
                }
            }
            i++;
        }
        if (!st.isEmpty()) {
            res = Math.max(res, st.getLast()[0]);
        }
        return res;
    }
}
