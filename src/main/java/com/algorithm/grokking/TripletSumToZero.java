package com.algorithm.grokking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {

    public static void main(String[] args) {
//        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
//        System.out.println(remove(arr));
//
//        arr = new int[] { 2, 2, 2, 11 };
//        System.out.println(remove(arr));

//        List<List<Integer>> res = searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2});
//        for (List<Integer> r : res) {
//            System.out.println(Arrays.toString(r.toArray()));
//        }
//        System.out.println(findMissingNumber(new int[]{8, 3, 5, 2, 4, 6, 0, 1}));
        System.out.println(findMissingNumber(new int[]{2, 1, 3, 3, 5, 4}));
    }
    public static int remove(int[] arr) {
        int n = arr.length;
        int l = 0, r = 1;

        for (; r < n; r++) {
            if (arr[l] == arr[r]) {
                continue;
            }
            arr[++l] = arr[r];
        }
        return l + 1;
    }

    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int j = i + 1, k = n - 1;
            while (j < k) {
                if (arr[i] + arr[j] + arr[k] == 0) {
                    List<Integer> sub = new ArrayList<>();
                    sub.add(arr[i]);
                    sub.add(arr[j]);
                    sub.add(arr[k]);
                    triplets.add(sub);
                    j++;
                    k--;
                    continue;
                }
                if (arr[i] + arr[j] + arr[k] > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return triplets;
    }

    public static int findMissingNumber(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int t = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = t;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return nums[i];
            }
        }
        return -1;
    }
}
