package com.algorithm.contest.weeklycontest239;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/minimum-interval-to-include-each-query/
 * #1851. 包含每个查询的最小区间
 *
 * 给你一个二维整数数组 intervals ，其中 intervals[i] = [lefti, righti] 表示第 i 个区间开始于 lefti 、结束于 righti（包含两侧取值，闭区间）。区间的 长度 定义为区间中包含的整数数目，更正式地表达是 righti - lefti + 1 。
 *
 * 再给你一个整数数组 queries 。第 j 个查询的答案是满足 lefti <= queries[j] <= righti 的 长度最小区间 i 的长度 。如果不存在这样的区间，那么答案是 -1 。
 *
 * 以数组形式返回对应查询的所有答案。
 *
 * 示例 1：
 * 输入：intervals = [[1,4],[2,4],[3,6],[4,4]], queries = [2,3,4,5]
 * 输出：[3,3,1,4]
 * 解释：查询处理如下：
 * - Query = 2 ：区间 [2,4] 是包含 2 的最小区间，答案为 4 - 2 + 1 = 3 。
 * - Query = 3 ：区间 [2,4] 是包含 3 的最小区间，答案为 4 - 2 + 1 = 3 。
 * - Query = 4 ：区间 [4,4] 是包含 4 的最小区间，答案为 4 - 4 + 1 = 1 。
 * - Query = 5 ：区间 [3,6] 是包含 5 的最小区间，答案为 6 - 3 + 1 = 4 。
 *
 */
public class MinInterval {
    public static void main(String[] args) {
        MinInterval m = new MinInterval();
        int[][] intervals = new int[][] { { 1, 4 }, { 2, 4 }, { 3, 6 }, { 4, 4 } };
        int[] queries = new int[] { 2, 3, 4, 5 };
        int[] res = m.minInterval(intervals, queries);
        System.out.println(Arrays.toString(res));
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            for (int[] vals : intervals) {
                if (queries[i] >= vals[0] && queries[i] <= vals[1]) {
                    int v = vals[1] - vals[0] + 1;
                    if (res[i] == -1) {
                        res[i] = v;
                        continue;
                    }
                    if (res[i] > v) {
                        res[i] = v;
                    }
                }
            }
        }
        return res;
    }

    public int[] minIntervalI(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int[][] que = new int[queries.length][2];
        for(int i = 0; i < queries.length; i++){
            que[i][0] = queries[i];
            que[i][1] = i;
        }
        Arrays.sort(que, (v1,v2) -> v1[0] - v2[0]);
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> (o1[1] - o1[0]) - (o2[1] - o2[0]));
        int index = 0;
        for(int i = 0; i < queries.length; i++){
            while(index < intervals.length && que[i][0] >= intervals[index][0]){
                queue.offer(new int[]{intervals[index][0], intervals[index][1]});
                index++;
            }
            while(!queue.isEmpty() && queue.peek()[1] < que[i][0]) {
                queue.poll();
            }
            if(!queue.isEmpty()){
                int[] t = queue.peek();
                ans[que[i][1]] = t[1] - t[0] + 1;
            }
        }
        return ans;
    }
}
