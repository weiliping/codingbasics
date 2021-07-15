package com.algorithm.contest.weeklycontest230;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/car-fleet-ii/
 * #1776. 车队 II
 *
 * 在一条单车道上有 n 辆车，它们朝着同样的方向行驶。给你一个长度为 n 的数组 cars ，其中 cars[i] = [positioni, speedi] ，它表示：
 *
 * positioni 是第 i 辆车和道路起点之间的距离（单位：米）。题目保证 positioni < positioni+1 。
 * speedi 是第 i 辆车的初始速度（单位：米/秒）。
 * 简单起见，所有车子可以视为在数轴上移动的点。当两辆车占据同一个位置时，我们称它们相遇了。一旦两辆车相遇，它们会合并成一个车队，这个车队里的车有着同样的位置和相同的速度，速度为这个车队里 最慢 一辆车的速度。
 *
 * 请你返回一个数组 answer ，其中 answer[i] 是第 i 辆车与下一辆车相遇的时间（单位：秒），如果这辆车不会与下一辆车相遇，则 answer[i] 为 -1 。答案精度误差需在 10-5 以内。
 *
 * 示例 1：
 * 输入：cars = [[1,2],[2,1],[4,3],[7,2]]
 * 输出：[1.00000,-1.00000,3.00000,-1.00000]
 * 解释：经过恰好 1 秒以后，第一辆车会与第二辆车相遇，并形成一个 1 m/s 的车队。经过恰好 3 秒以后，第三辆车会与第四辆车相遇，并形成一个 2 m/s 的车队。
 *
 * 示例 2：
 * 输入：cars = [[3,4],[5,4],[6,3],[9,1]]
 * 输出：[2.00000,1.00000,1.50000,-1.00000]
 *  
 *
 * 提示：
 * 1 <= cars.length <= 105
 * 1 <= positioni, speedi <= 106
 * positioni < positioni+1
 *
 */
public class CarFleetII {
    public static void main(String[] args) {
        int[][] cars2 = new int[][] { { 3, 4 }, { 5, 4 }, { 6, 3 }, { 9, 1 } };
        System.out.println(Arrays.toString(getCollisionTimes(cars2)));
    }

    public static double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        double[] res = new double[n];
        Arrays.fill(res, -1.0);
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int[] car = cars[i];
            while (!st.isEmpty()) {
                int j = st.peek();
                int[] prev = cars[j];
                if (car[1] <= prev[1] || (res[j] > 0.0 && catchTime(prev, car) > res[j])) {
                    st.pop();
                } else {
                    break;
                }
            }
            if (!st.isEmpty()) {
                res[i] = catchTime(cars[st.peek()], car);
            }
            st.push(i);
        }
        return res;
    }

    static double catchTime(int[] prev, int[] curr) {
        return (double) (prev[0] - curr[0]) / (curr[1] - prev[1]);
    }
}
