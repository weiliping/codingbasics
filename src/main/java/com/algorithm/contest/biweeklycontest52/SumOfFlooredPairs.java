package com.algorithm.contest.biweeklycontest52;

public class SumOfFlooredPairs {
    public static void main(String[] args) {
        SumOfFlooredPairs s = new SumOfFlooredPairs();
//        int[] nums = new int[] {2,5,9};
//        System.out.println(s.sumOfFlooredPairs(nums));
//
//        int[] nums1 = new int[] {7,7,7,7,7,7,7};
//        System.out.println(s.sumOfFlooredPairs(nums1));

        int[] nums2 = new int[] { 4,3,4,3,5 };
        System.out.println(s.sumOfFlooredPairs(nums2));
    }

    static final int MOD = (int)1e9 + 7;
    public int sumOfFlooredPairs(int[] nums) {
        int n = nums.length, max = maxNum(nums, 0, n - 1), cLen = max + 1;
        int[] cnts = new int[cLen];
        for (int num : nums) {
            cnts[num]++;
        }
        int[] sum = new int[cLen + 1];
        for (int i = 0; i < cLen; i++) {
            sum[i + 1] = sum[i] + cnts[i];
        }
        long res = 0;
        for (int i = 0; i < cLen; i++) {
            if (cnts[i] == 0) {
                continue;
            }
            int j = 1;
            while (true) {
                int sInd = j * i;
                if (sInd > max) {
                    break;
                }
                int eInd = Math.min(cLen, sInd + i);
                long subSum = ((long)(sum[eInd] - sum[sInd])) * j;
                res += cnts[i] * subSum;
                if (sInd >= max) {
                    break;
                }
                j++;
            }
        }
        return (int) (res % MOD);
    }

    static int maxNum(int[] nums, int s, int e) {
        if (s == e) {
            return nums[s];
        }
        if (s + 1 == e) {
            return Math.max(nums[s], nums[e]);
        }
        int mid = s + ((e - s) >> 1);
        return Math.max(maxNum(nums, s, mid - 1), maxNum(nums, mid, e));
    }
}
