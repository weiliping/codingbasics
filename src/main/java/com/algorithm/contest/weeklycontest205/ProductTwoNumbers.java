package com.algorithm.contest.weeklycontest205;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ProductTwoNumbers {

    /**
     * #1577
     * https://leetcode-cn.com/problems/number-of-ways-where-square-of-number-is-equal-to-product-of-two-numbers/
     * @param args
     */
    public static void main(String[] args) {
//        int[] nums1 = new int[] {7, 4}, nums2 = new int[] {5, 2, 8, 9};
//        System.out.println(numTriplets(nums1, nums2));

        int[] nums1 = new int[] {1, 1}, nums2 = new int[] {1, 1, 1};
        System.out.println(numTriplets(nums1, nums2));

//        int[] nums1 = new int[] {7, 7, 8, 3}, nums2 = new int[] {1, 2, 9, 7};
//        System.out.println(numTriplets(nums1, nums2));

//        int[] nums1 = new int[] {4,7,9,11,23}, nums2 = new int[] {3,5,1024,12,18};
//        System.out.println(numTriplets(nums1, nums2));
//        int[] nums1 = new int[] {43024,99908}, nums2 = new int[] {1864};
//        System.out.println(numTriplets(nums1, nums1));
    }

    public static int numTriplets(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = toMap(nums1);
        Map<Integer, Integer> map2 = toMap(nums2);
        return getTriplets(map1, map2) + getTriplets(map2, map1);
    }

    static Map<Integer, Integer> toMap(int[] nums1) {
        Map<Integer, Integer> res = new HashMap<>();
        for (int n : nums1) {
            res.put(n, res.getOrDefault(n, 0) + 1);
        }
        return res;
    }

    static int getTriplets(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
        int res = 0;
        Set<Integer> nums1 = map1.keySet();
        Set<Integer> nums2 = map2.keySet();
        for (int n : nums1) {
            int count1 = map1.get(n);
            long tmpRes = (long) n * n;
            for (int n2 : nums2) {
                if (tmpRes % n2 == 0 && tmpRes / n2 <= Integer.MAX_VALUE) {
                    int n3 = (int) (tmpRes / n2);
                    if (n3 == n2) {
                        int count2 = map2.get(n2);
                        res += count1 * count2 * (count2 - 1) / 2;
                    } else if (n2 < n3 && nums2.contains(n3)){
                        int count2 = map2.get(n2);
                        int count3 = map2.get(n3);
                        res += count1 * count2 * count3;
                    }
                }
            }
        }
        return res;
    }
}
