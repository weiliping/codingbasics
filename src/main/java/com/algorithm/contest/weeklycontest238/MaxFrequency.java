package com.algorithm.contest.weeklycontest238;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element/
 * #1838
 *
 * 元素的 频数 是该元素在一个数组中出现的次数。
 * 给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
 * 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
 *  
 * 示例 1：
 * 输入：nums = [1,2,4], k = 5
 * 输出：3
 * 解释：对第一个元素执行 3 次递增操作，对第二个元素执 2 次递增操作，此时 nums = [4,4,4] 。
 * 4 是数组中最高频元素，频数是 3 。
 * 示例 2：
 * 输入：nums = [1,4,8,13], k = 5
 * 输出：2
 * 解释：存在多种最优解决方案：
 * - 对第一个元素执行 3 次递增操作，此时 nums = [4,4,8,13] 。4 是数组中最高频元素，频数是 2 。
 * - 对第二个元素执行 4 次递增操作，此时 nums = [1,8,8,13] 。8 是数组中最高频元素，频数是 2 。
 * - 对第三个元素执行 5 次递增操作，此时 nums = [1,4,13,13] 。13 是数组中最高频元素，频数是 2 。
 * 示例 3：
 * 输入：nums = [3,9,6], k = 2
 * 输出：1
 */
public class MaxFrequency {
    public static void main(String[] args) {
        MaxFrequency f = new MaxFrequency();
        System.out.println(f.maxFrequencyII(new int[] { 1, 2, 4 }, 5));
        System.out.println(f.maxFrequency(new int[] { 1, 4, 8, 13 }, 5));
        System.out.println(f.maxFrequency(new int[] { 3, 9, 6 }, 2));
    }

    public int maxFrequencyII(int[] nums, int k) {
        int n = nums.length;
        int res = 1;
        Arrays.sort(nums);
        long total = 0;
        int l = 0;
        for (int r = 1; r < n; r++) {
            total += (long) ((nums[r] - nums[r - 1]) * (r - l));
            while (total > k) {
                total -= nums[r] - nums[l];
                l++;
            }
            int sub = r - l + 1;
            if (res < sub) {
                res = sub;
            }
        }
        return res;
    }

    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        Arrays.sort(nums);
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            int l = 0, r = i;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                int cnt = i - mid + 1;
                int target = nums[i] * cnt - sums[i + 1] + sums[mid];
                int diff = k - target;
                if (diff < 0) {
                    l = mid + 1;
                    continue;
                }
                if (diff == 0 || (mid > 0 && diff < (nums[i] - nums[mid - 1]))) {
                    if (res < cnt) {
                        res = cnt;
                        break;
                    }
                }
                r = mid - 1;
            }

            if (r == 0) {
                break;
            }
        }
        return res;
    }
}
