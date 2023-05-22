package com.algorithm.contest.weeklycontest241;

import java.util.HashMap;
import java.util.Map;

public class FindSumPairs {

    public static void main(String[] args) {
        FindSumPairs f = new FindSumPairs(new int[] {1,1,2,2,2,3}, new int[]{1,4,5,2,5,4});
        f.count(7); //8
        f.add(3, 2);
        f.count(8); //2
        f.count(4); //1
        f.add(0, 1);
        f.add(1, 1);
        f.count(7); //11

//        int nums1[] = new int[] {9,70,14,9,76}, nums2[] = new int[] { 26, 26, 58, 23, 74, 68, 68, 78, 58, 26 };
//        FindSumPairs f = new FindSumPairs(nums1, nums2);
//        f.add(6,10);
//        f.add(5,6);
//        f.count(32);
//        f.add(3, 55);
//        f.add(9, 32);
//        f.add(9, 16);
//        f.add(1, 48);
//        f.add(1, 4);
//        f.add(0, 52);
//        f.add(8, 20);
//        f.add(9, 4);
//        f.count(88);
    }
    Map<Integer, Integer> mp2 = new HashMap<>();
    int[] nums1;
    int[] nums2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums2.length; i++) {
            mp2.put(nums2[i], mp2.getOrDefault(nums2[i], 0) + 1);
        }
        this.nums1 = nums1;
        this.nums2 = nums2;
    }

    public void add(int index, int val) {
        mp2.put(nums2[index], mp2.get(nums2[index]) - 1);
        nums2[index] += val;
        mp2.put(nums2[index], mp2.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int res = 0;
        for (int num : nums1) {
            if (mp2.containsKey(tot - num)) {
                res += mp2.get(tot - num);
            }
        }
        return res;
    }
}
