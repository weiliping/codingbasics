/*
 * @lc app=leetcode.cn id=2920 lang=java
 *
 * [2920] 收集所有金币可获得的最大积分
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int maximumPoints(int[][] edges, int[] coins, int k) {
        int n = coins.length;
        ArrayList<Integer>[] nodes = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int p = edge[0], c = edge[1];
            nodes[p].add(c);
            nodes[c].add(p);
        }
        nodes[0].add(-1);
        ArrayList<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        int depth = dfs(nodes, -1, 0, tree);
        depth = Math.min(depth, 13);
        int[][] coinsArray = new int[n][depth + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(coinsArray[i], -1);
        }
        int res = dfsHelper(tree, k, 0, 0, coins, coinsArray);
        return res;
    }

    private static int dfs(ArrayList<Integer>[] nodes, int p, int ind, ArrayList<Integer>[] tree) {
        if (nodes[ind].size() == 1) {
            return 0;
        }
        int d = 0;
        for (Integer ch : nodes[ind]) {
            if (ch == p) {
                continue;
            }
            tree[ind].add(ch);
            d = Math.max(dfs(nodes, ind, ch, tree), d);
        }
        return d + 1;
    }   
    
    private static int dfsHelper(ArrayList<Integer>[] nodes, int k, int ind, int i, int[] coins, int[][] coinsCount) {
        if (coinsCount[ind][i] != -1) {
            return coinsCount[ind][i];
        }
        int curCoin = coins[ind] >> i;
        if (nodes[ind] == null) {
            coinsCount[ind][i] = Math.max(curCoin - k, (curCoin >> 1));
            return coinsCount[ind][i];
        }
        ArrayList<Integer> nArrayList = nodes[ind];
        int sum1 = 0, sum2 = 0;
        for (Integer c : nArrayList) {
            sum1 += dfsHelper(nodes, k, c, i, coins, coinsCount);
            sum2 += dfsHelper(nodes, k, c, Math.min(i + 1, 13), coins, coinsCount);
        }
        sum1 += curCoin - k;
        sum2 += (curCoin >> 1);
        coinsCount[ind][i] = Math.max(sum1, sum2);
        return coinsCount[ind][i];
    }
}
// @lc code=end

