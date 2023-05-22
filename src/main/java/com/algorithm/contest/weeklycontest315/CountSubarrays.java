package com.algorithm.contest.weeklycontest315;

public class CountSubarrays {

    public static void main(String[] args) {
        int nums[] = new int[] { 1, 3, 5, 2, 7, 5 }, minK = 1, maxK = 5;
        System.out.println(countSubarrays(nums, minK, maxK));
        int nums1[] = new int[] { 1, 1, 1, 1 }, minK1 = 1, maxK1 = 1;
        System.out.println(countSubarrays(nums1, minK1, maxK1));
        int nums2[] = new int[] { 35054, 398719, 945315, 945315, 820417, 945315,
                35054, 945315, 171832, 945315, 35054,
                109750, 790964, 441974, 552913 }, minK2 = 35054, maxK2 = 945315;
        System.out.println(countSubarrays(nums2, minK2, maxK2));

        int nums3[] = new int[] { 978650, 978650, 978650, 68071, 52201, 68071, 186141, 978650, 978650, 267135, 68071,
                717241, 242895, 68071, 582505, 978650, 68071, 68071 };
        int minK3 = 68071, maxK3 = 978650;
        System.out.println(countSubarrays(nums3, minK3, maxK3));
    }

    public static long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int[] rights = new int[n + 1];
        int[] lefts = new int[n + 1];
        for (int i = n - 1; i > -1; i--) {
            if (nums[i] < minK || nums[i] > maxK) {
                continue;
            }
            rights[i] = rights[i + 1] + 1;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                continue;
            }
            lefts[i + 1] = lefts[i] + 1;
        }
        long res = 0l;
        int maxCnt = 0, minCnt = 0, i = 0;
        for (int j = 0; j < n; j++) {
            if (nums[j] < minK || nums[j] > maxK) {
                i = -1;
                maxCnt = 0;
                minCnt = 0;
                continue;
            }
            if (i == -1) {
                i = j;
            }
            if (nums[j] != maxK && nums[j] != minK) {
                continue;
            }
            if (nums[j] == maxK) {
                maxCnt++;
            }

            if (nums[j] == minK) {
                minCnt++;
            }
            int k = i;
            while (maxCnt >= 1 && minCnt >= 1) {
                if (nums[i] == minK) {
                    minCnt--;
                }
                if (nums[i] == maxK) {
                    maxCnt--;
                }
                if (minCnt == 0 || maxCnt == 0) {
                    res += (lefts[i + 1] - lefts[k]) * rights[j];
                }
                i++;
            }
        }
        return res;
    }
}
