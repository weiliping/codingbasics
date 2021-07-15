package com.algorithm.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays {

    /**
     * #350
     * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2,2,1};
        int[] nums2 = new int[] {2,2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
        System.out.println(Arrays.toString(intersectI(nums1, nums2)));
    }

    public static int[] intersectI(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] intersect = new int[Math.min(length1, length2)];
        int ind1 = 0, ind2 = 0, ind = 0;
        while (ind1 < length1 && ind2 < length2) {
            if (nums1[ind1] == nums2[ind2]) {
                intersect[ind] = nums1[ind1];
                ind1++;
                ind2++;
                ind++;
                continue;
            }
            if (nums1[ind1] < nums2[ind2]) {
                ind1++;
            } else {
                ind2++;
            }
        }
        return Arrays.copyOfRange(intersect, 0, ind);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();

        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums2) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int num : nums1) {
            if (map.containsKey(num)) {
                if (map.get(num) == 1) {
                    map.remove(num);
                } else {
                    map.put(num, map.get(num) - 1);
                }
                res.add(num);
            }
        }

        int[] resArr = new int[res.size()];
        int i = 0;
        for (Integer r : res) {
            resArr[i++] = r;
        }
        return resArr;
    }
}
