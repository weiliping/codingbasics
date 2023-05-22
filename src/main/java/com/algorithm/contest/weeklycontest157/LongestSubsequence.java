package com.algorithm.contest.weeklycontest157;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubsequence {
    public static void main(String[] args) {
        LongestSubsequence l = new LongestSubsequence();
        System.out.println(l.longestSubsequence(new int[] { 1, 2, 3, 4 }, 1));
        System.out.println(l.longestSubsequence(new int[] { 1, 3, 5, 7 }, 1));
        System.out.println(l.longestSubsequence(new int[] { 1, 5, 7, 8, 5, 3, 4, 2, 1 }, -2));
        System.out.println(l.longestSubsequence(new int[] { 4, 12, 10, 0, -2, 7, -8, 9, -9, -12, -12, 8, 8 }, 0));
        System.out.println(
                l.longestSubsequence(new int[] { 10, -11, 8, -1, -14, -5, 7, 15, 7, -2, 14, 5, -3, -9, 12, -9 }, -2));

        System.out.println(l.longestSubsequence(
                new int[] { -54, -63, -62, -69, 55, 48, -67, -94, -46, -48, 91, 99, -3, 77, -85, -52, 15, 57, -19, 46,
                        72, 17, 78, 59, -26, -24, -14, -7, -37, 100, -64, -77, -10, -52, 68, -60, -16, -58, 84, 87, -3,
                        11, -26, -62, -37, -14, -21, 28, -69, 54, 35, 10, -92, 46, -15, 88, -20, 20, -17, -76, -54, -96,
                        61, 3, -52, 4, 88, -54, 66, -96, -31, 10, 78, 44, -6, -34, -97, -72, 34, -93, -71, 6, 17, -100,
                        32, 31, -81, 53, -9, 17, 97, 44, -83, 7, -20, 2, 73, -2, -81, -50 }, 14));
    }

    public int longestSubsequenceI(int[] arr, int difference) {
        int ans = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            int temp = map.getOrDefault(i - difference, 0) + 1;
            map.put(i, temp);
            ans = Math.max(ans, temp);
        }
        return ans;
    }

    public int longestSubsequenceII(int[] arr, int difference) {
        // Dynamic Programming
        // dp[i] 是sequence 结尾是arr[i]的最长长度;
        // function : dp[i] = 1 + dp[i-k]
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            max = Integer.max(max, num);
            min = Integer.min(min, num);
        }
        if (min < 0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] + (-1) * min;
            }
            max = max + (-1) * min;
        }
        int[] dp = new int[max + 1];
        int res = 0;
        for (int num : arr) {
            if (num - difference >= 0 && num - difference <= max) {
                dp[num] = dp[num - difference] + 1;
            } else {
                dp[num] = 1;
            }
            res = Integer.max(res, dp[num]);
        }
        return res;
    }

    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        int n = arr.length, max = 0;

        for (int i = 0; i < n; i++) {
            List<Integer> k = mp.getOrDefault(arr[i], new ArrayList<>());
            k.add(i);
            max = Math.max(0, k.size());
            mp.put(arr[i], k);
        }
        if (difference == 0) {
            return max;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int sub = 1, next = arr[i] + difference, curr = i;
            while (mp.containsKey(next)) {
                List<Integer> r = mp.get(next);
                int ind = greater(r, curr, r.size());
                if (ind == -1) {
                    break;
                }
                sub++;
                curr = r.get(ind);
                next += difference;
            }
            ans = Math.max(sub, ans);
        }
        return ans;
    }

    static int greater(List<Integer> inds, int val, int n) {
        int i = 0, j = n - 1;
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (inds.get(mid) > val) {
                if (mid == 0) {
                    return mid;
                }
                if (inds.get(mid - 1) < val) {
                    return mid;
                }
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }
}
