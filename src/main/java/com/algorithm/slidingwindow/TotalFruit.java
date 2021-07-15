package com.algorithm.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class TotalFruit {
    /**
     * #904
     * https://leetcode-cn.com/problems/fruit-into-baskets/
     * @param args
     */
    public static void main(String[] args) {
        int[] tree = new int[] { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };
        System.out.println(new TotalFruit().totalFruit(tree));
    }

    public int totalFruit(int[] tree) {
        Map<Integer, Integer> types = new HashMap<>();
        int n = tree.length, cnt = 0, start = 0;
        for (int i = 0; i < n; i++) {
            types.put(tree[i], types.getOrDefault(tree[i], 0) + 1);
            while (types.size() > 2) {
                Integer val = types.get(tree[start]);
                val--;
                if (val == 0) {
                    types.remove(tree[start]);
                } else {
                    types.put(tree[start], val);
                }
                start++;
            }
            cnt = Math.max(cnt, i - start + 1);
        }
        return cnt;
    }
}
