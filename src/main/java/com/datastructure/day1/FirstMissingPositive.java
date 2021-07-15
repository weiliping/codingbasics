package com.datastructure.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstMissingPositive {

    public static void main(String args[]) {
//        int nums[] = { 3, 4, -1, 1 };
//        int nums[] = { 7, 8, 9, 11, 12 };
//        System.out.println(firstMissingPositive(nums));
        threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
    }

    static int firstMissingPositive(int a[]) {
        if (a == null || a.length == 0) {
            return 1;
        }
        int n = a.length;
        for (int i = 0; i < n; i++) {
            while (a[i] > 0 && a[i] <= n && a[a[i] - 1] != a[i]) {
                int tmp = a[a[i] - 1];
                a[a[i] - 1] = a[i];
                a[i] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (a[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    static List<List<Integer>> threeSum(int a[]) {
        List<List<Integer>> res = new ArrayList<>();
        if (a == null || a.length == 0) {
            return res;
        }

        int n = a.length;
        Arrays.sort(a);

        for(int i = 0; i < n; i++) {
            int j = i + 1, k = n - 1;
            if (i > 0 && a[i] == a[i - 1]) {
                continue;
            }

            while (j < k) {
                if (k < n - 1 && a[k] == a[k + 1]) {
                    k--;
                    continue;
                }

                if (a[i] + a[j] + a[k] > 0) {
                    k--;
                } else if (a[i] + a[j] + a[k] < 0) {
                    j++;
                } else {
                    List<Integer> subRes = new ArrayList<>();
                    subRes.add(a[i]);
                    subRes.add(a[j]);
                    subRes.add(a[k]);
                    res.add(subRes);
                    j++;
                    k--;
                }
            }
        }
        return res;
    }
}
