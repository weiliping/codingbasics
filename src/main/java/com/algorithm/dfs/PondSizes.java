package com.algorithm.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pond-sizes-lcci/
 * 水域大小
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 *
 * 示例：
 *
 * 输入：
 * [
 *   [0,2,1,0],
 *   [0,1,0,1],
 *   [1,1,0,1],
 *   [0,1,0,1]
 * ]
 * 输出： [1,2,4]
 * 提示：
 *
 * 0 < len(land) <= 1000
 * 0 < len(land[i]) <= 1000
 *
 */
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
