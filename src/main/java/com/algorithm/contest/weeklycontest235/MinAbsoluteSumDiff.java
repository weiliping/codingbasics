package com.algorithm.contest.weeklycontest235;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/minimum-absolute-sum-difference/
 * #1818. 绝对差值和
 *
 * 给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
 *
 * 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
 *
 * 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
 *
 * 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。
 *
 * |x| 定义为：
 *
 * 如果 x >= 0 ，值为 x ，或者
 * 如果 x <= 0 ，值为 -x
 *
 * 示例 1：
 * 输入：nums1 = [1,7,5], nums2 = [2,3,5]
 * 输出：3
 * 解释：有两种可能的最优方案：
 * - 将第二个元素替换为第一个元素：[1,7,5] => [1,1,5] ，或者
 * - 将第二个元素替换为第三个元素：[1,7,5] => [1,5,5]
 * 两种方案的绝对差值和都是 |1-2| + (|1-3| 或者 |5-3|) + |5-5| = 3
 *
 * 示例 2：
 * 输入：nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
 * 输出：0
 * 解释：nums1 和 nums2 相等，所以不用替换元素。绝对差值和为 0
 *
 * 示例 3：
 * 输入：nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
 * 输出：20
 * 解释：将第一个元素替换为第二个元素：[1,10,4,4,2,7] => [10,10,4,4,2,7]
 * 绝对差值和为 |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
 *  
 *
 * 提示：
 * n == nums1.length
 * n == nums2.length
 * 1 <= n <= 105
 * 1 <= nums1[i], nums2[i] <= 105
 *
 */
public class MinAbsoluteSumDiff {
    public static void main(String[] args) {
        int[] nums1 = new int[] { 1, 7, 5 }, nums2 = new int[] { 2, 3, 5 };
        System.out.println(minAbsoluteSumDiff(nums1, nums2));

        int[] nums3 = new int[] { 2, 4, 6, 8, 10 }, nums4 = new int[] { 2, 4, 6, 8, 10 };
        System.out.println(minAbsoluteSumDiff(nums3, nums4));

        int[] nums5 = new int[] { 1, 10, 4, 4, 2, 7 }, nums6 = new int[] { 9, 3, 5, 1, 7, 4 };
        System.out.println(minAbsoluteSumDiff(nums5, nums6));

        int[] nums7 = new int[] { 1, 28, 21 }, nums8 = new int[] { 9, 21, 20 };
        System.out.println(minAbsoluteSumDiff(nums7, nums8));
    }

    static final int MOD = (int) 1e9 + 7;
    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            if (diff > 0) {
                q.offer(new int[] {diff, i});
            }
        }
        if (q.size() == 0) {
            return 0;
        }
        Arrays.sort(nums1);
        int maxDiff = Integer.MIN_VALUE;
        long res = 0l;
        while (!q.isEmpty()) {
            int[] diff = q.poll();
            res += diff[0];
            int minDiff = searchMinDiff(nums1, nums2[diff[1]]);
            if (minDiff < diff[0]) {
                maxDiff = Math.max(maxDiff, diff[0] - minDiff);
                if (!q.isEmpty() && maxDiff >= q.peek()[0]) {
                    break;
                }
            }
        }
        res -= maxDiff;
        while (!q.isEmpty()) {
            int[] diff = q.poll();
            res += diff[0];
        }
        return (int) (res % MOD);
    }

    private static int searchMinDiff(int[] nums1, int target) {
        int l = 0, r = nums1.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums1[mid] > target) {
                if (mid == 0) {
                    return Math.abs(target - nums1[mid]);
                } else {
                    if (nums1[mid - 1] > target) {
                        r = mid - 1;
                    } else {
                        return Math.min(Math.abs(nums1[mid] - target), Math.abs(nums1[mid - 1] - target));
                    }
                }
            } else {
                if (mid == nums1.length - 1) {
                    return Math.abs(target - nums1[mid]);
                } else {
                    if (nums1[mid + 1] <= target) {
                        l = mid + 1;
                    } else {
                        return Math.min(Math.abs(nums1[mid] - target), Math.abs(nums1[mid + 1] - target));
                    }
                }
            }
        }
        return -1;
    }
}
