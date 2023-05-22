package com.algorithm.contest.weeklycontest220;

import java.util.HashMap;
import java.util.Map;

public class MaximumUniqueSubarray {

    public static void main(String[] args) {
//        System.out.println(maximumUniqueSubarray(new int[] { 4, 2, 4, 5, 6 }));
        System.out.println(maximumUniqueSubarray(new int[] { 5, 2, 1, 2, 5, 2, 1, 2, 5 }));
    }
    public static int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int[] sums = new int[n + 1];
        int l = 0, r = 0, cnt = 0;
        while (r < n) {
            sums[r + 1] = sums[r] + nums[r];
            if (!mp.containsKey(nums[r])) {
                mp.put(nums[r], r);
                if (r == n - 1) {
                    int subCnt = sums[r + 1] - sums[l];
                    if (cnt < subCnt) {
                        cnt = subCnt;
                    }
                }
                r++;
                continue;
            }
            int subCnt = sums[r] - sums[l];
            if (cnt < subCnt) {
                cnt = subCnt;
            }
            int lInd = mp.get(nums[r]);
            while (l <= lInd) {
                mp.remove(nums[l]);
                l++;
            }
            mp.put(nums[r], r++);
        }
        return cnt;
    }
}
