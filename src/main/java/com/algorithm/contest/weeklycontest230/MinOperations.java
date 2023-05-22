package com.algorithm.contest.weeklycontest230;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/equal-sum-arrays-with-minimum-number-of-operations/
 * #1775. 通过最少操作次数使数组的和相等
 *
 * 给你两个长度可能不等的整数数组 nums1 和 nums2 。两个数组中的所有值都在 1 到 6 之间（包含 1 和 6）。
 *
 * 每次操作中，你可以选择 任意 数组中的任意一个整数，将它变成 1 到 6 之间 任意 的值（包含 1 和 6）。
 *
 * 请你返回使 nums1 中所有数的和与 nums2 中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1 。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
 * 输出：3
 * 解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
 * - 将 nums2[0] 变为 6 。 nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2] 。
 * - 将 nums1[5] 变为 1 。 nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2] 。
 * - 将 nums1[2] 变为 2 。 nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2] 。
 *
 * 示例 2：
 * 输入：nums1 = [1,1,1,1,1,1,1], nums2 = [6]
 * 输出：-1
 * 解释：没有办法减少 nums1 的和或者增加 nums2 的和使二者相等。
 *
 * 示例 3：
 * 输入：nums1 = [6,6], nums2 = [1]
 * 输出：3
 * 解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
 * - 将 nums1[0] 变为 2 。 nums1 = [2,6], nums2 = [1] 。
 * - 将 nums1[1] 变为 2 。 nums1 = [2,2], nums2 = [1] 。
 * - 将 nums2[0] 变为 4 。 nums1 = [2,2], nums2 = [4] 。
 *  
 *
 * 提示：
 * 1 <= nums1.length, nums2.length <= 105
 * 1 <= nums1[i], nums2[i] <= 6
 */
public class MinOperations {

    public static void main(String[] args) {
//        int nums1[] = new int[] { 1, 2, 3, 4, 5, 6 }, nums2[] = new int[] { 1, 1, 2, 2, 2, 2 };
//        System.out.println(minOperations(nums1, nums2));

        int nums11[] = new int[] { 1, 1, 1, 1, 1, 1, 1 }, nums12[] = new int[] { 6 };
        System.out.println(minOperationsI(nums11, nums12));

        int nums51[] = new int[] { 6, 6 }, nums52[] = new int[] { 1 };
        System.out.println(minOperationsI(nums51, nums52));
//        int nums21[] = new int[] { 6, 6 }, nums22[] = new int[] { 1 };
//        System.out.println(minOperations(nums21, nums22));
//
//        int nums31[] = new int[] { 5,6,4,3,1,2 }, nums32[] = new int[] { 6,3,3,1,4,5,3,4,1,3,4 };
//        System.out.println(minOperations(nums31, nums32));
//
//        int nums41[] = new int[] {5,2,1,5,2,2,2,2,4,3,3,5 }, nums42[] = new int[] { 1,4,5,5,6,3,1,3,3};
//        System.out.println(minOperations(nums41, nums42));
    }
    public static int minOperationsI(int[] nums1, int[] nums2) {
        int n1 = Math.max(nums1.length, nums2.length), n2 = Math.min(nums1.length, nums2.length);
        if (n1 > n2 * 6) {
            return -1;
        }

        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        if (sum1 == sum2) {
            return 0;
        }
        if (sum2 > sum1) {
            return minOperationsI(nums2, nums1);
        }
        int diff = sum1 - sum2;

        int[] freq = new int[7];
        for (int num : nums2) {
            freq[7 - num]++;
        }

        for (int num : nums1) {
            freq[num]++;
        }

        int ans = 0;
        for (int i = 6; i >= 2 && diff > 0; i--) {
            while (freq[i] > 0 && diff > 0) {
                ans++;
                freq[i]--;
                diff -= (i - 1);
            }
        }
        return ans;
    }
    public static int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length, len = n > m ? m : n;
        int[] cnt1 = new int[7], cnt2 = new int[7];
        int sumDiff = 0;
        for (int i = 0; i < len; i++) {
            sumDiff += nums1[i] - nums2[i];
            cnt1[nums1[i]]++;
            cnt2[nums2[i]]++;
        }

        boolean isFirstLong = n > len;
        int end = Math.max(n, m);
        for (int i = len; i < end; i++) {
            if (isFirstLong) {
                sumDiff += nums1[i];
                cnt1[nums1[i]]++;
                continue;
            }
            sumDiff -= nums2[i];
            cnt2[nums2[i]]++;
        }
        if (sumDiff == 0) {
            return 0;
        }
        boolean isFirstGreater = true;
        if (sumDiff < 0) {
            sumDiff = -sumDiff;
            isFirstGreater = false;
        }
        PriorityQueue<int[]> qDesc = new PriorityQueue<>(6, (a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> qAsc = new PriorityQueue<>(6, (a, b) -> a[0] - b[0]);

        for (int i = 1; i < 7; i++) {
            if (isFirstGreater) {
                if (cnt1[i] != 0) {
                    qDesc.offer(new int[] { i, cnt1[i] });
                }
                if (cnt2[i] != 0) {
                    qAsc.offer(new int[] { i, cnt2[i] });
                }
                continue;
            }
            if (cnt2[i] != 0) {
                qDesc.offer(new int[] { i, cnt2[i] });
            }
            if (cnt1[i] != 0) {
                qAsc.offer(new int[] { i, cnt1[i] });
            }
        }
        int res = 0;
        while (!qDesc.isEmpty() || !qAsc.isEmpty()) {
            int bigDiff = 0, smallDiff = 0, bigCnt = 0, smallCnt = 0;
            if (!qDesc.isEmpty()) {
                int[] big = qDesc.peek();
                bigDiff = big[0] - 1;
                bigCnt = big[1];
            }
            if (!qAsc.isEmpty()) {
                int[] small = qAsc.peek();
                smallDiff = 6 - small[0];
                smallCnt = small[1];
            }
            int bigR = bigDiff * bigCnt;
            int smaC = smallDiff * smallCnt;
            if (bigR == 0) {
                while (!qDesc.isEmpty()) {
                    qDesc.poll();
                }
            }
            if (smaC == 0) {
                while (!qAsc.isEmpty()) {
                    qAsc.poll();
                }
            }
            if (bigR == 0 && smaC == 0) {
                break;
            }
            if (bigDiff > smallDiff) {
                if (bigR >= sumDiff) {
                    res += (sumDiff + bigDiff - 1) / bigDiff;
                    return res;
                }
                res += bigCnt;
                sumDiff -= bigR;
                qDesc.poll();
                continue;
            }
            if (smaC > sumDiff) {
                res += (sumDiff + smallDiff - 1) / smallDiff;
                return res;
            }
            res += smallCnt;
            sumDiff -= smaC;
            qAsc.poll();
        }
        return sumDiff != 0 ? -1 : res;
    }
}
