package com.algorithm.contest.weeklycontest310;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class LengthOfLISII {
    public static void main(String[] args) {
        int nums[] = new int[] { 4, 2, 1, 4, 3, 4, 5, 8, 15 }, k = 3;
//        System.out.println(lengthOfLIS(nums, k));
//        System.out.println(lengthOfLISI(nums, k));
        System.out.println(lengthOfLISII(nums, k));
//        System.out.println(lengthOfLISIII(nums, k));
//        int nums1[] = new int[] { 7, 4, 5, 1, 8, 12, 4, 7 }, k1 = 5;
//        System.out.println(lengthOfLIS(nums1, k1));
//        System.out.println(lengthOfLISI(nums1, k1));
//        System.out.println(lengthOfLISII(nums1, k1));
//        System.out.println(lengthOfLISIII(nums1, k1));
//        int nums2[] = new int[] { 1, 5 }, k2 = 1;
//        System.out.println(lengthOfLIS(nums2, k2));
//        System.out.println(lengthOfLISI(nums2, k2));
//        System.out.println(lengthOfLISII(nums2, k2));
//        System.out.println(lengthOfLISIII(nums2, k2));
    }

    public static int lengthOfLIS(int[] nums, int k) {
        int cup = 0, ans = 0;
        for (int num : nums) {
            cup = Math.max(cup, num);
        }
        int[] tree = new int[cup * 4 + 1];
        for (int num : nums) {
            int v = 1;
            if (num > 1) {
                v = query(1, 1, cup, Math.max(1, num - k), num - 1, tree) + 1;
            }
            update(1, 1, cup, num, v, tree);
            ans = Math.max(v, ans);
        }
        return ans;
    }

    private static void update(int cur, int L, int R, int num, int v, int[] tree) {
        if (L == R) {
            tree[cur] = v;
            return;
        }
        tree[cur] = Math.max(tree[cur], v);
        int mid = L + R >> 1;
        if (num <= mid) {
            update(cur * 2, L, mid, num, v, tree);
        } else {
            update(cur * 2 + 1, mid + 1, R, num, v, tree);
        }
    }

    private static int query(int cur, int L, int R, int l, int r, int[] tree) {
        if (l <= L && R <= r) {
            return tree[cur];
        }
        int mid = (L + R) / 2, ans = 0;
        if (l <= mid) {
            ans = query(cur * 2, L, mid, l, r, tree);
        }
        if (r > mid) {
            ans = Math.max(ans, query(cur * 2 + 1, mid + 1, R, l, r, tree));
        }
        return ans;
    }

    public static int lengthOfLISI(int[] nums, int k) {
        int cup = 0;
        for (int num : nums) {
            cup = Math.max(cup, num);
        }
        int[] h = new int[cup + 1], values = new int[cup + 1];
        for (int num : nums) {
            int v = queryI(Math.max(1, num - k), num - 1, h, values) + 1;
            values[num] = v;
            updateI(num, h, values);
        }
        return queryI(1, cup, h, values);
    }

    private static void updateI(int num, int[] h, int[] values) {
        int lx = num, n = values.length;
        while (num < n) {
            h[num] = Math.max(h[num], values[lx]);
            num += lowBit(num);
        }
    }

    private static int queryI(int l, int r, int[] h, int[] values) {
        int ans = 0;
        while (r >= l) {
            ans = Math.max(values[r], ans);
            r--;
            for (; r - lowBit(r) >= l; r -= lowBit(r)) {
                ans = Math.max(h[r], ans);
            }
        }
        return ans;
    }

    private static int lowBit(int x) {
        return x & -x;
    }

    public static int lengthOfLISII(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n], index = new int[n];
        Arrays.fill(dp, 1);
        Integer[] boxIndex = new Integer[n];
        Arrays.setAll(boxIndex, i -> i);
        // 使数值相同角标越大的值排序越靠前,规避合并时非严格递增的问题
        Arrays.sort(boxIndex, (a, b) -> nums[a] == nums[b] ? Integer.compare(b, a) : Integer.compare(nums[a], nums[b]));
        Arrays.setAll(index, i -> boxIndex[i]);
        divideAndConquer(0, n - 1, index, dp, nums, k, new int[n / 2 + 1]);
        int ans = 0;

        for (int i : dp) {
            ans = Math.max(ans, i);
        }
        return ans;
    }

    private static void divideAndConquer(int s, int e, int[] index, int[] dp, int[] nums, int k, int[] dq) {
        if (s >= e) {
            return;
        }
        int mid = s + e >> 1, left = 0, right = 0;
        int[] leftIndex = new int[mid - s + 1], rightIndex = new int[e - mid];
        for (int i : index) {
            if (i <= mid) {
                leftIndex[left++] = i;
            } else {
                rightIndex[right++] = i;
            }
        }
        divideAndConquer(s, mid, leftIndex, dp, nums, k, dq);
        int head = 0, tail = -1;
        for (int i : index) {
            if (i <= mid) {
                while (tail >= head && dp[i] > dp[dq[tail]]) {
                    tail--;
                }
                dq[++tail] = i;
            } else {
                while (tail >= head && nums[dq[head]] + k < nums[i]) {
                    head++;
                }
                if (tail >= head) {
                    dp[i] = Math.max(dp[dq[head]] + 1, dp[i]);
                }
            }
        }
        divideAndConquer(mid + 1, e, rightIndex, dp, nums, k, dq);
    }

    public static int lengthOfLISIII(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int ans = 1;
        for (int num : nums) {
            Map.Entry<Integer, Integer> pre = map.lowerEntry(num);
            int v = pre == null ? 1 : pre.getValue() + 1;
            ans = Math.max(v, ans);
            Map.Entry<Integer, Integer> next = map.floorEntry(num + k);
            Integer fence = next == null ? 0 : next.getValue();
            Iterator<Integer> iterator = map.subMap(num + 1, num + k + 1).values().iterator();
            while (iterator.hasNext() && iterator.next() <= v) {
                iterator.remove();
            }
            map.put(num, v);
            if (fence < v) {
                map.put(num + k, fence);
            }
        }
        return ans;
    }
}
