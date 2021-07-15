package com.algorithm.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public static void main(String[] args) {

        int[] arr = { 3, 8, -10, 23, 19, -4, -14, 27 };

        System.out.println(new MinimumAbsoluteDifference().minimumAbsDifference(arr));

    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            int tempDiff = arr[i + 1] - arr[i];
            minDiff = Math.min(minDiff, tempDiff);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int tempDiff = arr[i + 1] - arr[i];
            if (tempDiff == minDiff) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(arr[i]);
                list.add(arr[i + 1]);
                result.add(list);
            }

        }

        return result;
    }
}
