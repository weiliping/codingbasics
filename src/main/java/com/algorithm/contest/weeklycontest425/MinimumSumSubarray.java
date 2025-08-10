package com.algorithm.contest.weeklycontest425;

import java.util.List;

public class MinimumSumSubarray {
    public static void main(String[] args) {
        MinimumSumSubarray m = new MinimumSumSubarray();
        // System.out.println(m.minimumSumSubarray(List.of(3,-2,1,4), 2, 3));
        // System.out.println(m.minimumSumSubarray(List.of(-23, 3), 2, 2));
        // System.out.println(m.minimumSumSubarray(List.of(25, -9), 1, 1));
        System.out.println(m.minimumSumSubarray(List.of(-12, 8), 1, 1));
    }
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int ans = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int n = nums.size();
        int s = 0;
        while (j < n) {
            s += nums.get(j);
            if (j - i + 1 < l) {
                j++;
                continue;
            }
            if (s > 0 && j - i + 1 <= r) {
                ans = Math.min(ans , s);
            }
            int k = j+1;
            int s1 = s;
            while (k < n && k - i + 1 <= r) {
                s1 += nums.get(k);
                if (s1 > 0) {
                    ans = Math.min(ans , s1);
                }
                k++;
            }
            while (j - i + 1 > l) {
                s -= nums.get(i);
                i++;
                if (s > 0 && j - i + 1 <= r) {
                    ans = Math.min(ans , s);
                }    
            }
            j++;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans; 
    }    
}
