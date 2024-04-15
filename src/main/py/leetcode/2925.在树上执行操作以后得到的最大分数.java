/*
 * @lc app=leetcode.cn id=2925 lang=java
 *
 * [2925] 在树上执行操作以后得到的最大分数
 */
import java.util.*;
// @lc code=start
class Solution {
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        int n = values.length;
        List<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<Integer>();
        }
        tree[0].add(-1);
        for (int[] edge : edges) {
            int p = edge[0], c = edge[1];
            tree[p].add(c);
            tree[c].add(p);
        }
        long t = 0;
        for (int v : values) {
            t += v;
        }
        long minV = dfsHelper(tree, 0, -1, values);
        return t - minV;
    }

    private static long dfsHelper(List<Integer>[] tree, int c, int p, int[] values) {
        if (tree[c].size() == 1) {
            return values[c];
        }
        long sum = 0;
        for (Integer cInd : tree[c]) {
            if (cInd != p) {
                sum += dfsHelper(tree, cInd, c, values);
            }
        }
        return Math.min(sum, values[c]);
    }
}
// @lc code=end

