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
        for (int[] edge : edges) {
            int p = edge[0], c = edge[1];
            tree[p].add(c);
            tree[c].add(p);
        }
        long t = 0;
        for (int v : values) {
            t += v;
        }
        Set<Integer> s = new HashSet<Integer>();
        long minV = dfsHelper(tree, 0, values, s);
        return t - minV;
    }

    private static long dfsHelper(List<Integer>[] tree, int c, int[] values, Set<Integer> s) {
        List<Integer> curNode = tree[c];
        if (curNode == null || curNode.isEmpty()) {
            return values[c];
        }
        s.add(c);
        long sum = 0;
        for (Integer cInd : curNode) {
            if (!s.contains(cInd)) {
                sum += dfsHelper(tree, cInd, values, s);
            }
        }
        return sum > 0 ? Math.min(sum, values[c]) : values[c];
    }
}
// @lc code=end

