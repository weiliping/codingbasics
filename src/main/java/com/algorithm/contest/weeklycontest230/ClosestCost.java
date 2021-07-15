package com.algorithm.contest.weeklycontest230;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/closest-dessert-cost/
 * #1774. 最接近目标价格的甜点成本
 *
 * 你打算做甜点，现在需要购买配料。目前共有 n 种冰激凌基料和 m 种配料可供选购。而制作甜点需要遵循以下几条规则：
 *
 * 必须选择 一种 冰激凌基料。
 * 可以添加 一种或多种 配料，也可以不添加任何配料。
 * 每种类型的配料 最多两份 。
 *
 * 给你以下三个输入：
 * baseCosts ，一个长度为 n 的整数数组，其中每个 baseCosts[i] 表示第 i 种冰激凌基料的价格。
 * toppingCosts，一个长度为 m 的整数数组，其中每个 toppingCosts[i] 表示 一份 第 i 种冰激凌配料的价格。
 * target ，一个整数，表示你制作甜点的目标价格。
 * 你希望自己做的甜点总成本尽可能接近目标价格 target 。
 *
 * 返回最接近 target 的甜点成本。如果有多种方案，返回 成本相对较低 的一种。
 *
 * 示例 1：
 * 输入：baseCosts = [1,7], toppingCosts = [3,4], target = 10
 * 输出：10
 * 解释：考虑下面的方案组合（所有下标均从 0 开始）：
 * - 选择 1 号基料：成本 7
 * - 选择 1 份 0 号配料：成本 1 x 3 = 3
 * - 选择 0 份 1 号配料：成本 0 x 4 = 0
 * 总成本：7 + 3 + 0 = 10 。
 *
 * 示例 2：
 * 输入：baseCosts = [2,3], toppingCosts = [4,5,100], target = 18
 * 输出：17
 * 解释：考虑下面的方案组合（所有下标均从 0 开始）：
 * - 选择 1 号基料：成本 3
 * - 选择 1 份 0 号配料：成本 1 x 4 = 4
 * - 选择 2 份 1 号配料：成本 2 x 5 = 10
 * - 选择 0 份 2 号配料：成本 0 x 100 = 0
 * 总成本：3 + 4 + 10 + 0 = 17 。不存在总成本为 18 的甜点制作方案。
 *
 * 示例 3：
 * 输入：baseCosts = [3,10], toppingCosts = [2,5], target = 9
 * 输出：8
 * 解释：可以制作总成本为 8 和 10 的甜点。返回 8 ，因为这是成本更低的方案。
 *
 * 示例 4：
 * 输入：baseCosts = [10], toppingCosts = [1], target = 1
 * 输出：10
 * 解释：注意，你可以选择不添加任何配料，但你必须选择一种基料。
 *  
 *
 * 提示：
 * n == baseCosts.length
 * m == toppingCosts.length
 * 1 <= n, m <= 10
 * 1 <= baseCosts[i], toppingCosts[i] <= 104
 * 1 <= target <= 104
 */
public class ClosestCost {
    public static void main(String[] args) {
        int b[] = new int[] { 2, 3 }, t[] = new int[] { 4, 5, 100 }, target = 18;
//        System.out.println(closestCost(b, t, target));
        System.out.println(closestCostI(b, t, target));

        int b1[] = new int[] { 3, 10 }, t1[] = new int[] { 2, 5 }, target1 = 9;
//        System.out.println(closestCost(b1, t1, target1));
        System.out.println(closestCostI(b1, t1, target1));

        int b2[] = new int[] { 10 }, t2[] = new int[] { 1 }, target2 = 1;
//        System.out.println(closestCost(b2, t2, target2));
        System.out.println(closestCostI(b2, t2, target2));
    }

    public static int closestCostI(int bases[], int costs[], int target) {
        int cnt[] = new int[1];
        cnt[0] = Integer.MAX_VALUE;
        for (int b : bases) {
            dfs(b, 0, costs, target, cnt);
        }
        return cnt[0];
    }

    static void dfs(int sum, int idx, int[] costs, int target, int[] cnt) {
        if (sum - target > Math.abs(cnt[0] - target)) {
            return;
        }

        if (idx == costs.length) {
            int diff = Math.abs(sum - target);
            int min = Math.abs(cnt[0] - target);
            if (diff < min || (diff == min && sum < cnt[0])) {
                cnt[0] = sum;
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            dfs(sum + costs[idx] * i, idx + 1, costs, target, cnt);
        }
    }

    public static int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int closest = -1, n = toppingCosts.length;
        int[] topCosts = new int[2 * n];
        for (int i = 0; i < n; i++) {
            topCosts[i] = toppingCosts[i];
            topCosts[n + i] = toppingCosts[i] * 2;
        }
        Arrays.sort(topCosts);

        for (int i = 0; i < baseCosts.length; i++) {
            int subTarget = target - baseCosts[i];
            int subClosest = baseCosts[i];
            if (subTarget > 0) {
                int s = closestTarget(topCosts, subTarget);
                subClosest += s;
            }

            if (closest == -1) {
                closest = subClosest;
            } else {
                int diff = Math.abs(closest - target);
                int curr = Math.abs(subClosest - target);
                if (diff > curr) {
                    closest = subClosest;
                } else if (diff == curr) {
                    if (closest > subClosest) {
                        closest = subClosest;
                    }
                }
            }
        }
        return closest;
    }

    public static int closestTarget(int[] nums, int target) {
        int res = 0, n = nums.length, hn = n / 2;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        queue.offer(new int[] { 0, n - 1 });
        while (!queue.isEmpty()) {
            int[] inds = queue.poll();
            int l = inds[0], r = inds[1];
            boolean inRight = r >= hn;
            while (target > nums[r] && ((inRight && r >= hn) || r >= l)) {
                res += nums[r];
                target -= nums[r];
                r--;
            }

            if ((inRight && r == hn - 1) || r == l - 1) {
                return res;
            }

            if (target < nums[l]) {
                if (queue.isEmpty()) {
                    if (nums[l] - target < target) {
                        res += nums[l];
                    }
                    return res;
                }
                int[] sIndx = queue.peek();

                if (target < nums[sIndx[0]]) {
                    queue.poll();
                    continue;
                }
                if (target < nums[sIndx[1]]) {
                    continue;
                }
                int rDif = nums[l] - target;
                int lDif = target - nums[sIndx[1]];

                if (rDif < lDif) {
                    res += nums[l];
                    return res;
                }
                continue;
            }

            int midIndex = searchClosestTarget(nums, target, l, r);
            res += nums[midIndex];
            if (nums[midIndex] > target) {
                return res;
            }
            target -= nums[midIndex];
            if (l >= hn) {
                queue.remove(new int[] { l - n, r - n });
            }
            if (l == r) {
                continue;
            }
            if (l == midIndex) {
                queue.offer(new int[] { l + 1, r });
                if (l >= hn) {
                    queue.offer(new int[] { l - n + 1, r - n });
                }
            } else if (midIndex == r) {
                queue.offer(new int[] { l, r - 1 });
                if (l >= hn) {
                    queue.offer(new int[] { l - n, r - n - 1 });
                }
            } else {
                queue.offer(new int[] { l, midIndex - 1 });
                queue.offer(new int[] { midIndex + 1, r });
                if (l >= hn) {
                    queue.offer(new int[] { l - n, midIndex - n - 1 });
                    queue.offer(new int[] { midIndex - n + 1, r - n });
                }
            }
        }
        return res;
    }

    public static int searchClosestTarget(int[] nums, int target, int l, int r) {
        int i = l, j = r;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                if (mid == l) {
                    return mid;
                } else if (nums[mid - 1] > target) {
                    j = mid - 1;
                } else {
                    int left = nums[mid] - target;
                    int right = target - nums[mid - 1];
                    if (left >= right) {
                        return mid - 1;
                    } else {
                        return mid;
                    }
                }
            } else {
                if (mid == r) {
                    return mid;
                } else if (nums[mid + 1] < target) {
                    i = mid + 1;
                } else {
                    int left = target - nums[mid];
                    int right = nums[mid + 1] - target;
                    if (left >= right) {
                        return mid + 1;
                    } else {
                        return mid;
                    }
                }
            }
        }
        return -1;
    }
}
