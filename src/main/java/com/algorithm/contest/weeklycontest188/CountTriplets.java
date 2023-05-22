package com.algorithm.contest.weeklycontest188;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

    public static void main(String[] args) {
        int[] nums1 = new int[] {2,3,1,6,7};
        System.out.println(countTriplets(nums1));

        int[] nums2 = new int[] {1, 1, 1, 1, 1};
        System.out.println(countTriplets(nums2));

        int[] nums5 = new int[] {2, 3};
        System.out.println(countTriplets(nums5));

        int[] nums4 = new int[] {1,3,5,7,9};
        System.out.println(countTriplets(nums4));

        int[] nums3 = new int[] {7,11,12,9,5,2,7,17,22};
        System.out.println(countTriplets(nums3));
    }

    public static int countTriplets(int[] arr) {
        int n = arr.length;
        int xors = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            xors ^= arr[i];
            if (xors == 0 && i > 0) {
                cnt += i;
            }
            List<Integer> inds = map.getOrDefault(xors, new ArrayList<>());
            if (!inds.isEmpty()) {
                for (int j = inds.size() - 1; j >= 0; j--) {
                    int diff = i - inds.get(j) - 1;
                    if (diff >= 1) {
                        cnt += diff;
                    }
                }
            }
            inds.add(i);
            map.put(xors, inds);
        }
        return cnt;
    }
}
