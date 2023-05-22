package com.algorithm.greedyalgorithm;

import java.util.ArrayList;

public class DistributeCandy {

    /**
     * https://www.interviewbit.com/problems/distribute-candy/
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        System.out.println(candy(a));
    }

    public static int candy(ArrayList<Integer> A) {
        if (A == null || A.size() == 0) {
            return 0;
        }
        int n = A.size();
        int[] candies = new int[n];
        candies[0] = 1;
        for (int i = 1; i < n; i++) {
            if (A.get(i) > A.get(i - 1)) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        int res = candies[n - 1];

        for (int j = n - 2; j >= 0; j--) {
            int curr = 1;
            if (A.get(j) > A.get(j + 1)) {
                curr = candies[j + 1] + 1;
            }
            res += Math.max(curr, candies[j]);
            candies[j] = curr;
        }
        return res;
    }
}
