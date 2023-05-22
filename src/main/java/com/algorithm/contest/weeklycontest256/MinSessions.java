package com.algorithm.contest.weeklycontest256;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/minimum-number-of-work-sessions-to-finish-the-tasks/
 * 1986. 完成任务的最少工作时间段
 *
 * 你被安排了 n 个任务。任务需要花费的时间用长度为 n 的整数数组 tasks 表示，第 i 个任务需要花费 tasks[i] 小时完成。一个 工作时间段 中，你可以 至多 连续工作 sessionTime 个小时，然后休息一会儿。
 *
 * 你需要按照如下条件完成给定任务：
 *
 * 如果你在某一个时间段开始一个任务，你需要在 同一个 时间段完成它。
 * 完成一个任务后，你可以 立马 开始一个新的任务。
 * 你可以按 任意顺序 完成任务。
 * 给你 tasks 和 sessionTime ，请你按照上述要求，返回完成所有任务所需要的 最少 数目的 工作时间段 。
 *
 * 测试数据保证 sessionTime 大于等于 tasks[i] 中的 最大值 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：tasks = [1,2,3], sessionTime = 3
 * 输出：2
 * 解释：你可以在两个工作时间段内完成所有任务。
 * - 第一个工作时间段：完成第一和第二个任务，花费 1 + 2 = 3 小时。
 * - 第二个工作时间段：完成第三个任务，花费 3 小时。
 * 示例 2：
 *
 * 输入：tasks = [3,1,3,1,1], sessionTime = 8
 * 输出：2
 * 解释：你可以在两个工作时间段内完成所有任务。
 * - 第一个工作时间段：完成除了最后一个任务以外的所有任务，花费 3 + 1 + 3 + 1 = 8 小时。
 * - 第二个工作时间段，完成最后一个任务，花费 1 小时。
 * 示例 3：
 *
 * 输入：tasks = [1,2,3,4,5], sessionTime = 15
 * 输出：1
 * 解释：你可以在一个工作时间段以内完成所有任务。
 *  
 *
 * 提示：
 *
 * n == tasks.length
 * 1 <= n <= 14
 * 1 <= tasks[i] <= 10
 * max(tasks[i]) <= sessionTime <= 15
 *
 *
 */
public class MinSessions {

    public static void main(String[] args) {
        System.out.println(minSessionsI(new int[] { 1, 2, 3 }, 3));
        System.out.println(minSessionsII(new int[] { 1, 2, 3 }, 3));
    }

    public static int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;
        int[][] dp = new int[n + 1][sessionTime + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sessionTime; j++) {
                if (j < tasks[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - tasks[i - 1]] + 1);
            }
        }
        return dp[n][sessionTime];
    }

    static int MAX_VAL = (Integer.MAX_VALUE >> 1);

    public static int minSessionsI(int[] tasks, int sesstionTime) {
        int n = tasks.length, m = (1 << n);
        boolean valid[] = new boolean[m];
        for (int i = 1; i < m; i++) {
            int workTime = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    workTime += tasks[j];
                }
            }
            if (workTime <= sesstionTime) {
                valid[i] = true;
            }
        }

        int[] f = new int[m];
        Arrays.fill(f, MAX_VAL);
        f[0] = 0;
        for (int i = 1; i < m; i++) {
            for (int mask = i; mask > 0; mask = (mask - 1) & i) {
                if (valid[mask]) {
                    f[i] = Math.min(f[i], f[i ^ mask] + 1);
                }
            }
        }
        return f[m - 1];
    }

    public static int minSessionsII(int[] tasks, int sessionTime) {
        Arrays.sort(tasks);
        //答案的上界和下界
        int l = 1, r = tasks.length;
        int num = tasks.length - 1;
        while (l < r) {
            //二分区域
            int mid = (l + r) >> 1;
            //创建桶
            int[] sign = new int[mid];
            //通过递归判断对上下界进行移动
            if (dfs(num, tasks, sign, mid, sessionTime)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        //最终l == r ，l则为最优答案
        return l;
    }

    public static boolean dfs(int index, int[] tasks, int[] sign, int n, int sessionTime) {
        if (index == -1) {
            return true;
        }
        //剪枝，对已经递归过的桶数值进行记录
        boolean[] bl = new boolean[sessionTime + 1];
        for (int i = 0; i < n; i++) {
            //出现过的数值直接跳过
            if (bl[sign[i]]) {
                continue;
            }
            bl[sign[i]] = true;
            int t = tasks[index] + sign[i];
            //放入桶进行下一个任务的放置（进入下层递归）
            if (t <= sessionTime) {
                //更新当前桶的值
                sign[i] = t;
                //当前方案成功放入了所有任务，直接返回true
                if (dfs(index - 1, tasks, sign, n, sessionTime)) {
                    return true;
                }
                //该任务放入当前桶并不能使所有任务都放入桶内，从当前桶中去除该任务，尝试放入其他的桶
                sign[i] -= tasks[index];
            }
        }
        return false;
    }
}
