package com.algorithm.contest.weeklycontest426;

import java.util.Arrays;

public class GetLargestOutlier {
    public static void main(String[] args) {
        int[] nums = new int[]{6,-31,50,-35,41,37,-42,13};
        GetLargestOutlier g = new GetLargestOutlier();
        System.out.println(g.getLargestOutlier(nums));
    }
    public int getLargestOutlier(int[] nums) {
        Arrays.sort(nums);
        int s = 0;
        int[] cnts = new int[2001];
        for (int num : nums) {
            s += num;
            cnts[num+1000]++;
        }

        for (int i = nums.length - 1; i > -1; i--) {
            int l = s - nums[i];
            if ((l & 1) == 0) {
                int h = (l >> 1) + 1000;
                if (h < 0) {
                    continue;
                }
                if (h == nums[i] + 1000) {
                    if (cnts[h] > 1) {
                        return nums[i];
                    }
                    continue;
                }

                if (cnts[h] > 0) {
                    return nums[i];
                }
            }
        }
        return 0;
    }    
}
