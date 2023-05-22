package com.algorithm.contest.weeklycontest223;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/minimize-hamming-distance-after-swap-operations/
 *
 * 1722. 执行交换操作后的最小汉明距离
 * 给你两个整数数组 source 和 target ，长度都是 n 。还有一个数组 allowedSwaps ，其中每个 allowedSwaps[i] = [ai, bi] 表示你可以交换数组 source 中下标为 ai 和 bi（下标从 0 开始）的两个元素。注意，你可以按 任意 顺序 多次 交换一对特定下标指向的元素。
 *
 * 相同长度的两个数组 source 和 target 间的 汉明距离 是元素不同的下标数量。形式上，其值等于满足 source[i] != target[i] （下标从 0 开始）的下标 i（0 <= i <= n-1）的数量。
 *
 * 在对数组 source 执行 任意 数量的交换操作后，返回 source 和 target 间的 最小汉明距离 。
 *
 *
 *
 * 示例 1：
 * 输入：source = [1,2,3,4], target = [2,1,4,5], allowedSwaps = [[0,1],[2,3]]
 * 输出：1
 * 解释：source 可以按下述方式转换：
 * - 交换下标 0 和 1 指向的元素：source = [2,1,3,4]
 * - 交换下标 2 和 3 指向的元素：source = [2,1,4,3]
 * source 和 target 间的汉明距离是 1 ，二者有 1 处元素不同，在下标 3 。
 *
 * 示例 2：
 * 输入：source = [1,2,3,4], target = [1,3,2,4], allowedSwaps = []
 * 输出：2
 * 解释：不能对 source 执行交换操作。
 * source 和 target 间的汉明距离是 2 ，二者有 2 处元素不同，在下标 1 和下标 2 。
 *
 * 示例 3：
 * 输入：source = [5,1,2,4,3], target = [1,5,4,2,3], allowedSwaps = [[0,4],[4,2],[1,3],[1,4]]
 * 输出：0
 *
 *
 * 提示：
 *
 * n == source.length == target.length
 * 1 <= n <= 10^5
 * 1 <= source[i], target[i] <= 10^5
 * 0 <= allowedSwaps.length <= 10^5
 * allowedSwaps[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 *
 */
public class MinimumHammingDistance {

    /**
     * #1722
     * https://leetcode-cn.com/problems/minimize-hamming-distance-after-swap-operations/
     * @param args
     */
    public static void main(String[] args) {
        int[] source = new int[] { 1, 2, 3, 4 };
        int[] target = new int[] { 2, 1, 4, 5 };
        int[][] allowedSwaps = new int[][] { { 0, 1 }, { 2, 3 } };
        System.out.println(minimumHammingDistance(source, target, allowedSwaps));

        int[] source1 = new int[] { 1, 2, 3, 4 };
        int[] target1 = new int[] { 1, 3, 2, 4 };
        int[][] allowedSwaps1 = new int[][]{};
        System.out.println(minimumHammingDistance(source1, target1, allowedSwaps1));

        int[] source3 = new int[] { 5, 1, 2, 4, 3 };
        int[] target3 = new int[] { 1, 5, 4, 2, 3 };
        int[][] allowedSwaps3 = new int[][] { { 0, 4 }, { 4, 2 }, { 1, 3 }, { 1, 4 } };
        System.out.println(minimumHammingDistance(source3, target3, allowedSwaps3));
    }

    static int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = target.length, cnt = 0;
        if (allowedSwaps == null || allowedSwaps.length == 0) {
            for (int i = 0; i < n; i++) {
                if (source[i] != target[i]) {
                    cnt++;
                }
            }
            return cnt;
        }
        int[] parent = new int[n];
        Arrays.setAll(parent, i -> i);
        for (int[] a : allowedSwaps) {
            union(parent, a[0], a[1]);
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int g = find(parent, i);
            if (!map.containsKey(g)) {
                map.put(g, new HashSet<>());
            }
            map.get(g).add(i);
        }

        for (Set<Integer> r : map.values()) {
            cnt += hammingDistance(source, target, r);
        }
        return cnt;
    }

    private static void union(int[] arr, int i, int j) {
        int x = find(arr, i);
        int y = find(arr, j);
        if (x != y) {
            arr[y] = x;
        }
    }

    private static int find(int[] arr, int node) {
        if (arr[node] == node) {
            return node;
        }
        return find(arr, arr[node]);
    }

    static int hammingDistance(int[] source, int[] target, Set<Integer> r) {
        Map<Integer, Integer> s = new HashMap<>();
        for (int i : r) {
            Integer num = s.getOrDefault(source[i], 0);
            s.put(source[i], num + 1);
        }
        int cnt = 0;
        for (int i : r) {
            if (s.containsKey(target[i])) {
                Integer n = s.get(target[i]);
                if (n == 1) {
                    s.remove(target[i]);
                } else {
                    s.put(target[i], n - 1);
                }
            }
        }
        for (Integer i : s.values()) {
            cnt += i;
        }
        return cnt;
    }
}
