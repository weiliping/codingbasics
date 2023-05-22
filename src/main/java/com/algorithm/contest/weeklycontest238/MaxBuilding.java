package com.algorithm.contest.weeklycontest238;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/maximum-building-height/
 * #1840
 *
 * 在一座城市里，你需要建 n 栋新的建筑。这些新的建筑会从 1 到 n 编号排成一列。
 * 这座城市对这些新建筑有一些规定：
 * 每栋建筑的高度必须是一个非负整数。
 * 第一栋建筑的高度 必须 是 0 。
 * 任意两栋相邻建筑的高度差 不能超过  1 。
 * 除此以外，某些建筑还有额外的最高高度限制。这些限制会以二维整数数组 restrictions 的形式给出，其中 restrictions[i] = [idi, maxHeighti] ，表示建筑 idi 的高度 不能超过 maxHeighti 。
 * 题目保证每栋建筑在 restrictions 中 至多出现一次 ，同时建筑 1 不会 出现在 restrictions 中。
 * 请你返回 最高 建筑能达到的 最高高度 。
 *  
 * 示例 1：
 * 输入：n = 5, restrictions = [[2,1],[4,1]]
 * 输出：2
 * 解释：上图中的绿色区域为每栋建筑被允许的最高高度。
 * 我们可以使建筑高度分别为 [0,1,2,1,2] ，最高建筑的高度为 2 。
 */
public class MaxBuilding {
    public static void main(String[] args) {
        MaxBuilding b = new MaxBuilding();
        int n = 5, restrictions[][] = new int[][] { { 2, 1 }, { 4, 1 } };
        System.out.println(b.maxBuilding(n, restrictions));
        int n1 = 10, restrictions1[][] = new int[][] { { 5, 3 }, { 2, 5 }, { 7, 4 }, { 10, 3 } };
        System.out.println(b.maxBuilding(n1, restrictions1));
    }

    public int maxBuilding(int n, int[][] restrictions) {
        List<int[]> res = new ArrayList<>();
        res.add(new int[] { 1, 0 });
        for (int[] r : restrictions) {
            res.add(r);
        }
        res.sort(Comparator.comparingInt(a -> a[0]));
        if (res.get(res.size() - 1)[0] != n) {
            res.add(new int[] { n, n - 1 });
        }

        int m = res.size();

        for (int i = 1; i < m; i++) {
            int[] cur = res.get(i), prev = res.get(i - 1);

            int l2 = prev[1] + (cur[0] - prev[0]);
            if (cur[1] > l2) {
                cur[1] = l2;
                res.set(i, cur);
            }
        }

        for (int j = m - 2; j >= 0; j--) {
            int[] cur = res.get(j), prev = res.get(j + 1);
            int l2 = prev[1] + (prev[0] - cur[0]);
            if (cur[1] > l2) {
                cur[1] = l2;
                res.set(j, cur);
            }
        }

        int ans = 0;

        for (int i = 0; i < m - 1; i++) {

            int[] curr = res.get(i), next = res.get(i + 1);
            int best = ((next[0] - curr[0]) + curr[1] + next[1]) / 2;
            if (ans < best) {
                ans = best;
            }
        }
        return ans;
    }
}
