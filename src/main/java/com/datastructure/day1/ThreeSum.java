package com.datastructure.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        List<List<Integer>> res = new ThreeSum().threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
        for (List<Integer> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public List<List<Integer>> threeSum(int a[]) {
        if (a == null || a.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(a);
        List<List<Integer>> res = new ArrayList<>();
        int n = a.length;

        for (int i = 0; i < n; i++) {
            if (i > 0 && a[i] == a[i - 1]) {
                continue;
            }
            int j = i + 1, k = n - 1;
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
