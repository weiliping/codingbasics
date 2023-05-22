package com.algorithm.contest.weeklycontest181;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CreateTargetArray {

    public static void main(String[] args) {
        CreateTargetArray c = new CreateTargetArray();
        int[] nums = new int[] { 0, 1, 2, 3, 4 }, index = new int[] { 0, 1, 2, 2, 1 };
        System.out.println(Arrays.toString(c.createTargetArray(nums, index)));

        int[] nums1 = new int[] { 1, 2, 3, 4, 0 }, index1 = new int[] { 0, 1, 2, 3, 0 };
        System.out.println(Arrays.toString(c.createTargetArray(nums1, index1)));

        int[] nums2 = new int[] { 4, 2, 4, 3, 2 }, index2 = new int[] { 0, 0, 1, 3, 1 };
        System.out.println(Arrays.toString(c.createTargetArrayI(nums2, index2)));

        int[] nums3 = new int[] { 7, 6, 5, 5, 5, 4, 5, 5 }, index3 = new int[] { 0, 1, 1, 2, 4, 2, 3, 6 };
        System.out.println(Arrays.toString(c.createTargetArray(nums3, index3)));
        System.out.println(Arrays.toString(c.createTargetArrayI(nums3, index3)));
    }

    public int[] createTargetArrayI(int[] nums, int[] index) {
        List<Integer> arr = new LinkedList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            arr.add(index[i], nums[i]);
        }

        for (int i = 0; i < n; i++) {
            nums[i] = arr.get(i);
        }
        return nums;
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        res[index[0]] = nums[0];
        for (int i = 1; i < n; i++) {
            int k = index[i];
            while (k < n && res[k] != -1) {
                k++;
            }
            if (k == n) {
                return res;
            }
            while (k > index[i]) {
                res[k] = res[k - 1];
                k--;
            }
            res[k] = nums[i];
        }
        return res;
    }
}
