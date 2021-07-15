package com.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {

    public static void main(String[] args) {
        int[] nums = { 99, 65, 24, 47, 50, 88, 33, 66, 67, 31, 18 };
        bucketSort(nums);
    }

    public static void bucketSort(int[] nums) {

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, n = nums.length;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        int bucketNum = (max - min) / n + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < n; i++) {
            int num = (nums[i] - min) / (n);
            bucketArr.get(num).add(nums[i]);
        }

        for (int i = 0; i < bucketArr.size(); i++) {
            Collections.sort(bucketArr.get(i));
        }

        int index = 0;
        for (ArrayList<Integer> bucketNums : bucketArr) {
            for (Integer num : bucketNums) {
                nums[index++] = num;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
