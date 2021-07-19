package com.algorithm.hashing;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    /**
     * #560
     * https://leetcode-cn.com/problems/subarray-sum-equals-k/
     *
     * @param args
     */
    public static void main(String[] args) {
        SubarraySum s = new SubarraySum();
        System.out.println(s.subarraySum(new int[] { 1, 1, 1 }, 2));
        System.out.println(s.subarraySum(new int[] { 1, 2, 3 }, 3));
        System.out.println(s.subarraySum(new int[] { 1 }, 0));
    }

    public int subarraySum(int[] nums, int k) {
        int n = nums.length, cnt = 0;
        int[] sum = new int[n + 1];
        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            sum[i] += sum[i - 1] + nums[i - 1];
            if (sum[i] == k) {
                cnt++;
            }
            int key = sum[i] - k;
            if (sumMap.containsKey(key)) {
                cnt += sumMap.get(key);
            }
            int subCnt = sumMap.getOrDefault(sum[i], 0);
            sumMap.put(sum[i], subCnt + 1);
        }
        return cnt;
    }
}
