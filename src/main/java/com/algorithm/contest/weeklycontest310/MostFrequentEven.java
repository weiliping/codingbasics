package com.algorithm.contest.weeklycontest310;

public class MostFrequentEven {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,4,4,1};
        System.out.println(mostFrequentEven(nums));
        int[] nums1 = new int[]{4,4,4,9,2,4};
        System.out.println(mostFrequentEven(nums1));
        int[] nums2 = new int[]{29,47,21,41,13,37,25,7};
        System.out.println(mostFrequentEven(nums2));
    }

    public static int mostFrequentEven(int[] nums) {
        int[] cnts = new int[100001];
        int maxK = 0;
        for (int num : nums) {
            if ((num & 1) == 0) {
                cnts[num]++;
                if (maxK < num) {
                    maxK = num;
                }
            }
        }

        int max = 0, ind = -1;
        for (int i = 0; i <= maxK; i += 2) {
            if (cnts[i] != 0 && cnts[i] > max) {
                ind = i;
                max = cnts[i];
            }
        }
        return ind;
    }
}
