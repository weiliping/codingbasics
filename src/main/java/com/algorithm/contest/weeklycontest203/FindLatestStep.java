package com.algorithm.contest.weeklycontest203;

import java.util.ArrayList;
import java.util.List;

public class FindLatestStep {

    public static void main(String[] args) {
        int[] arr1 = new int[] {3,1,5,4,2};
        int m1 = 1;
        System.out.println(findLatestStep(arr1, m1));

        int[] arr = new int[] {3,1,5,4,2};
        int m = 2;
        System.out.println(findLatestStep(arr, m));

        int[] arr2 = new int[] {1};
        int m2 = 1;
        System.out.println(findLatestStep(arr2, m2));

        int[] arr3 = new int[] {2,1};
        int m3 = 2;
        System.out.println(findLatestStep(arr3, m3));
    }

    public static int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if (n == m) {
            return n;
        }
        List<int[]> mp = new ArrayList<>();
        mp.add(new int[] {0, n - 1});
        for (int i = n - 1; i >= 0; i--) {
            int k = arr[i] - 1;
            for (int j = 0; j < mp.size(); j++ ) {
                int[] t = mp.get(j);
                if (t[0] <= k && t[1] >= k) {
                    mp.remove(j);
                    if (k - t[0] == m || t[1] - k == m) {
                        return i;
                    }
                    if (k - t[0] > m) {
                        mp.add(new int[]{t[0], k - 1});
                    }
                    if (t[1] - k > m) {
                        mp.add(new int[]{k + 1, t[1]});
                    }
                    break;
                }
            }
        }
        return -1;
    }
}
