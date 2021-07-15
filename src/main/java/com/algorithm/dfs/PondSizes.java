package com.algorithm.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PondSizes {

    /**
     * https:¡//leetcode-cn.com/problems/pond-sizes-lcci/
     * @param args
     */
    public static void main(String[] args) {
        int[][] land = new int[][] { { 0, 2, 1, 0 }, { 0, 1, 0, 1 }, { 1, 1, 0, 1 }, { 0, 1, 0, 1 } };
        System.out.println(Arrays.toString(pondSizes(land)));
    }

    static int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
    public static int[] pondSizes(int[][] land) {
        if (land == null || land.length == 0 || land[0] == null || land[0].length == 0) {
            return new int[] {};
        }
        int rLen = land.length, cLen = land[0].length;
        boolean[][] memo = new boolean[rLen][cLen];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                int[] subRes = new int[1];
                dfs(land, i, j, rLen, cLen, memo, subRes);
                if (subRes[0] > 0) {
                    res.add(subRes[0]);
                }
            }
        }
        int[] pondSizes = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            pondSizes[i] = res.get(i);
        }
        return pondSizes;
    }

    static void dfs(int[][] land, int i, int j, int rLen, int cLen, boolean[][] memo, int[] res) {
        if (memo[i][j]){
            return;
        }
        memo[i][j] = true;
        if (land[i][j] == 0) {
            res[0]++;
            for (int k = 0; k < dirs.length; k++) {
                int sunI = i + dirs[k][0];
                int sunJ = j + dirs[k][1];
                if (sunI >= 0 && sunI < rLen && sunJ >= 0 && sunJ < cLen && land[sunI][sunJ] == 0) {
                    dfs(land, sunI, sunJ, rLen, cLen, memo, res);
                }
            }
        }
    }
}
