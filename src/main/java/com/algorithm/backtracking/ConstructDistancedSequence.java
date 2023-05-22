package com.algorithm.backtracking;

import java.util.Arrays;

public class ConstructDistancedSequence {
    public static void main(String[] args) {
        ConstructDistancedSequence c = new ConstructDistancedSequence();
        for (int i = 1; i <= 2; i++) {
            System.out.println(Arrays.toString(c.constructDistancedSequence(i)));
            // System.out.println(Arrays.toString(c.constructDistancedSequence(i)));
        }
        // System.out.println(Arrays.toString(c.constructDistancedSequence(7)));
        // 5, 2, 4, 2, 3, 5, 4, 3, 1
        // 5,3,1,4,3,5,2,4,2
    }

    public int[] constructDistancedSequenceI(int n) {
        int len = (n << 1) - 1;
        int nums[] = new int[len];
        nums[0] = nums[n] = n;
        int[][] res = new int[1][len];
        dfsHelper(nums, n - 1, n, len, res);
        return res[0];
    }

    public int[] dfsSelf(int[] res, int s, int n, int len, boolean[] visited) {
        if (s == len) {
            return res;
        }

        for (int i = n; i > 0; i--) {
            if (visited[i - 1]) {
                continue;
            }
            if (res[s] != 0) {
                return dfsSelf(res, s + 1, n, len, visited);
            }

            if (i > 1 && (s + i >= len || res[s + i] != 0)) {
                continue;
            }

            visited[i - 1] = true;
            res[s] = i;
            if (i > 1) {
                res[s + i] = i;
            }
            int[] sub = dfsSelf(res, s + 1, n, len, visited);
            if (sub != null) {
                return sub;
            }
            visited[i - 1] = false;
            res[s] = 0;
            if (i > 1) {
                res[s + i] = 0;
            }
        }
        return null;
    }

    public int[] constructDistancedSequence(int n) {
        int len = (n << 1) - 1;
        int res[] = new int[len];
        return dfs(res, 0, n, len, new boolean[n]);
    }

    int[] dfs(int[] res, int s, int n, int len, boolean[] visited) {
        if (s == len) {
            return res;
        }

        if (res[s] != 0) {
            return dfs(res, s + 1, n, len, visited);
        }
        for (int i = n; i > 0; i--) {
            if (visited[i - 1]) {
                continue;
            }
            if (i > 1 && (s + i >= len || res[s + i] != 0)) {
                continue;
            }
            if (i == 1) {
                res[s] = i;
            } else {
                res[s] = res[s + i] = i;
            }
            visited[i - 1] = true;
            int[] r = dfs(res, s + 1, n, len, visited);
            if (r != null) {
                return r;
            }
            visited[i - 1] = false;
            if (i == 1) {
                res[s] = 0;
            } else {
                res[s] = res[s + i] = 0;
            }
        }
        return null;
    }

    void dfsHelper(int[] nums, int s, int n, int len, int[][] res) {
        if (s == 0) {
            System.out.println(Arrays.toString(nums));
            for (int i = 1; i < len; i++) {
                if (res[0][i] == nums[i]) {
                    continue;
                }
                if (res[0][i] < nums[i]) {
                    res[0] = Arrays.copyOf(nums, len);
                }
                break;
            }
            return;
        }

        // 12, 10, 11, 7, 5, 3, 8, 9, 3, 5, 7, 10, 12, 11, 8, 6, 9, 2, 4, 2, 1, 6, 4
        for (int i = 1; i < len; i++) {
            if (res[0][i] == nums[i]) {
                continue;
            }
            if (nums[i] != 0) {
                if (res[0][i] > nums[i]) {
                    return;
                }
            }
            if (res[0][i] > nums[i] && nums[i] != 0) {
                return;
            }
            break;
        }
        // for (int i = 1; i < len; i++) {
        // if (res[0][i] != 0 && nums[i] == 0) {
        // if (res[0][i] < n) {
        // continue;
        // }
        // return;
        // }
        // }
        for (int i = 1; i < len; i++) {
            if (nums[i] == 0) {
                if (s == 1) {
                    nums[i] = 1;
                    dfsHelper(nums, 0, n, len, res);
                    nums[i] = 0;
                }
                if (i + s >= len) {
                    return;
                }
                if (nums[i + s] == 0) {
                    nums[i] = nums[i + s] = s;
                    dfsHelper(nums, s - 1, n, len, res);
                    nums[i] = nums[i + s] = 0;
                }
            }
        }
    }
}
