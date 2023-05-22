package com.algorithm.contest.weeklycontest218;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * https://leetcode-cn.com/problems/minimum-incompatibility/
 * 1681. 最小不兼容性
 * 给你一个整数数组 nums​​​ 和一个整数 k 。你需要将这个数组划分到 k 个相同大小的子集中，使得同一个子集里面没有两个相同的元素。
 *
 * 一个子集的 不兼容性 是该子集里面最大值和最小值的差。
 *
 * 请你返回将数组分成 k 个子集后，各子集 不兼容性 的 和 的 最小值 ，如果无法分成分成 k 个子集，返回 -1 。
 *
 * 子集的定义是数组中一些数字的集合，对数字顺序没有要求。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,1,4], k = 2
 * 输出：4
 * 解释：最优的分配是 [1,2] 和 [1,4] 。
 * 不兼容性和为 (2-1) + (4-1) = 4 。
 * 注意到 [1,1] 和 [2,4] 可以得到更小的和，但是第一个集合有 2 个相同的元素，所以不可行。
 * 示例 2：
 *
 * 输入：nums = [6,3,8,1,3,1,2,2], k = 4
 * 输出：6
 * 解释：最优的子集分配为 [1,2]，[2,3]，[6,8] 和 [1,3] 。
 * 不兼容性和为 (2-1) + (3-2) + (8-6) + (3-1) = 6 。
 * 示例 3：
 *
 * 输入：nums = [5,3,3,6,3,3], k = 3
 * 输出：-1
 * 解释：没办法将这些数字分配到 3 个子集且满足每个子集里没有相同数字。
 *
 *
 * 提示：
 *
 * 1 <= k <= nums.length <= 16
 * nums.length 能被 k 整除。
 * 1 <= nums[i] <= nums.length
 *
 */
public class MinimumIncompatibility {

    public static void main(String[] args) {
        MinimumIncompatibility m = new MinimumIncompatibility();
        //        int nums[] = new int[] {1, 2, 1, 4}, k = 2;
        //        System.out.println(m.minimumIncompatibility(nums, k));
        //        int nums2[] = new int[] { 6, 3, 8, 1, 3, 1, 2, 2 }, k2 = 4;
        //        System.out.println(m.minimumIncompatibility(nums2, k2));
        //        int nums3[] = new int[] {5,3,3,6,3,3}, k3 = 3;
        //        System.out.println(m.minimumIncompatibility(nums3, k3));
        int nums4[] = new int[] { 10, 4, 4, 2, 11, 10, 8, 9, 1, 2, 2, 10 }, k4 = 4;
        System.out.println(m.minimumIncompatibility(nums4, k4));
    }

    public int minimumIncompatibilityI(int[] nums, int k) {
        k = nums.length / k;
        int n = nums.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int status = 1; status < (1 << n); status++) {
            int curBitCount = Integer.bitCount(status);
            if (curBitCount % k != 0)
                continue;
            for (int pre = status; pre >= 0; pre = (pre - 1) & status) {
                int preBitCount = Integer.bitCount(pre);
                if (preBitCount % k != 0)
                    continue;
                int dif = curBitCount - preBitCount;
                if (dif == k) {
                    if (check(status, pre, nums, dp)) {
                        dp[status] = Math.min(dp[status], dp[pre] + dv);
                    }
                }

                if (pre == 0) {
                    break;
                }
            }
        }
        return dp[dp.length - 1] == Integer.MAX_VALUE / 2 ? -1 : dp[dp.length - 1];
    }

    int dv;
    private boolean check(int cur, int pre, int[] nums, int[] dp) {
        if (dp[pre] == Integer.MAX_VALUE / 2) {
            return false;
        }
        int xor = cur ^ pre;
        int[] map = new int[17];
        int idx = 0;
        while (xor != 0) {
            if ((xor & 1) == 1) {
                map[nums[idx]]++;
            }
            idx++;
            xor >>= 1;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        dv = 0;   //子集的 不兼容性
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 1) {
                max = Math.max(max, i);
                min = Math.min(min, i);
            }
            if (map[i] > 1) {
                return false;
            }
        }
        dv = max - min;
        return true;
    }

    public int minimumIncompatibility(int[] nums, int k) {
        int n = nums.length;
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
        Iterator<Map.Entry<Integer, Integer>> it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> m = it.next();
            if (m.getValue() > k) {
                return -1;
            }
            q.offer(new int[] { m.getKey(), m.getValue() });
        }

        int res = 0, subLen = n / k;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int subMin = Integer.MAX_VALUE, rs = 0, re = 0;
            int l = 1, r = 1;
            Integer key = cur[0];
            Deque<Integer> deque = new ArrayDeque<>();
            deque.addFirst(key);
            while (l < subLen) {
                key = mp.lowerKey(key);
                if (key != null) {
                    deque.addFirst(key);
                    l++;
                    continue;
                }
                break;
            }
            if (deque.size() == subLen) {
                int tre = deque.getLast();
                int trs = deque.pollFirst();
                int subRes = tre - trs;
                if (subMin > subRes) {
                    subMin = subRes;
                    re = tre;
                    rs = trs;
                }
            }
            key = cur[0];
            while (r < subLen) {
                key = mp.higherKey(key);
                if (key != null) {
                    deque.addLast(key);
                    if (deque.size() == subLen) {
                        int tre = deque.getLast();
                        int trs = deque.pollFirst();
                        int subRes = tre - trs;
                        if (subMin > subRes) {
                            subMin = subRes;
                            re = tre;
                            rs = trs;
                        }
                    }
                    r++;
                    continue;
                }
                break;
            }

            res += subMin;
            Integer curKey = rs;
            while (curKey != null && curKey <= re) {
                Integer curVal = mp.get(curKey);
                if (curVal == 1) {
                    mp.remove(curKey);
                } else {
                    mp.put(curKey, curVal - 1);
                }
                curKey = mp.higherKey(curKey);
            }

            q = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
            Iterator<Map.Entry<Integer, Integer>> it1 = mp.entrySet().iterator();
            while (it1.hasNext()) {
                Map.Entry<Integer, Integer> m = it1.next();
                q.offer(new int[] { m.getKey(), m.getValue() });
            }
        }
        return res;
    }
}


