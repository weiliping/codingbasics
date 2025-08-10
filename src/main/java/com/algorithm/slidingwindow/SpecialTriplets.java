package com.algorithm.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SpecialTriplets {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 2, 4, 8};
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.merge(num, 1, Integer::sum);;
        }
        System.out.println("111");
    }
    private static final int MOD = (int) 1e9 + 7;
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }
        
        long ans = 0;
        Map<Integer, Integer> pre = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            
            if (countMap.containsKey(x)) {
                countMap.put(x, countMap.get(x) - 1);
            }
            int k = x << 1;
            int countL = pre.getOrDefault(k, 0);
            int countR = countMap.getOrDefault(k, 0);
            ans += countL * countR;
            pre.put(nums[i], pre.getOrDefault(nums[i], 0) + 1);
        }
        return (int) ans % MOD;
    }
}
